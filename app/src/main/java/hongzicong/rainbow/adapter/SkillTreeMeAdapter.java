package hongzicong.rainbow.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import hongzicong.rainbow.model.SkillTreeExpertData;
import hongzicong.rainbow.model.SkillTreeMeData;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class SkillTreeMeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<SkillTreeMeData> mSkillTreeMeDatas;

    public SkillTreeMeAdapter(Fragment fragment, List<SkillTreeMeData> skillTreeMeDatas){
        this.mContext=fragment.getContext();
        this.mSkillTreeMeDatas=skillTreeMeDatas;
    }

    public SkillTreeMeAdapter(Activity activity, List<SkillTreeMeData> skillTreeMeDatas){
        this.mContext=activity;
        this.mSkillTreeMeDatas=skillTreeMeDatas;
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
        return 0;
    }

}
