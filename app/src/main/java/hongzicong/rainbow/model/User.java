package hongzicong.rainbow.model;

/**
 * Created by DELL-PC on 2017/12/8.
 */

//用来存用户资料
public class User {

    private int mUserId;
    private String mUserName;
    private int mPictureId;
    private String mIntroduction;

    public User(int userId, String userName, int pictureId, String introduction) {
        mUserId = userId;
        mUserName = userName;
        mPictureId = pictureId;
        mIntroduction = introduction;
    }

    public String getIntroduction() {
        return mIntroduction;
    }

    public void setIntroduction(String introduction) {
        mIntroduction = introduction;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public int getPictureId() {
        return mPictureId;
    }

    public void setPictureId(int pictureId) {
        mPictureId = pictureId;
    }


}
