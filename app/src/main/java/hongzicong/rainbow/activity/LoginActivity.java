package hongzicong.rainbow.activity;

import java.util.List;
import java.util.ArrayList;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.os.Handler;
import android.net.ConnectivityManager;
import android.net.*;
import android.app.Dialog;
import android.content.*;
import android.util.Log;
import android.os.Message;
import android.text.TextUtils;
import android.support.v7.app.ActionBar;

import hongzicong.rainbow.net.LoginPostService;
import hongzicong.rainbow.R;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private Button forget;
    private Button register;
    private Handler handler;
    private Dialog  dialog;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((ConstraintLayout)findViewById(R.id.login_layout)).setSystemUiVisibility(View.INVISIBLE);
        initWidget();
        hideBar();
        setAllClickListener();
        handler=new Handler(){
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                dialog.dismiss();
                if(msg.what==111){
                    if(msg.obj.toString().equals("SUCCEEDED")){
                        goToHomeActivity();
                    }else{
                        Toast.makeText(LoginActivity.this,"账户不存在或者密码错误！！！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
    }

    private void hideBar(){
        actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }

    private void initWidget(){
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        name.setText(getUserName());
        forget=(Button)findViewById(R.id.forget_password);
    }

    private void setAllClickListener(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConnectToInternet()){
                    if(isValidName()){
                        saveUserName();
                        goToHomeActivity();
                        //Todo 完成服务器端才开启以下登陆功能
                        /*
                        dialog=new Dialog(LoginActivity.this);
                        dialog.setTitle("少女祈祷中...");
                        dialog.setCancelable(false);
                        dialog.show();
                        new LoginPostThread(name.getText().toString(),password.getText().toString()).start();*/
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
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegisterActivity();
            }
        });
        forget.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Todo 找回密码系统
            }
        });
    }

    public class LoginPostThread extends Thread {
        public String id, password;

        public LoginPostThread(String id, String password) {
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
                responseInt = LoginPostService.send(params);
                Log.i("tag", "LoginActivity: responseInt = " + responseInt);
                Message msg = handler.obtainMessage();
                msg.what = 111;
                if(responseInt == LoginPostService.LOGIN_FAILED) {
                    msg.obj = "FAILED";
                }else if(responseInt == LoginPostService.LOGIN_SUCCEEDED) {
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

    //判断是否为邮箱
    private boolean isValidName(){
        String nameStr=name.getText().toString();
        if(!TextUtils.isEmpty(nameStr)&&isStudentEmail(nameStr)){
            return true;
        }
        return false;
    }

    //判断是否为学生邮箱
    private boolean isStudentEmail(String email){
        //todo 学正则表达式
        return true;
    }

    //登陆成功，去往主页面
    private void goToHomeActivity(){
        Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    private void goToRegisterActivity(){
        //todo 改成左右滑动的好不好
        Intent intent=new Intent(LoginActivity.this,RegisterAcitvity.class);
        startActivity(intent);
    }

    private void saveUserName(){
        //todo 要不要存进数据库
        SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("name",name.getText().toString());
        editor.apply();
    }

    private String getUserName(){
        //todo 要不要从数据库中取出来
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        String name=pref.getString("name","");
        return name;
    }

}