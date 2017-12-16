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
import hongzicong.rainbow.model.SkillTreeExpertData;
import hongzicong.rainbow.model.SkillTreeMeData;
import hongzicong.rainbow.viewholder.SkillTreeExpertHolder;
import hongzicong.rainbow.viewholder.SkillTreeMeHolder;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class SkillTreeMeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private SkillTreeMeData mSkillTreeMeDatas;

    public SkillTreeMeAdapter(Fragment fragment, SkillTreeMeData skillTreeMeDatas){
        this.mContext=fragment.getContext();
        this.mSkillTreeMeDatas=skillTreeMeDatas;
    }

    public SkillTreeMeAdapter(Activity activity, SkillTreeMeData skillTreeMeDatas){
        this.mContext=activity;
        this.mSkillTreeMeDatas=skillTreeMeDatas;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.list_skill_tree_expert_item,parent,false);
        return new SkillTreeMeHolder(itemView,mSkillTreeMeDatas.getSkillPoolDataList().get(viewType));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mSkillTreeMeDatas.getSkillPoolDataList().size();
    }

}
