package com.project.CintaBeautyApp.ui.intro;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.CintaBeautyApp.R;
import com.project.CintaBeautyApp.ui.auth.LoginActivity;

public class ThirdFragment extends Fragment {

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDone = view.findViewById(R.id.btn_done);

        btnDone.setOnClickListener(v -> startActivity(new Intent(requireActivity(), LoginActivity.class)));
    }
}