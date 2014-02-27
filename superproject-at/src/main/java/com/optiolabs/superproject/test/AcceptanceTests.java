package com.optiolabs.superproject.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.optiolabs.superproject.HelloAndroidActivity;
import com.optiolabs.superproject.R;
import com.robotium.solo.Solo;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberOptions(features = "features")
public class AcceptanceTests extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	Solo solo;
	Activity a;

	public AcceptanceTests() {
		super(HelloAndroidActivity.class);

	}

	@Given("^I have a HelloAndroidActivity$")
	public void I_have_a_HelloAndroidActivity() {
		a = getActivity();
		solo = new Solo(getInstrumentation(), a);
		assertNotNull(a);
	}

	@When("^I press the (\\S+) button$")
	public void I_press_the_s_button(String s) {
		if (s.equals("Foo")) {
			Utils.clickOnView(a, solo.getButton("Foo"));
		} else if (s.equals("Bar")) {
			Utils.clickOnView(a, solo.getButton("Bar"));
		} else {
			fail("Invalid button choice");
		}
	}

	@Then("^I should see (\\S+) in the textview$")
	public void I_should_see_s_in_the_textview(String s) {
		TextView v = (TextView) a.findViewById(R.id.textview);
		String displayed_result = Utils.getViewText(a, v);
		assertEquals(s, displayed_result);
	}

}
