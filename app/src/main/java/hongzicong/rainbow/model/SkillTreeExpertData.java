package hongzicong.rainbow.model;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class SkillTreeExpertData {

    private String mExpertIntro;
    private User mUser;
    private SkillTreeData mSkillTreeData;
    private String mArticle;

    public SkillTreeExpertData(String expertIntro, User user, SkillTreeData skillTreeData, String article) {
        mExpertIntro = expertIntro;
        mUser = user;
        mSkillTreeData = skillTreeData;
        mArticle = article;
    }

    public String getExpertIntro() {
        return mExpertIntro;
    }

    public void setExpertIntro(String expertIntro) {
        mExpertIntro = expertIntro;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public SkillTreeData getSkillTreeData() {
        return mSkillTreeData;
    }

    public void setSkillTreeData(SkillTreeData skillTreeData) {
        mSkillTreeData = skillTreeData;
    }

    public String getArticle() {
        return mArticle;
    }

    public void setArticle(String article) {
        mArticle = article;
    }
}
