package hongzicong.rainbow.utils;

import android.text.TextUtils;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class OtherUtils {

    public static boolean isValidName(String nameStr){
        if(!TextUtils.isEmpty(nameStr)&&isStudentEmail(nameStr)){
            return true;
        }
        return false;
    }

    public static boolean isStudentEmail(String email){
        //todo 学正则表达式
        return true;
    }

    public static boolean isValidPassword(String password){
        //todo
        return true;
    }

}
