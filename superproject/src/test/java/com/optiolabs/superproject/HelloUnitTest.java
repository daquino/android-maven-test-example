package com.optiolabs.superproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;

@RunWith(SuperTestRunner.class)
public class HelloUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testActivityLifecycle() {
		HelloAndroidActivity activity = Robolectric
				.buildActivity(HelloAndroidActivity.class).create().visible()
				.get();
		activity.finish();
	}

	@Test
	public void testMock() {
		Object imaginaryDatabase = Mockito.mock(Object.class);
		Mockito.when(imaginaryDatabase.toString()).thenReturn("cool!");
		assertEquals(imaginaryDatabase.toString(), "cool!");
	}

	@Test
	public void testFoo() {
		HelloAndroidActivity activity = new HelloAndroidActivity();
		assertTrue(activity.foo() == 2);
	}

	@Test
	public void testBar() {
		HelloAndroidActivity activity = new HelloAndroidActivity();
		assertTrue(activity.bar() == 3);
	}

}
