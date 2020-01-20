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
import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import fetchMock from 'fetch-mock';

import * as actions from './autocomplete-values-action';
import * as types from '../constants/action-types';
import * as api from '../constants/api';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('autocomplete-values async actions', () => {
  afterEach(() => {
    fetchMock.restore();
  });

  it('create FETCH_AUTOCOMPLETE_VALUES_SUCCESS when fetching autocomplete values has been done', () => {
    fetchMock.getOnce(`${api.AUTOCOMPLETE_VALUES}?key=environment`, {
      body: ['beta', 'release'],
      headers: {
        'content-type': 'application/json',
      },
    });

    const expectedActions = [
      { type: types.FETCH_AUTOCOMPLETE_VALUES_REQUEST },
      {
        type: types.FETCH_AUTOCOMPLETE_VALUES_SUCCESS,
        autocompleteValues: ['beta', 'release'],
      },
    ];
    const store = mockStore();

    return store.dispatch(actions.fetchAutocompleteValues('environment')).then(() => {
      expect(store.getActions()).toEqual(expectedActions);
    });
  });
});
