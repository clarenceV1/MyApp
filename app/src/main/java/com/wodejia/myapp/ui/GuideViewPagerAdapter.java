package com.wodejia.myapp.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wodejia.myapp.R;

public class GuideViewPagerAdapter extends PagerAdapter {

    Context context;
    int[] guideImageId;
    public GuideViewPagerAdapter(Context context,int[] guideImageId) {
        this.context = context;
        this.guideImageId=guideImageId;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.guide_viewpager_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(guideImageId[position]);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return guideImageId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}