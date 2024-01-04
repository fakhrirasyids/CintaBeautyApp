package com.project.CintaBeautyApp.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.project.CintaBeautyApp.R;
import com.project.CintaBeautyApp.ui.intro.IntroActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setWhiteStatusBar();

        new Handler().postDelayed(() -> {
            Intent goLogin = new Intent(SplashActivity.this, IntroActivity.class);
            startActivity(goLogin);
            finish();
        }, 1750);
    }

    private void setWhiteStatusBar() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.WHITE);
    }
}