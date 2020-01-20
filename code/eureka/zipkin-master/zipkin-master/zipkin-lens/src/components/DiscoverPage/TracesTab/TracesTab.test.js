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
import React from 'react';
import { shallow } from 'enzyme';

import { TracesTab } from './TracesTab';

describe('<TracesTab />', () => {
  let wrapper;

  const props = {
    traceSummaries: [
      {
        traceId: '1',
        timestamp: 1,
        duration: 1,
        durationStr: '1μs',
        serviceSummaries: [],
        spanCount: 1,
        width: 1,
      },
      {
        traceId: '2',
        timestamp: 2,
        duration: 2,
        durationStr: '2μs',
        serviceSummaries: [],
        spanCount: 2,
        width: 2,
      },
    ],
    classes: {},
  };

  beforeEach(() => {
    wrapper = shallow(
      <TracesTab {...props} />,
    );
  });

  it('should render the number of results', () => {
    expect(wrapper.find('[data-test="count-results"]').text()).toBe('2 Results');
  });
});
