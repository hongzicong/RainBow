package hongzicong.rainbow.net;

import java.util.List;

import android.content.ContentValues;
import android.util.Log;

import hongzicong.rainbow.net.MyHttpPost;

/**
 * Created by DELL-PC on 2017/11/4.
 */

public class LoginPostService {

    public static int LOGIN_FAILED=0;
    public static int LOGIN_SUCCEEDED=1;

    public static int send(List<ContentValues> params){
        int responseInt=LOGIN_FAILED;
        String servlet="LoginServlet";
        String responseMsg = MyHttpPost.executeHttpPost(servlet, params);
        Log.i("tag", "LoginService: responseMsg = " + responseMsg);
        if(responseMsg.equals("SUCCEEDED")) {
            responseInt = LOGIN_SUCCEEDED;
        }
        return responseInt;
    }

}
