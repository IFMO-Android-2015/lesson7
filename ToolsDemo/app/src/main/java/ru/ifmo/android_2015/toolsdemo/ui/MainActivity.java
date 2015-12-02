package ru.ifmo.android_2015.toolsdemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ru.ifmo.android_2015.toolsdemo.R;

/**
 * Created by alexey.nikitin on 30.11.15.
 */
public final class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void leakClicked(View view) {
        startActivity(new Intent(this, LeakActivity.class));
    }
}
