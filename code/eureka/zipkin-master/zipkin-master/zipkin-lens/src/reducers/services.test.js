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
import reducer from './services';
import * as types from '../constants/action-types';

describe('services reducer', () => {
  it('should return the initial state', () => {
    expect(reducer(undefined, {})).toEqual({
      isLoading: false,
      services: [],
    });
  });

  it('should handle FETCH_SERVICES_REQUEST', () => {
    expect(
      reducer(undefined, {
        type: types.FETCH_SERVICES_REQUEST,
      }),
    ).toEqual({
      isLoading: true,
      services: [],
    });
  });

  it('should handle FETCH_SERVICES_SUCCESS', () => {
    expect(
      reducer({
        isLoading: true,
        services: ['service1', 'service2', 'service3'],
      }, {
        type: types.FETCH_SERVICES_SUCCESS,
        services: ['serviceA', 'serviceB', 'serviceC'],
      }),
    ).toEqual({
      isLoading: false,
      services: ['serviceA', 'serviceB', 'serviceC'],
    });
  });

  it('should handle FETCH_SERVICES_FAILURE', () => {
    expect(
      reducer({
        isLoading: true,
        services: ['service1', 'service2', 'service3'],
      }, {
        type: types.FETCH_SERVICES_FAILURE,
      }),
    ).toEqual({
      isLoading: false,
      services: [],
    });
  });
});
