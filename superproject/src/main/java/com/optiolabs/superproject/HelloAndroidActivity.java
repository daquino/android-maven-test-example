package com.optiolabs.superproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HelloAndroidActivity extends Activity {

	private TextView textview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(getClass().getName(), "onCreate()");
		setContentView(R.layout.activity_main);
		textview = (TextView) findViewById(R.id.textview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void clickFoo(View v) {
		textview.setText("result" + foo());
	}

	public void clickBar(View v) {
		textview.setText("result" + bar());
	}

	public int foo() {
		return 2;
	}

	public int bar() {
		return 3;
	}

}
