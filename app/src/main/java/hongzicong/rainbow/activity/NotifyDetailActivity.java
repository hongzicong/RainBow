package hongzicong.rainbow.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;

import static hongzicong.rainbow.viewholder.NotifyTopHolder.NOTIFY_TOP_VIEW;

//通知处的顶部菜单栏的详细内容
public class NotifyDetailActivity extends AppCompatActivity {

    private int position;

    @BindView(R.id.notify_request_detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.notify_request_detail_icon)
    ImageView mImageView;

    private int[] iconList={R.drawable.school,R.drawable.library,R.drawable.branch,R.drawable.skyscraper,R.drawable.park,R.drawable.museum};

    private String[] titleList={"评论","喜欢","关注","请求","赞赏","收藏"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify_request_detail);

        ButterKnife.bind(this);

        position=getIntent().getIntExtra(NOTIFY_TOP_VIEW,0);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(titleList[position]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageView.setImageResource(iconList[position]);

    }
}
