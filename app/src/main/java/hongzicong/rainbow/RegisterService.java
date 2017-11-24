package hongzicong.rainbow;

import android.content.ContentValues;
import android.util.Log;

import java.util.List;

/**
 * Created by DELL-PC on 2017/11/4.
 */

public class RegisterService {

    static int REGISTER_FAILED=0;
    static int REGISTER_SUCCEEDED=1;

    public static int send(List<ContentValues> params){
        int responseInt=REGISTER_FAILED;
        String servlet="RegisterServlet";
        String responseMsg = MyHttpPost.executeHttpPost(servlet, params);
        Log.i("tag", "RegisterService: responseMsg = " + responseMsg);
        if(responseMsg.equals("SUCCEEDED")) {
            responseInt = REGISTER_SUCCEEDED;
        }
        return responseInt;
    }

}
