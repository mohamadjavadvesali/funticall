package com.fntl.app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.fntl.app.R;
import com.fntl.app.databinding.SliderItemBinding;
import com.fntl.app.model.ImageModel;

import java.util.List;

public class AppViewPagerAdapter extends PagerAdapter {
    private final List<ImageModel> imageModels;


    public AppViewPagerAdapter(List<ImageModel> imageModels) {
        this.imageModels = imageModels;
    }

    @Override
    public int getCount() {
        return imageModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        SliderItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), R.layout.slider_item, container, false);
        ImageModel imageModel = imageModels.get(position);
        binding.setModel(imageModel);
        container.addView(binding.getRoot());
        return binding.getModel();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
