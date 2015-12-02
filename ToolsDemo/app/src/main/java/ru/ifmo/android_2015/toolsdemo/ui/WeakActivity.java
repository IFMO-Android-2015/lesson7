package ru.ifmo.android_2015.toolsdemo.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexey.nikitin on 30.11.15.
 */
public final class WeakActivity extends Activity {
    private byte [] array = new byte [10_000_000];
    private Map hashMap = new HashMap();
    private Map arrayMap = new ArrayMap();
    private SparseArray sparseArray = new SparseArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(i, new Object());
            arrayMap.put(i, new Object());
            sparseArray.put(i, new Object());
        }

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(30_000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        }.execute((Void)null);
    }
}
