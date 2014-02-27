package com.optiolabs.superproject.test;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public final class Utils {
	private static final MultiLock lock = new MultiLock();

	public static class MultiLock {
		private int mLocks;

		public synchronized void acquire() throws InterruptedException {
			if (mLocks++ >= 0) {
				wait();
			}
		}

		public synchronized void release() {
			if (--mLocks <= 0) {
				notifyAll();
			}
		}
	}

	private Utils() {
	}

	public static void clickOnView(Activity activity, int id) {
		View view = activity.findViewById(id);
		if (view != null)
			clickOnView(activity, view);
	}

	public static void clickOnView(Activity activity, final View view) {
		activity.runOnUiThread(new Runnable() {

			public void run() {
				view.performClick();
				lock.release();
			}
		});
		try {
			lock.acquire();
		} catch (InterruptedException e) {
			Log.e("cucumber-android", e.toString());
		}
	}

	public static String getViewText(Activity activity, final TextView view) {
		final StringBuilder builder = new StringBuilder();
		activity.runOnUiThread(new Runnable() {

			public void run() {
				builder.append(view.getText().toString());
				lock.release();
			}
		});
		try {
			lock.acquire();
		} catch (InterruptedException e) {
			Log.e("cucumber-android", e.toString());
		}
		return builder.toString();
	}
}