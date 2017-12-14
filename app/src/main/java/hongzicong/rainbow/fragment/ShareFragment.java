package hongzicong.rainbow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hongzicong.rainbow.R;


public class ShareFragment extends Fragment {

    @BindView(R.id.tablayout_share)
    TabLayout mTabLayout;

    @BindView(R.id.view_pager_share)
    ViewPager mViewPager;

    @BindView(R.id.toolbar_share)
    Toolbar mToolbar;

    private List<Fragment> mFragments;
    private List<String> mTitles;
    private PagerAdapter mPagerAdapter;

    private Unbinder mUnbinder;

    public static ShareFragment newInstance() {
        ShareFragment fragment = new ShareFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_share,container,false);
        mUnbinder=ButterKnife.bind(this,v);

        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(mFragments==null){
            mFragments=new ArrayList<>();
            mTitles=new ArrayList<>();
            mTitles.add("从前");
            mFragments.add(ShareOldFragment.getInstance());

            mTitles.add("现在");
            mFragments.add(ShareNowFragment.getInstance());

            mTitles.add("未来");
            mFragments.add(ShareFutureFragment.getInstance());
        }
        FragmentManager fragmentManager=getChildFragmentManager();
        mPagerAdapter=new PagerAdapter(fragmentManager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(getPageChangeListener());
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.getTabAt(1).select();
    }

    private ViewPager.OnPageChangeListener getPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    public class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }

}
