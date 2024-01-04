package com.project.CintaBeautyApp.ui.auth;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.project.CintaBeautyApp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private final Calendar myCalendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener date;

    private TextInputEditText edFullname;
    private TextInputEditText edBirthDate;
    private TextInputEditText edEmail;
    private TextInputEditText edUsername;
    private TextInputEditText edPassword;
    private TextInputEditText edRepeatPassword;
    private MaterialButton btnRegister;
    private TextView btnToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edFullname = findViewById(R.id.ed_fullname);
        edBirthDate = findViewById(R.id.ed_birthdate);
        edEmail = findViewById(R.id.ed_email);
        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        edRepeatPassword = findViewById(R.id.ed_repeatpassword);
        btnRegister = findViewById(R.id.btn_register);
        btnToLogin = findViewById(R.id.btn_to_Login);

        edBirthDate.setInputType(InputType.TYPE_NULL);
        edBirthDate.setKeyListener(null);

        date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        };

        setWhiteStatusBar();
        setListeners();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListeners() {
        edBirthDate.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                new DatePickerDialog(this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
            return false;
        });

        btnRegister.setOnClickListener(v -> {
            if (isValid()) {
                String fullname = Objects.requireNonNull(edFullname.getText()).toString();
                String birthDate = Objects.requireNonNull(edBirthDate.getText()).toString();
                String email = Objects.requireNonNull(edEmail.getText()).toString();
                String username = Objects.requireNonNull(edUsername.getText()).toString();
                String password = Objects.requireNonNull(edPassword.getText()).toString();

                Intent iLogin = new Intent(this, LoginActivity.class);
                iLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                iLogin.putExtra("FULLNAME", fullname);
                iLogin.putExtra("BIRTH_DATE", birthDate);
                iLogin.putExtra("EMAIL", email);
                iLogin.putExtra("USERNAME", username);
                iLogin.putExtra("PASSWORD", password);
                startActivity(iLogin);
            }
        });

        btnToLogin.setOnClickListener(v -> onBackPressed());
    }

    private Boolean isValid() {
        if (edFullname.getText().toString().isEmpty()) {
            edFullname.setError("Fullname must be Filled!");
            return false;
        } else if (edBirthDate.getText().toString().isEmpty()) {
            edBirthDate.setError("Birth Date must be Filled!");
            return false;
        } else if (edEmail.getText().toString().isEmpty()) {
            edEmail.setError("Email must be Filled!");
            return false;
        } else if (edUsername.getText().toString().isEmpty()) {
            edUsername.setError("Username must be Filled!");
            return false;
        } else if (edPassword.getText().toString().isEmpty()) {
            edPassword.setError("Password must be Filled!");
            return false;
        } else if (edRepeatPassword.getText().toString().isEmpty()) {
            edRepeatPassword.setError("Repeat Password must be Filled!");
            return false;
        } else if (!edPassword.getText().toString().equals(edRepeatPassword.getText().toString())) {
            Toast.makeText(this, "Password and Repeat Password doesn't match!", Toast.LENGTH_SHORT).show();
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

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        edBirthDate.setText(dateFormat.format(myCalendar.getTime()));
    }
}