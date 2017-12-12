package hongzicong.rainbow.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;
import hongzicong.rainbow.model.ShareData;

/**
 * Created by DELL-PC on 2017/12/11.
 */
public class ShareBottomHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @BindView(R.id.title_text)
    TextView title;

    @BindView(R.id.circle_image)
    ImageView avatarImage;

    @BindView(R.id.name_text)
    TextView name;

    @BindView(R.id.applaud_num)
    TextView favourNum;

    @BindView(R.id.comment_num)
    TextView commentNum;

    @BindView(R.id.article_text)
    TextView articleText;

    private ShareData mShareData;

    public ShareBottomHolder(LayoutInflater inflater, ViewGroup parent, ShareData shareData){
        super(inflater.inflate(R.layout.list_share_now_bottom_item,parent,false));
        ButterKnife.bind(this,itemView);
        mShareData=shareData;
        init(mShareData);
    }

    public void init(ShareData shareData){
        mShareData=shareData;
        avatarImage.setImageResource(mShareData.getUser().getPictureId());
        commentNum.setText(mShareData.getCommentNum()+"评论数");
        favourNum.setText(mShareData.getFavourNum()+"赞同数");
        name.setText(mShareData.getUser().getUserName());
        title.setText(mShareData.getTitle());
        articleText.setText(mShareData.getShortIntro());
    }

    @Override
    public void onClick(View v) {

    }
}
