package hongzicong.rainbow.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;
import hongzicong.rainbow.SkillCircleAdapter;
import hongzicong.rainbow.fragment.ShareNowFragment;
import hongzicong.rainbow.model.ShareData;

/**
 * Created by DELL-PC on 2017/12/10.
 */


public class ShareNowAdapter extends RecyclerView.Adapter<ShareNowAdapter.ShareHolder>{

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private List<ShareData> mShareDatas;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener=onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public ShareNowAdapter(List<ShareData> shareDatas){
        this.mShareDatas=shareDatas;
    }

    public ShareNowAdapter(Fragment fragment,List<ShareData> shareDatas){
        this.mContext=fragment.getContext();
        this.mShareDatas=shareDatas;
    }

    public ShareNowAdapter(Activity activity,List<ShareData> shareDatas){
        this.mContext=activity;
        mShareDatas=shareDatas;
    }

    @Override
    public ShareHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        final View itemView = layoutInflater.inflate(R.layout.list_share_item, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, (Integer) v.getTag());
                }
            }
        });
        return new ShareHolder(layoutInflater,parent);
    }

    @Override
    public void onBindViewHolder(ShareHolder holder, int position) {
        ShareData shareData=mShareDatas.get(position);
        holder.bind(shareData);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mShareDatas.size();
    }

    class ShareHolder extends RecyclerView.ViewHolder{

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

        public ShareHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_share_item,parent,false));
            ButterKnife.bind(this,itemView);
        }

        public void bind(ShareData shareData){
            mShareData=shareData;
            avatarImage.setImageResource(mShareData.getUser().getPictureId());
            commentNum.setText(mShareData.getCommentNum()+"评论数");
            favourNum.setText(mShareData.getFavourNum()+"赞同数");
            name.setText(mShareData.getUser().getUserName());
            title.setText(mShareData.getTitle());
            articleText.setText(mShareData.getShortIntro());
        }

    }

}



