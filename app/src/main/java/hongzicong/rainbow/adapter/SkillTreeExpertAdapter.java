package hongzicong.rainbow.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import hongzicong.rainbow.model.ShareData;
import hongzicong.rainbow.model.SkillTreeExpertData;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class SkillTreeExpertAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<SkillTreeExpertData> mSkillTreeExpertDatas;

    public SkillTreeExpertAdapter(Fragment fragment, List<SkillTreeExpertData> skillTreeExpertDatas){
        this.mContext=fragment.getContext();
        this.mSkillTreeExpertDatas=skillTreeExpertDatas;
    }

    public SkillTreeExpertAdapter(Activity activity, List<SkillTreeExpertData> skillTreeExpertDatas){
        this.mContext=activity;
        this.mSkillTreeExpertDatas=skillTreeExpertDatas;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
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
        return mSkillTreeExpertDatas.size();
    }
}
