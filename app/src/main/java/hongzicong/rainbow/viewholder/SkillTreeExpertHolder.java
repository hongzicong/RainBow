package hongzicong.rainbow.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import hongzicong.rainbow.R;
import hongzicong.rainbow.model.SkillTreeExpertData;

/**
 * Created by DELL-PC on 2017/12/16.
 */

public class SkillTreeExpertHolder extends RecyclerView.ViewHolder  {

    @BindView(R.id.skill_tree_expert_avatar)
    CircleImageView mExpertAvater;

    @BindView(R.id.skill_tree_expert_name)
    TextView mExpertName;

    @BindView(R.id.skill_tree_expert_article)
    TextView mExpertArticle;

    @BindView(R.id.skill_tree_expert_swipe_layout)
    SwipeLayout mSwipeLayout;

    private SkillTreeExpertData mSkillTreeExpertData;

    public SkillTreeExpertHolder(View itemView,SkillTreeExpertData skillTreeExpertData){
        super(itemView);
        ButterKnife.bind(this,itemView);

        mSkillTreeExpertData=skillTreeExpertData;

        mSwipeLayout.addDrag(SwipeLayout.DragEdge.Right,mSwipeLayout.findViewById(R.id.skill_tree_expert_go_to_detail));

        initSkillTreeExpertData();


    }

    private void initSkillTreeExpertData(){
        //mDetailIntro.setText(mSkillTreeExpertData.getExpertIntro());
        mExpertArticle.setText(mSkillTreeExpertData.getArticle());
        mExpertAvater.setImageResource(mSkillTreeExpertData.getUser().getPictureId());
        mExpertName.setText(mSkillTreeExpertData.getUser().getUserName());
    }

}
