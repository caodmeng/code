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
import moment from 'moment';

class Graph {
  constructor(rawDependencies) {
    this.nodes = [];
    this.edges = [];
    this._createdTs = moment().valueOf();

    rawDependencies.forEach(
      edge => this.addEdge(edge),
    );
  }

  addEdge(edge) {
    if (!this.allNodeNames().includes(edge.parent)) {
      this.nodes.push({
        name: edge.parent,
      });
    }
    if (!this.allNodeNames().includes(edge.child)) {
      this.nodes.push({
        name: edge.child,
      });
    }
    this.edges.push({
      source: edge.parent,
      target: edge.child,
      metrics: {
        normal: edge.callCount || 0,
        danger: edge.errorCount || 0,
      },
    });
  }

  allNodeNames() {
    return this.nodes.map(node => node.name);
  }

  allNodes() {
    return this.nodes;
  }

  allEdges() {
    return this.edges;
  }

  createdTs() {
    return this._createdTs;
  }

  getTargetEdges(serviceName) {
    return this.allEdges().filter(edge => edge.source === serviceName);
  }

  getSourceEdges(serviceName) {
    return this.allEdges().filter(edge => edge.target === serviceName);
  }
}

export default Graph;
