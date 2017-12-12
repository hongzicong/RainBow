package hongzicong.rainbow.model;

/**
 * Created by DELL-PC on 2017/12/12.
 */

public class NotifyData {

    private User mUser;
    private String mIntro;
    private String mTag;
    private String mArticle;
    private String mAward;

    public NotifyData(User user, String intro, String tag, String article, String award, int favourNum) {
        mUser = user;
        mIntro = intro;
        mTag = tag;
        mArticle = article;
        mAward = award;
        mFavourNum = favourNum;
    }

    public String getAward() {
        return mAward;
    }

    public void setAward(String award) {
        mAward = award;
    }

    private int mFavourNum;

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public String getIntro() {
        return mIntro;
    }

    public void setIntro(String intro) {
        mIntro = intro;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public String getArticle() {
        return mArticle;
    }

    public void setArticle(String article) {
        mArticle = article;
    }

    public int getFavourNum() {
        return mFavourNum;
    }

    public void setFavourNum(int favourNum) {
        mFavourNum = favourNum;
    }
}
