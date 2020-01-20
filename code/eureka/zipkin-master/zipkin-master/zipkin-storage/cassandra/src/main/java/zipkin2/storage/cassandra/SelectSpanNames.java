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
package zipkin2.storage.cassandra;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import java.util.List;
import zipkin2.Call;
import zipkin2.storage.cassandra.internal.call.DistinctSortedStrings;
import zipkin2.storage.cassandra.internal.call.ResultSetFutureCall;

import static com.google.common.base.Preconditions.checkNotNull;
import static zipkin2.storage.cassandra.Schema.TABLE_SERVICE_SPANS;

final class SelectSpanNames extends ResultSetFutureCall<ResultSet> {

  static class Factory {
    final Session session;
    final PreparedStatement preparedStatement;
    final DistinctSortedStrings spans = new DistinctSortedStrings("span");

    Factory(Session session) {
      this.session = session;
      this.preparedStatement =
        session.prepare(QueryBuilder.select("span")
          .from(TABLE_SERVICE_SPANS)
          .where(QueryBuilder.eq("service", QueryBuilder.bindMarker("service")))
          .limit(QueryBuilder.bindMarker("limit_")));
    }

    Call<List<String>> create(String serviceName) {
      if (serviceName == null || serviceName.isEmpty()) return Call.emptyList();
      String service = checkNotNull(serviceName, "serviceName").toLowerCase();
      return new SelectSpanNames(this, service).flatMap(spans);
    }
  }

  final Factory factory;
  final String service;

  SelectSpanNames(Factory factory, String service) {
    this.factory = factory;
    this.service = service;
  }

  @Override protected ResultSetFuture newFuture() {
    return factory.session.executeAsync(factory.preparedStatement.bind()
      .setString("service", service)
      .setInt("limit_", 10000));
  }

  @Override public ResultSet map(ResultSet input) {
    return input;
  }

  @Override public String toString() {
    return "SelectSpanNames{service=" + service + "}";
  }

  @Override public SelectSpanNames clone() {
    return new SelectSpanNames(factory, service);
  }
}
