package hongzicong.rainbow.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import hongzicong.rainbow.R;
import hongzicong.rainbow.model.NotifyData;

/**
 * Created by DELL-PC on 2017/12/12.
 */

public class NotifyBottomHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
    ImageView mDisfavourButton;

    @BindView(R.id.notify_collect)
    ImageView mCollectButton;

    @BindView(R.id.notify_ok)
    ImageView mOKButton;

    private NotifyData mNotifyData;

    public NotifyBottomHolder(LayoutInflater inflater, ViewGroup parent, NotifyData notifyData){
        super(inflater.inflate(R.layout.list_notify_bottom_item,parent,false));
        ButterKnife.bind(this,itemView);
        mNotifyData=notifyData;
        initNotifyData();
    }

    private void initNotifyData(){
        mName.setText(mNotifyData.getUser().getUserName());
        mAward.setText(mNotifyData.getAward());
        mCircleImageView.setImageResource(mNotifyData.getUser().getPictureId());
        mIntro.setText(mNotifyData.getIntro());
        mFavourNum.setText(mNotifyData.getFavourNum()+"人 正在考虑");
    }

    @Override
    public void onClick(View v) {

    }

}
