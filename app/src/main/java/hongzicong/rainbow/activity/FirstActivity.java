package hongzicong.rainbow.activity;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hongzicong.rainbow.R;
import hongzicong.rainbow.fragment.ForgetPasswordFragment;
import hongzicong.rainbow.fragment.LoginFragment;
import hongzicong.rainbow.fragment.RegisterFragment;
import hongzicong.rainbow.fragment.ShareFutureFragment;
import hongzicong.rainbow.fragment.ShareNowFragment;
import hongzicong.rainbow.fragment.ShareOldFragment;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.first_view_pager)
    ViewPager mViewPager;

    private PagerAdapter mPagerAdapter;
    private List<Fragment> mFragments;
    private ForgetPasswordFragment forgetPasswordFragment;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mUnbinder= ButterKnife.bind(this);

        if(mFragments==null){
            mFragments=new ArrayList<>();
            mFragments.add(ForgetPasswordFragment.newInstance());

            mFragments.add(LoginFragment.newInstance());

            mFragments.add(RegisterFragment.newInstance());
        }

        FragmentManager fragmentManager=getSupportFragmentManager();
        mPagerAdapter=new PagerAdapter(fragmentManager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(getPageChangeListener());

        mViewPager.setCurrentItem(1);

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


    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (forgetPasswordFragment == null) {
                        forgetPasswordFragment = ForgetPasswordFragment.newInstance();
                    }
                    return forgetPasswordFragment;
                case 1:
                    if (loginFragment == null) {
                        loginFragment = LoginFragment.newInstance();
                    }
                    return loginFragment;
                case 2:
                    if (registerFragment == null) {
                        registerFragment = RegisterFragment.newInstance();
                    }
                    return registerFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

    }


}