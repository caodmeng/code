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
package zipkin2.storage.cassandra.v1;

import org.junit.Test;
import zipkin2.Component;

import static org.assertj.core.api.Assertions.assertThat;

public class CassandraStorageTest {
  /**
   * The {@code toString()} of {@link Component} implementations appear in health check endpoints.
   * Since these are likely to be exposed in logs and other monitoring tools, care should be taken
   * to ensure {@code toString()} output is a reasonable length and does not contain sensitive
   * information.
   */
  @Test public void toStringContainsOnlySummaryInformation() {
    try (CassandraStorage cassandra =
           CassandraStorage.newBuilder().contactPoints("1.1.1.1").build()) {

      assertThat(cassandra)
        .hasToString("CassandraStorage{contactPoints=1.1.1.1, keyspace=zipkin}");
    }
  }
}
