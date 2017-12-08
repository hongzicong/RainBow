package hongzicong.rainbow.model;

/**
 * Created by DELL-PC on 2017/12/7.
 */

//用来做share界面的数据读入储存
public class ShareData {

    private User mUser;
    private String mTitle;
    private String mTag;
    private String mShortIntro;

    public ShareData(User user, String title, String tag, String shortIntro) {
        mUser = user;
        mTitle = title;
        mTag = tag;
        mShortIntro = shortIntro;
    }

    public String getTag() {

        return mTag;
    }

    public String getShortIntro() {
        return mShortIntro;
    }

    public void setShortIntro(String shortIntro) {
        mShortIntro = shortIntro;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
