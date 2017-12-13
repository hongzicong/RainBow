package hongzicong.rainbow.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import hongzicong.rainbow.R;
import hongzicong.rainbow.fragment.NotifyFragment;
import hongzicong.rainbow.utils.UIUtils;

public class NotifyDetailActivity extends AppCompatActivity {

    @BindView(R.id.notify_detail_avatar)
    CircleImageView mAvatar;

    @BindView(R.id.notify_detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.notify_detail_name)
    TextView mName;

    @BindView(R.id.notify_detail_article)
    TextView mArticle;

    @BindView(R.id.notify_detail_reward)
    TextView mReward;

    @BindView(R.id.notify_detail_later)
    Button mLaterButton;

    @BindView(R.id.notify_detail_ok)
    Button mOkButton;

    @BindView(R.id.notify_detail_no)
    Button mNoButton;

    private int picture_id;
    private String article;
    private String award;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify_detail);

        ButterKnife.bind(this);
        name=getIntent().getStringExtra(NotifyFragment.EXTRA_NOTIFY_NAME);
        award=getIntent().getStringExtra(NotifyFragment.EXTRA_NOTIFY_AWARD);
        article=getIntent().getStringExtra(NotifyFragment.EXTRA_NOTIFY_ARTICAL);
        picture_id=getIntent().getIntExtra(NotifyFragment.EXTRA_NOTIFY_PICTURE_ID,1);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();
    }

    private void initUI(){
        mArticle.setText(article);
        mReward.setText(award);
        mAvatar.setImageResource(picture_id);
        mName.setText(name);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
