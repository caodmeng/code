/*
 * Copyright 2015-2019 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package zipkin2.server.internal.elasticsearch;

import com.linecorp.armeria.client.ClientFactory;
import com.linecorp.armeria.client.ClientOptions;
import com.linecorp.armeria.client.ClientOptionsBuilder;
import com.linecorp.armeria.client.Endpoint;
import com.linecorp.armeria.client.WebClient;
import com.linecorp.armeria.client.encoding.HttpDecodingClient;
import com.linecorp.armeria.client.logging.LoggingClientBuilder;
import com.linecorp.armeria.client.metric.MetricCollectingClient;
import com.linecorp.armeria.common.HttpHeaderNames;
import com.linecorp.armeria.common.HttpHeaders;
import com.linecorp.armeria.common.SessionProtocol;
import com.linecorp.armeria.common.logging.LogLevel;
import com.linecorp.armeria.common.metric.MeterIdPrefixFunction;
import java.io.Closeable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import zipkin2.server.internal.elasticsearch.ZipkinElasticsearchStorageProperties.HttpLogging;

// Exposed as a bean so that zipkin-aws can use this for api requests to get initial endpoints.
public class HttpClientFactory implements Function<Endpoint, WebClient>, Closeable {
  final SessionProtocol protocol;
  final ClientOptions options;
  final ClientFactory delegate;
  final int timeout;
  final List<Consumer<ClientOptionsBuilder>> customizers;

  HttpClientFactory(ZipkinElasticsearchStorageProperties es, ClientFactory factory,
    SessionProtocol protocol, List<Consumer<ClientOptionsBuilder>> customizers
  ) {
    this.delegate = factory;
    this.protocol = protocol;
    this.customizers = customizers;
    this.timeout = es.getTimeout();
    HttpLogging httpLogging = es.getHttpLogging();
    ClientOptionsBuilder options = new ClientOptionsBuilder()
      .decorator(MetricCollectingClient.newDecorator(
        MeterIdPrefixFunction.ofDefault("elasticsearch")))
      .decorator(HttpDecodingClient.newDecorator());

    if (httpLogging != HttpLogging.NONE) {
      LoggingClientBuilder loggingBuilder = new LoggingClientBuilder()
        .requestLogLevel(LogLevel.INFO)
        .successfulResponseLogLevel(LogLevel.INFO)
        .requestHeadersSanitizer(headers -> {
          if (!headers.contains(HttpHeaderNames.AUTHORIZATION)) {
            return headers;
          }
          // TODO(anuraaga): Add unit tests after https://github.com/line/armeria/issues/2220
          return headers.toBuilder().set(HttpHeaderNames.AUTHORIZATION, "****").build();
        });
      switch (httpLogging) {
        case HEADERS:
          loggingBuilder.contentSanitizer(unused -> "");
          break;
        case BASIC:
          loggingBuilder.contentSanitizer(unused -> "");
          loggingBuilder.headersSanitizer(unused -> HttpHeaders.of());
          break;
        case BODY:
        default:
          break;
      }
      options.decorator(loggingBuilder.newDecorator());
      if (httpLogging == HttpLogging.BODY) {
        options.decorator(RawContentLoggingClient::new);
      }
    }
    this.options = configureOptionsExceptLogging(options).build();
  }

  @Override public WebClient apply(Endpoint endpoint) {
    return WebClient.of(delegate, protocol, endpoint, options);
  }

  @Override public void close() {
    delegate.close();
  }

  /** This takes care to not expose health checks into wire level logging */
  ClientOptionsBuilder configureOptionsExceptLogging(ClientOptionsBuilder options) {
    options.responseTimeoutMillis(timeout).writeTimeoutMillis(timeout);
    customizers.forEach(c -> c.accept(options));
    return options;
  }
}
