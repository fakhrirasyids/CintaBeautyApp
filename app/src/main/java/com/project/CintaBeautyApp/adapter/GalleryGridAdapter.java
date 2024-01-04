package com.project.CintaBeautyApp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.CintaBeautyApp.R;

public class GalleryGridAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final Integer[] imgid;

    public GalleryGridAdapter(Activity context, String[] maintitle, Integer[] imgid) {
        super(context, R.layout.item_gallery_grid, maintitle);

        this.context = context;
        this.maintitle = maintitle;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_gallery_grid, null, true);

        TextView titleText = (TextView) rowView.findViewById(R.id.tv_gallery);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.iv_gallery);

        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;

    }

}