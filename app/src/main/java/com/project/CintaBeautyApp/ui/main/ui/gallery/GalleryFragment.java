package com.project.CintaBeautyApp.ui.main.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.project.CintaBeautyApp.R;
import com.project.CintaBeautyApp.adapter.GalleryGridAdapter;
import com.project.CintaBeautyApp.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    String[] maintitle = {
            "Kontes Kecantikan Miss Universe Indonesia",
            "Fashion Week Jakarta",
            "Jakarta Cosmetics Expo",
            "Jakarta Bridal Fashion Week",
            "Indonesia Beauty Expo",
            "Kontes Kecantikan Miss World Indonesia",
            "Jakarta Hair & Beauty Expo",
            "Indonesia Make Up Competition",
            "Indonesia Nail Art Festival",
            "Asia Pacific Hair & Beauty Expo"
    };

    Integer[] imgid = {
            R.drawable.gallery1,
            R.drawable.gallery2,
            R.drawable.gallery3,
            R.drawable.gallery4,
            R.drawable.gallery5,
            R.drawable.gallery6,
            R.drawable.gallery7,
            R.drawable.gallery8,
            R.drawable.gallery9,
            R.drawable.gallery10
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);

        GalleryGridAdapter adapter = new GalleryGridAdapter(requireActivity(), maintitle, imgid);
        binding.gvGallery.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}