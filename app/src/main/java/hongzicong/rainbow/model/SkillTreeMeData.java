package hongzicong.rainbow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class SkillTreeMeData {

    private int skillTreeId;
    private List<SkillPoolData> mSkillPoolDataList=new ArrayList<>();

    public int getSkillTreeId() {
        return skillTreeId;
    }

    public void setSkillTreeId(int skillTreeId) {
        this.skillTreeId = skillTreeId;
    }

    public void addSkillPool(SkillPoolData skillPoolData){
        mSkillPoolDataList.add(skillPoolData);
    }

    public List<SkillPoolData> getSkillPoolDataList(){
        return mSkillPoolDataList;
    }
}
