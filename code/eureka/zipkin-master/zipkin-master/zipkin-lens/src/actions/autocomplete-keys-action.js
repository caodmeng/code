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
import * as api from '../constants/api';

export const fetchAutocompleteKeysRequest = () => ({
  type: types.FETCH_AUTOCOMPLETE_KEYS_REQUEST,
});

export const fetchAutocompleteKeysSuccess = autocompleteKeys => ({
  type: types.FETCH_AUTOCOMPLETE_KEYS_SUCCESS,
  autocompleteKeys,
});

export const fetchAutocompleteKeysFailure = () => ({
  type: types.FETCH_AUTOCOMPLETE_KEYS_FAILURE,
});

export const fetchAutocompleteKeys = () => async (dispatch) => {
  dispatch(fetchAutocompleteKeysRequest());
  try {
    const res = await fetch(api.AUTOCOMPLETE_KEYS);
    if (!res.ok) {
      throw Error(res.statusText);
    }
    const autocompleteKeys = await res.json();
    dispatch(fetchAutocompleteKeysSuccess(autocompleteKeys));
  } catch (err) {
    dispatch(fetchAutocompleteKeysFailure());
  }
};
