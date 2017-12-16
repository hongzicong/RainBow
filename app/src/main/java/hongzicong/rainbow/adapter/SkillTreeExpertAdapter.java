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
import hongzicong.rainbow.model.SkillTreeExpertData;
import hongzicong.rainbow.viewholder.SkillTreeExpertHolder;

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
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.list_skill_tree_expert_item,parent,false);
        return new SkillTreeExpertHolder(itemView,mSkillTreeExpertDatas.get(viewType));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mSkillTreeExpertDatas.size();
    }


}
