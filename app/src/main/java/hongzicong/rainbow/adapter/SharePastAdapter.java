package hongzicong.rainbow.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hongzicong.rainbow.model.ShareData;
import hongzicong.rainbow.model.SharePastData;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class SharePastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ShareNowAdapter.OnItemClickListener mOnItemClickListener;
    private List<SharePastData> mSharePastDatas;

    public SharePastAdapter(Fragment fragment, List<SharePastData> sharePastDatas){
        this.mContext=fragment.getContext();
        this.mSharePastDatas=sharePastDatas;
    }

    public SharePastAdapter(Activity activity, List<SharePastData> sharePastDatas){
        this.mContext=activity;
        mSharePastDatas=sharePastDatas;
    }

    public void setOnItemClickListener(ShareNowAdapter.OnItemClickListener onItemClickListener){
        mOnItemClickListener=onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
