package hongzicong.rainbow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;

public class NotifyDetailActivity extends AppCompatActivity {

    @BindView(R.id.notify_detail_avatar)
    ImageView mAvatar;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify_detail);

        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);



        ButterKnife.bind(this);

    }

}
