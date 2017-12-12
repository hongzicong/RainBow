package hongzicong.rainbow.adapter;

/**
 * Created by DELL-PC on 2017/12/12.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hongzicong.rainbow.R;
import hongzicong.rainbow.model.NotifyData;
import hongzicong.rainbow.viewholder.NotifyBottomHolder;
import hongzicong.rainbow.viewholder.NotifyTopHolder;
import hongzicong.rainbow.viewholder.ShareNowTopHolder;

public class NotifyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<NotifyData> mNotifyDatas;

    public NotifyAdapter(Fragment fragment,List<NotifyData> notifyDatas){
        this.mContext=fragment.getContext();
        this.mNotifyDatas=notifyDatas;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1+mNotifyDatas.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        if(viewType==0){
            View itemView=layoutInflater.inflate(R.layout.list_share_now_top_item,parent,false);
            return new NotifyTopHolder(layoutInflater,parent);
        }
        else{
            View itemView=layoutInflater.inflate(R.layout.list_share_now_top_item,parent,false);
            return new NotifyBottomHolder(layoutInflater,parent);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}