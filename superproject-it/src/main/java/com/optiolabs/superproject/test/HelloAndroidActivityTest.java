package com.optiolabs.superproject.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import com.optiolabs.superproject.R;
import com.optiolabs.superproject.HelloAndroidActivity;
import com.robotium.solo.Solo;

public class HelloAndroidActivityTest extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	public HelloAndroidActivityTest() {
		super(HelloAndroidActivity.class);
	}

	public void testActivity() {
		HelloAndroidActivity activity = getActivity();
		assertNotNull(activity);
	}

	@UiThreadTest
	public void testClickBar() {
		HelloAndroidActivity activity = getActivity();
		Solo solo = new Solo(getInstrumentation(), activity);
		activity.clickBar(null);
		assertTrue(solo.waitForText("result3"));
	}

	@UiThreadTest
	public void testClickFoo() {
		HelloAndroidActivity activity = getActivity();
		activity.clickFoo(null);
		assertTrue(((TextView) activity.findViewById(R.id.textview)).getText()
				.toString().equalsIgnoreCase("result2"));
	}
}
