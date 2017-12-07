package hongzicong.rainbow;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import hongzicong.rainbow.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    private Toolbar toolBar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home);

        initAllWidget();
        setAllListener();
    }

    private void initAllWidget(){
        //沉浸式设置
        //tabLayout=(TabLayout)findViewById(R.id.tablayout);
        //toolBar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.nav_view);

        navigationView.setCheckedItem(R.id.nav_main);

        tabLayout.addTab(tabLayout.newTab().setText("专家"));
        tabLayout.addTab(tabLayout.newTab().setText("我"));

    }

    private void setAllListener(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
