package hongzicong.rainbow;

import java.util.List;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

import android.content.ContentValues;
import android.util.Log;

/**
 * Created by DELL-PC on 2017/11/4.
 */

public class MyHttpPost {

    //// TODO: 2017/11/5  
    private static String SERVER="http://192.168.1.109:8080";
    private static String PROJECT="/";

    private static final int REQUEST_TIMEOUT=0;
    private static final int SO_TIMEOUT=0;

    public static String executeHttpPost(String servlet,List<ContentValues> params){

        String baseURL=SERVER+PROJECT+servlet;
        String responseMsg="FAILED";

        try {
            URL url=new URL(baseURL);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(REQUEST_TIMEOUT);
            connection.setReadTimeout(SO_TIMEOUT);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            String data="password="+URLEncoder.encode(params.get(0).getAsString("password"),"UTF-8")+
                    "&username="+URLEncoder.encode(params.get(0).getAsString("id"),"UTF-8");

            Log.i("tag",data);
            OutputStream out=connection.getOutputStream();

            out.write(data.getBytes());
            out.flush();
            out.close();
            connection.connect();

            int statusCode=connection.getResponseCode();
            Log.i("tag",""+statusCode);
            if(statusCode==200){
                InputStream inputStream=connection.getInputStream();
                ByteArrayOutputStream message=new ByteArrayOutputStream();
                int len=0;
                byte buffer[]=new byte[1024];
                while((len=inputStream.read(buffer))!=-1){
                    message.write(buffer,0,len);
                }
                inputStream.close();
                message.close();
                responseMsg=new String(message.toByteArray());
                return responseMsg;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.i("tag","RegisterHttpPost:responseMsg = "+responseMsg);
        return responseMsg;
    }

}
