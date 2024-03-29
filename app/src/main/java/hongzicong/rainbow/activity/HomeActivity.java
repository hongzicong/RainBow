package hongzicong.rainbow.activity;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;
import hongzicong.rainbow.fragment.NotifyFragment;
import hongzicong.rainbow.fragment.ShareFragment;
import hongzicong.rainbow.fragment.SkillTreeFragment;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    protected NavigationView mNavigationView;

    @BindView(R.id.bottom_navigation_bar)
    protected BottomNavigationBar bottomNavigationBar;

    protected FragmentManager mFragmentManager;

    protected ShareFragment mShareFragment;
    protected SkillTreeFragment mSkillTreeFragment;
    protected NotifyFragment mNotifyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);

        ButterKnife.bind(this);

        initBottomNavigationBar();
        initFragmentManager();
        initNavigationView();
    }

    private void initNavigationView(){
        mNavigationView.setCheckedItem(R.id.nav_main);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }


    private void initFragmentManager(){
        mFragmentManager=this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=mFragmentManager.beginTransaction();
        mSkillTreeFragment=SkillTreeFragment.newInstance();
        fragmentTransaction.replace(R.id.member_layout,mSkillTreeFragment);
        fragmentTransaction.commit();
    }

    //初始化底部导航栏
    protected void initBottomNavigationBar(){
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.share_icon,"分享").setActiveColorResource(R.color.share_color))
                .addItem(new BottomNavigationItem(R.drawable.skill_tree_icon,"技能树").setActiveColorResource(R.color.skill_tree_color))
                .addItem(new BottomNavigationItem(R.drawable.notifi_icon,"通知").setActiveColorResource(R.color.notify_color))
                .setFirstSelectedPosition(1)
                .initialise();
        bottomNavigationBar.setAutoHideEnabled(false);
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction fragmentTransaction=mFragmentManager.beginTransaction();
                switch (position){
                    case 0:
                        if(mShareFragment==null){
                            mShareFragment=ShareFragment.newInstance();
                        }
                        fragmentTransaction.replace(R.id.member_layout,mShareFragment);

                        break;
                    case 1:
                        if(mSkillTreeFragment==null){
                            mSkillTreeFragment=SkillTreeFragment.newInstance();
                        }
                        fragmentTransaction.replace(R.id.member_layout,mSkillTreeFragment);
                        break;
                    case 2:
                        if(mNotifyFragment==null){
                            mNotifyFragment=NotifyFragment.newInstance();
                        }
                        fragmentTransaction.replace(R.id.member_layout,mNotifyFragment);
                        break;
                    default:
                        break;
                }
                fragmentTransaction.commit();
            }

            @Override
            public void onTabReselected(int position) {

            }

            @Override
            public void onTabUnselected(int position) {

            }

        });
    }


}
