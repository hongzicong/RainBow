package hongzicong.rainbow.adapter;

/**
 * Created by DELL-PC on 2017/12/12.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.List;

import butterknife.BindView;
import hongzicong.rainbow.R;
import hongzicong.rainbow.activity.RequestDetailActivity;
import hongzicong.rainbow.model.NotifyData;
import hongzicong.rainbow.viewholder.NotifyBottomHolder;
import hongzicong.rainbow.viewholder.NotifyCenterHolder;
import hongzicong.rainbow.viewholder.NotifyTopHolder;

import static hongzicong.rainbow.fragment.NotifyFragment.EXTRA_NOTIFY_ARTICAL;
import static hongzicong.rainbow.fragment.NotifyFragment.EXTRA_NOTIFY_AWARD;
import static hongzicong.rainbow.fragment.NotifyFragment.EXTRA_NOTIFY_NAME;
import static hongzicong.rainbow.fragment.NotifyFragment.EXTRA_NOTIFY_PICTURE_ID;

public class NotifyAdapter extends RecyclerSwipeAdapter<RecyclerView.ViewHolder>{

    private Context mContext;

    private List<NotifyData> mNotifyDatas;

    private OnItemClickListener mOnItemClickListener;

    private NotifyTopHolder mNotifyTopHolder;

    public NotifyAdapter(Fragment fragment,List<NotifyData> notifyDatas){
        this.mContext=fragment.getContext();
        this.mNotifyDatas=notifyDatas;
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener=onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return 2+mNotifyDatas.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        if(viewType==0){
            View itemView=layoutInflater.inflate(R.layout.list_notify_top_item,parent,false);
            if(mNotifyTopHolder==null){
                mNotifyTopHolder=new NotifyTopHolder(layoutInflater,parent);
            }
            return mNotifyTopHolder;
        }
        else if(viewType==1){
            View itemView=layoutInflater.inflate(R.layout.list_notify_center_item,parent,false);
            return new NotifyCenterHolder(layoutInflater,parent);
        }
        else{
            View itemView=layoutInflater.inflate(R.layout.list_notify_bottom_item,parent,false);
            return new NotifyBottomHolder(itemView,mNotifyDatas.get(viewType-2));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.notify_list_item_layout;
    }

}
