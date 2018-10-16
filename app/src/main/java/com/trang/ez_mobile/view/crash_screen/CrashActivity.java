package com.trang.ez_mobile.view.crash_screen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ActivityCrashBinding;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

public class CrashActivity extends AppCompatActivity {
    ActivityCrashBinding crashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crashBinding = DataBindingUtil.setContentView(this, R.layout.activity_crash);

        crashBinding.btnRestartApp.setOnClickListener(v -> {
            CustomActivityOnCrash.restartApplication(CrashActivity.this, CustomActivityOnCrash.getConfigFromIntent(getIntent()));
        });
        Log.w("CrashActivity", "onCreate: " +
                CustomActivityOnCrash.getAllErrorDetailsFromIntent(getBaseContext(), getIntent()));

        crashBinding.btnErrorDetails.setOnClickListener(v -> {
            String error = CustomActivityOnCrash.getAllErrorDetailsFromIntent(App.getInstance(), getIntent());
            Log.w("CrashActivity", "onCreate: " + error);
            Toast.makeText(getBaseContext(), error, Toast.LENGTH_LONG).show();
        });
    }
}
