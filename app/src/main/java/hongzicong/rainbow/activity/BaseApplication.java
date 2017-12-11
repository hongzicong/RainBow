package hongzicong.rainbow.activity;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by DELL-PC on 2017/12/11.
 */

public class BaseApplication extends Application {

    private static Context mContext;
    private static Thread  mMainThread;
    private static Handler mMainHandler;

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static Handler getMainHandler() {
        return mMainHandler;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mMainThread = Thread.currentThread();
        mMainHandler = new Handler();
    }

}