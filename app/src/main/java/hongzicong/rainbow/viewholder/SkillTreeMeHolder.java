package hongzicong.rainbow.viewholder;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;
import hongzicong.rainbow.model.SkillCircleData;
import hongzicong.rainbow.model.SkillPoolData;
import hongzicong.rainbow.utils.UIUtils;
import hongzicong.rainbow.view.SkillCircle;

/**
 * Created by DELL-PC on 2017/12/16.
 */

public class SkillTreeMeHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.skill_tree_pool_layout)
    RelativeLayout mRelativeLayout;

    private SkillPoolData mSkillPoolData;

    public SkillTreeMeHolder(View itemView, SkillPoolData skillPoolData){
        super(itemView);
        ButterKnife.bind(this,itemView);

        mSkillPoolData=skillPoolData;

        initSkillPoolData();
    }

    private void initSkillPoolData(){
        for(SkillCircleData skillCircleData:mSkillPoolData.getSkillCircleDatas()){
            SkillCircle skillCircle=new SkillCircle(UIUtils.getContext());
            skillCircle.setSkillCircleData(skillCircleData);
            UIUtils.addViewToLayout(mRelativeLayout,skillCircle,skillCircle.getXInPool(),skillCircle.getYInPool());
        }
    }


}
