package ru.ifmo.android_2015.toolsdemo.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * Created by alexey.nikitin on 30.11.15.
 */
public final class WeakActivity extends Activity {
    private byte [] array = new byte [10_000_000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new MyAsyncTask(this).execute((Void)null);
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeakReference<Activity> activityRef;

        public MyAsyncTask(Activity activity) {
            this.activityRef = new WeakReference<>(activity);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(30_000);
            } catch (InterruptedException e) {
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            final Activity activity = activityRef.get();
            if (activity != null) {
                // TODO ...
            }
        }
    }
}
