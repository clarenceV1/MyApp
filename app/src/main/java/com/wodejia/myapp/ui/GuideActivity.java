package com.wodejia.myapp.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.clarence.libwidget.YiPageIndicator;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppActivity;
import com.wodejia.myapp.controller.GuideController;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by clarence on 16/9/29.
 */

public class GuideActivity extends AppActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.yiPageIndicator)
    YiPageIndicator yiPageIndicator;
    @BindView(R.id.btnStart)
    Button btnStart;

    @Inject
    GuideController guideController;

    int[] guideImageId= new int[]{R.drawable.guide_1, R.drawable.guide_2,R.drawable.guide_3};
    GuideViewPagerAdapter adapter;
    private int lastX = 0;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        titleBarCommon.setCustomTitleBar(-1);
        ButterKnife.bind(this);
        initView();
        guideController.hideGuide();
    }

    private void initView() {
        adapter = new GuideViewPagerAdapter(this, guideImageId);
        viewPager.setAdapter(adapter);
        yiPageIndicator.setTotalPage(adapter.getCount());
        yiPageIndicator.setDotColor(getResources().getColor(R.color.dot_normal),getResources().getColor(R.color.dot_press));
        yiPageIndicator.setKongxin(false, false);
        yiPageIndicator.setCurrentPage(0);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMainActivity();
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                yiPageIndicator.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            lastX = (int) event.getX();
                            break;
                        case MotionEvent.ACTION_MOVE:
                            if ((lastX - event.getX()) > 100 && (yiPageIndicator.getCurrentPage() == adapter.getCount() - 1)) {
                                lastX = 0;
                                goMainActivity();
                            }
                            break;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return false;
            }
        });
    }

    private void goMainActivity() {
        navigator.navigateTo(GuideActivity.this,MainActivity.class);
        finish();
    }
}
