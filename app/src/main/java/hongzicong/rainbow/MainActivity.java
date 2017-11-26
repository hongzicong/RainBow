package hongzicong.rainbow;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private Toolbar toolBar;
    private TabLayout tabLayout;
    private BottomNavigationBar bottomNavigationBar;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                //将侧边栏顶部延伸至status bar
                mDrawerLayout.setFitsSystemWindows(true);
                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
                mDrawerLayout.setClipToPadding(false);
            }
        }
        initAllWidget();
        setAllListener();
        setMyActionBar();
        Log.d("MainActivityHaHa",getStatusBarHeight()+" ");
    }

    private void initAllWidget(){
        //沉浸式设置
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        toolBar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.nav_view);
        bottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);

        //Test
        textView=(TextView)findViewById(R.id.test_textView);
        textView.setText("AppbarLayout继承自LinearLayout,它就是一个垂直方向的LinearLayout,在LinearLayout的基础上添加了一些材料设计的概念和特性，即滑动手势。它可以让你定制在某个可滑动的View（如：ScrollView ,ListView ,RecyclerView 等）滑动手势发生改变时，内部的子View 该做什么动作。子View应该提供滑动时他们期望的响应的动作Behavior,通过setScrollFlags(int)，或者xml 中使用属性：\n" +
                "\n" +
                "作者：依然范特稀西\n" +
                "链接：http://www.jianshu.com/p/ac56f11e7ce1\n" +
                "來源：简书\n" +
                "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。");
        textView.setTextSize(40);

        navigationView.setCheckedItem(R.id.nav_main);

        tabLayout.addTab(tabLayout.newTab().setText("专家"));
        tabLayout.addTab(tabLayout.newTab().setText("我"));

        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.math,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.math,"技能树"))
                .addItem(new BottomNavigationItem(R.drawable.math,"通知"))
                .setFirstSelectedPosition(1)
                .initialise();
    }

    private void setAllListener(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

            }
            @Override
            public void onTabReselected(int position) {

            }
            @Override
            public void onTabUnselected(int position) {

            }
        });
    }

    private void setMyActionBar(){
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setDisplayShowTitleEnabled(false);
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
