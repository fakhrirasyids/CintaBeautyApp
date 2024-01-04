package com.project.CintaBeautyApp.ui.main.ui.event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.project.CintaBeautyApp.R;
import com.project.CintaBeautyApp.adapter.EventListAdapter;
import com.project.CintaBeautyApp.databinding.FragmentEventBinding;

public class EventFragment extends Fragment {

    private FragmentEventBinding binding;

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

    String[] subtitle = {
            "Sabtu, 15 Juli 2023, pukul 19.00 WIB",
            "Rabu, 9 Agustus 2023 - Minggu, 13 Agustus 2023, pukul 10.00-22.00 WIB",
            "Kamis, 24 Agustus 2023 - Minggu, 27 Agustus 2023, pukul 10.00-18.00 WIB",
            "Jumat, 15 September 2023 - Minggu, 17 September 2023, pukul 11.00-22.00 WIB",
            "Jumat, 6 Oktober 2023 - Minggu, 8 Oktober 2023, pukul 10.00-20.00 WIB",
            "Sabtu, 21 Oktober 2023, pukul 19.00 WIB",
            "Sabtu, 11 November 2023 - Minggu, 12 November 2023, pukul 10.00-18.00 WIB",
            "Kamis, 23 November 2023 - Minggu, 26 November 2023, pukul 11.00-20.00 WIB",
            "Sabtu, 2 Desember 2023 - Minggu, 3 Desember 2023, pukul 09.00-17.00 WIB",
            "Sabtu, 9 Desember 2023 - Minggu, 10 Desember 2023, pukul 10.00-18.00 WIB",
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEventBinding.inflate(inflater, container, false);

        EventListAdapter adapter = new EventListAdapter(requireActivity(), maintitle, subtitle, imgid);
        binding.listEvent.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}