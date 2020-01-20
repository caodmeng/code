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
import * as types from '../constants/action-types';

const initialState = {
  isLoading: false,
  dependencies: [],
};

const dependencies = (state = initialState, action) => {
  switch (action.type) {
    case types.FETCH_DEPENDENCIES_REQUEST:
      return {
        ...state,
        isLoading: true,
      };
    case types.FETCH_DEPENDENCIES_SUCCESS:
      return {
        ...state,
        isLoading: false,
        dependencies: action.dependencies,
      };
    case types.FETCH_DEPENDENCIES_FAILURE:
      return {
        ...state,
        isLoading: false,
        dependencies: [],
      };
    case types.CLEAR_DEPENDENCIES:
      return {
        ...state,
        dependencies: [],
      };
    default:
      return state;
  }
};

export default dependencies;
