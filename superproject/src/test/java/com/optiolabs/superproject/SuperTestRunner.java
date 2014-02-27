package com.optiolabs.superproject;

import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;
import org.robolectric.DefaultTestLifecycle;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.TestLifecycle;

public class SuperTestRunner extends RobolectricTestRunner {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends TestLifecycle> getTestLifecycleClass() {
		return TestLifeCycleWithInjection.class;
	}

	public SuperTestRunner(Class<?> klass) throws InitializationError {
		super(klass);

	}

	public static class TestLifeCycleWithInjection extends DefaultTestLifecycle {

		@Override
		public void prepareTest(Object test) {
			// fix up all the mocks in the test
			MockitoAnnotations.initMocks(test);
		}
	}

}