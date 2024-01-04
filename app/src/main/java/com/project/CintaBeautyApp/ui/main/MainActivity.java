package com.project.CintaBeautyApp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.project.CintaBeautyApp.R;
import com.project.CintaBeautyApp.databinding.ActivityMainBinding;
import com.project.CintaBeautyApp.ui.auth.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private String fullname;
    private String email;
    private String birthDate;

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fullname = getIntent().getStringExtra("FULLNAME");
        email = getIntent().getStringExtra("EMAIL");
        birthDate = getIntent().getStringExtra("BIRTH_DATE");

        setSupportActionBar(binding.appBarMain.toolbar);

        drawer = binding.drawerLayout;
        navigationView = binding.navView;

        setNavHeaderProfile();
        setNavbarConfiguration();
    }

    private void setNavHeaderProfile() {
        View headerView = navigationView.getHeaderView(0);
        TextView tvFullname = headerView.findViewById(R.id.tv_fullname);
        TextView tvEmail = headerView.findViewById(R.id.tv_email);
        TextView tvBirthDate = headerView.findViewById(R.id.tv_birth_date);

        tvFullname.setText(fullname);
        tvEmail.setText(email);
        tvBirthDate.setText(new StringBuilder("Birth Date : " + birthDate));
    }

    private void setNavbarConfiguration() {
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_event, R.id.nav_gallery, R.id.nav_contact_us, R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_logout: {
                    Intent iLogin = new Intent(MainActivity.this, LoginActivity.class);
                    finishAffinity();
                    startActivity(iLogin);
                }
                default: {
                    navController.navigate(item.getItemId());
                }
            }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });
        binding.appBarMain.toolbar.setTitle("Cinta Beauty App");
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}