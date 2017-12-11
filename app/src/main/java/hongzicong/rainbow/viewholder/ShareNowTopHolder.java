package hongzicong.rainbow.viewholder;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;
import hongzicong.rainbow.view.ProgressViewPager;
import hongzicong.rainbow.utils.UIUtils;

import static hongzicong.rainbow.activity.BaseApplication.getContext;

/**
 * Created by DELL-PC on 2017/12/11.
 */

public class ShareNowTopHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.progress_view_pager)
    ProgressViewPager mViewPager;

    @BindView(R.id.progress_point_container)
    LinearLayout mLinearLayout;

    private AutoBroadcastPicTask mAutoTask;
    private ProgressViewAdapter mAdapter;

    private final List<Integer> mDatas;

    private Context mContext;

    public ShareNowTopHolder(LayoutInflater inflater, ViewGroup parent,Context context){
        super(inflater.inflate(R.layout.list_share_now_top_item,parent,false));
        ButterKnife.bind(this,itemView);

        mContext=context;

        mDatas = new ArrayList<>();
        mDatas.add(R.drawable.lunbo_01);
        mDatas.add(R.drawable.lunbo_02);
        mDatas.add(R.drawable.lunbo_03);

        initListener();

        if (mAdapter == null) {
            mAdapter = new ProgressViewAdapter();
        }

        mViewPager.setAdapter(mAdapter);

        for (int i = 0; i < mDatas.size(); i++) {
            ImageView point = new ImageView(UIUtils.getContext());
            if (i == 0) {
                point.setImageResource(R.drawable.shape_indicator_select);
            } else {
                point.setImageResource(R.drawable.shape_indicator_normal);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = UIUtils.dip2px(6);
            layoutParams.bottomMargin = UIUtils.dip2px(6);
            point.setLayoutParams(layoutParams);
            mLinearLayout.addView(point);
        }

        //从中间开始轮播
        int centerCount = Integer.MAX_VALUE / 2;
        centerCount = centerCount - centerCount % mDatas.size();
        mViewPager.setCurrentItem(centerCount);

        //开始自动轮播
        if (mAutoTask == null) {
            mAutoTask = new AutoBroadcastPicTask();
        }

        mAutoTask.start();

    }

    private class AutoBroadcastPicTask implements Runnable {

        @Override
        public void run() {
            int currentItem = mViewPager.getCurrentItem();
            mViewPager.setCurrentItem(++currentItem);
            UIUtils.postDelayed(this, 2000);
        }

        public void start() {
            stop();//开始之前先停止，以免重复开始
            UIUtils.postDelayed(this, 2000);
        }

        public void stop() {
            UIUtils.removeCallbacks(this);
        }

    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                position = position % mDatas.size();
                selectPoint(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mAutoTask.stop();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        mAutoTask.start();
                        break;
                }
                return false;
            }
        });
    }

    private void selectPoint(int index) {
        for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
            ImageView point = (ImageView) mLinearLayout.getChildAt(i);
            if (index == i) {
                point.setImageResource(R.drawable.shape_indicator_select);
            } else {
                point.setImageResource(R.drawable.shape_indicator_normal);
            }
        }
    }

    class ProgressViewAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position = position % mDatas.size();

            ImageView iv = new ImageView(mContext);

            iv.setScaleType(ImageView.ScaleType.FIT_XY);

            switch (position){
                case 0:
                    iv.setImageResource(R.drawable.lunbo_01 );
                    break;
                case 1:
                    iv.setImageResource(R.drawable.lunbo_02 );
                    break;
                case 2:
                    iv.setImageResource(R.drawable.lunbo_03 );
                    break;
            }

            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
