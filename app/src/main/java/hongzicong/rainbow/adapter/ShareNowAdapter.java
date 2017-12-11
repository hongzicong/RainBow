package hongzicong.rainbow.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hongzicong.rainbow.R;
import hongzicong.rainbow.model.ShareData;
import hongzicong.rainbow.viewholder.*;

/**
 * Created by DELL-PC on 2017/12/10.
 */


public class ShareNowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_TOP = 0;
    private static final int TYPE_CENTER = 1;

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private List<ShareData> mShareDatas;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener=onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
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
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TOP;
        } else if (position == 1) {
            return TYPE_CENTER;
        } else{
            return position;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        if(viewType==TYPE_TOP){
            View itemView=layoutInflater.inflate(R.layout.list_share_now_top_item,parent,false);
            return new ShareNowTopHolder(layoutInflater,parent);
        }
        else if(viewType==TYPE_CENTER){
            View itemView=layoutInflater.inflate(R.layout.list_share_now_center_item,parent,false);
            return new ShareNowCenterHolder(layoutInflater,parent);
        }
        else{
            View itemView = layoutInflater.inflate(R.layout.list_share_now_bottom_item, parent, false);
            return new ShareHolder(layoutInflater,parent,mShareDatas.get(viewType-2));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2+mShareDatas.size();
    }



}



