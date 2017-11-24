package hongzicong.rainbow;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;


public class RegisterAcitvity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button register;
    private Handler handler;
    private Dialog dialog;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initWidget();
        actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        setAllClickListener();
        handler=new Handler(){
            public void handlerMessage(Message msg){
                super.handleMessage(msg);
                dialog.dismiss();
                if(msg.what==222){
                    if(msg.obj.toString().equals("SUCCESSED")){
                        Toast.makeText(RegisterAcitvity.this,"注册成功！但是后面的还没做！",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegisterAcitvity.this,"注册失败，自己看看哪里没写好！！！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
    }

    private void initWidget(){
        name=(EditText)findViewById(R.id.register_name);
        password=(EditText)findViewById(R.id.register_password);
        register=(Button)findViewById(R.id.register_register_button);
    }

    private void setAllClickListener(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConnectToInternet()){
                    if(isValidName()&&isValidPassword()){
                        dialog=new Dialog(RegisterAcitvity.this);
                        dialog.setTitle("少女祈祷中...");
                        dialog.setCancelable(false);
                        dialog.show();
                        new RegisterPostThread(name.getText().toString(),password.getText().toString()).start();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"请输入合法账号",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"网络未连接",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class RegisterPostThread extends Thread {

        public String id, password;

        public RegisterPostThread(String id, String password) {
            this.id = id;
            this.password = password;
        }

        @Override
        public void run() {
            int responseInt = 0;
            if(!id.equals("")) {
                ContentValues contentValues=new ContentValues();
                List<ContentValues> params = new ArrayList<>();
                contentValues.put("id",id);
                contentValues.put("password",password);
                params.add(contentValues);
                responseInt = RegisterService.send(params);
                Log.i("tag", "RegisterActivity: responseInt = " + responseInt);
                Message msg = handler.obtainMessage();
                msg.what = 222;
                if(responseInt == RegisterService.REGISTER_FAILED) {
                    msg.obj = "FAILED";
                }else if(responseInt == RegisterService.REGISTER_SUCCEEDED) {
                    msg.obj = "SUCCEEDED";
                }
                handler.sendMessage(msg);
            }
        }
    }


    public boolean isConnectToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            Network[] networks=connectivity.getAllNetworks();
            NetworkInfo networkInfo;
            for(Network mNetword:networks){
                networkInfo=connectivity.getNetworkInfo(mNetword);
                if(networkInfo.getState().equals(NetworkInfo.State.CONNECTED)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidName(){
        String nameStr=name.getText().toString();
        if(!TextUtils.isEmpty(nameStr)&&isStudentEmail(nameStr)){
            return true;
        }
        return false;
    }

    private boolean isStudentEmail(String email){
        //todo
        return true;
    }

    private boolean isValidPassword(){
        //todo
        return true;
    }

}
