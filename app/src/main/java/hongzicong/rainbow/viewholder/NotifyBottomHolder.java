package hongzicong.rainbow.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import hongzicong.rainbow.R;
import hongzicong.rainbow.activity.RequestDetailActivity;
import hongzicong.rainbow.model.NotifyData;
import hongzicong.rainbow.utils.UIUtils;

import static hongzicong.rainbow.fragment.NotifyFragment.EXTRA_NOTIFY_ARTICAL;
import static hongzicong.rainbow.fragment.NotifyFragment.EXTRA_NOTIFY_AWARD;
import static hongzicong.rainbow.fragment.NotifyFragment.EXTRA_NOTIFY_NAME;
import static hongzicong.rainbow.fragment.NotifyFragment.EXTRA_NOTIFY_PICTURE_ID;

/**
 * Created by DELL-PC on 2017/12/12.
 */

public class NotifyBottomHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.notify_avatar)
    CircleImageView mCircleImageView;

    @BindView(R.id.notify_name)
    TextView mName;

    @BindView(R.id.notify_intro)
    TextView mIntro;

    @BindView(R.id.notify_award)
    TextView mAward;

    @BindView(R.id.notify_favour)
    TextView mFavourNum;

    @BindView(R.id.notify_disfavour)
    TextView mDisfavourButton;

    @BindView(R.id.notify_collect)
    TextView mCollectButton;

    @BindView(R.id.notify_ok)
    TextView mOKButton;

    @BindView(R.id.notify_detail)
    TextView mDetailButton;

    @BindView(R.id.notify_list_item_layout)
    SwipeLayout mSwipeLayout;

    private NotifyData mNotifyData;

    public NotifyBottomHolder(View itemView,NotifyData notifyData){
        super(itemView);
        ButterKnife.bind(this,itemView);
        mNotifyData=notifyData;
        initNotifyData();
        mDetailButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.e("HONGZICONG","1");
                Intent intent=new Intent(UIUtils.getContext(),RequestDetailActivity.class);
                intent.putExtra(EXTRA_NOTIFY_NAME,mNotifyData.getUser().getUserName());
                intent.putExtra(EXTRA_NOTIFY_ARTICAL,mNotifyData.getArticle());
                intent.putExtra(EXTRA_NOTIFY_AWARD,mNotifyData.getAward());
                intent.putExtra(EXTRA_NOTIFY_PICTURE_ID,mNotifyData.getUser().getPictureId());
                UIUtils.getContext().startActivity(intent);
            }
        });
    }

    private void initNotifyData(){
        mName.setText(mNotifyData.getUser().getUserName());
        mAward.setText(mNotifyData.getAward());
        mCircleImageView.setImageResource(mNotifyData.getUser().getPictureId());
        mIntro.setText(mNotifyData.getIntro());
        mFavourNum.setText(mNotifyData.getFavourNum()+"人 正在考虑");
    }

}
