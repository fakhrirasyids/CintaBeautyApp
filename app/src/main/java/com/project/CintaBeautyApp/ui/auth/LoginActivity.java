package com.project.CintaBeautyApp.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.project.CintaBeautyApp.R;
import com.project.CintaBeautyApp.ui.main.MainActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private String fullname;
    private String birthDate;
    private String email;
    private String username;
    private String password;

    private TextInputEditText edUsername;
    private TextInputEditText edPassword;
    private MaterialButton btnLogin;
    private TextView btnToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        btnLogin = findViewById(R.id.btn_login);
        btnToRegister = findViewById(R.id.btn_to_register);

        fullname = getIntent().getStringExtra("FULLNAME");
        birthDate = getIntent().getStringExtra("BIRTH_DATE");
        email = getIntent().getStringExtra("EMAIL");
        username = getIntent().getStringExtra("USERNAME");
        password = getIntent().getStringExtra("PASSWORD");

        setWhiteStatusBar();
        setListeners();
    }

    private void setListeners() {
        btnLogin.setOnClickListener(v -> {
            if (isValid()) {
                if (Objects.requireNonNull(edUsername.getText()).toString().equals(username) && Objects.requireNonNull(edPassword.getText()).toString().equals(password)) {
                    Intent iMain = new Intent(this, MainActivity.class);
                    iMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    iMain.putExtra("FULLNAME", fullname);
                    iMain.putExtra("BIRTH_DATE", birthDate);
                    iMain.putExtra("EMAIL", email);
                    finishAffinity();
                    startActivity(iMain);
                } else {
                    Toast.makeText(this, "Account isn't Registered!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnToRegister.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
    }

    private Boolean isValid() {
        if (Objects.requireNonNull(edUsername.getText()).toString().isEmpty()) {
            edUsername.setError("Username must be Filled!");
            return false;
        } else if (Objects.requireNonNull(edPassword.getText()).toString().isEmpty()) {
            edPassword.setError("Password must be Filled!");
            return false;
        } else {
            return true;
        }
    }

    private void setWhiteStatusBar() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.WHITE);
    }
}