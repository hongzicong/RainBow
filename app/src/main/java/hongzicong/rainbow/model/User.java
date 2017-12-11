package hongzicong.rainbow.model;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by DELL-PC on 2017/12/8.
 */

//用来存用户资料
@Table(name="user")
public class User {

    @Column(name = "userId",isId = true)
    private int mUserId;

    @Column(name = "name")
    private String mUserName;

    @Column(name = "pictureId")
    private int mPictureId;

    @Column(name = "intro")
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
