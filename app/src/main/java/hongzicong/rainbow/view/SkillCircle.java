package hongzicong.rainbow.view;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.view.WindowManager;
import android.view.Gravity;
import android.view.ViewConfiguration;

import hongzicong.rainbow.R;
import hongzicong.rainbow.model.SkillCircleData;

/**
 * Created by DELL-PC on 2017/10/30.
 */

public class SkillCircle extends View implements View.OnTouchListener{

    private SkillCircleData mSkillCircleData;

    private int imageId;
    private String name;
    private int[] location;
    private Context mContext;
    public WindowManager mWindowManager;
    public WindowManager.LayoutParams mLayoutParams;

    private int lastX;
    private int lastY;

    private int screenWidth;
    private int screenHeight;

    private int left,right,top,bottom;

    private boolean isMove=false;
    private int touchSlop=0;
    float touchX,touchY;

    public SkillCircle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initContext(context);
    }

    public SkillCircle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkillCircle(Context context) {
        this(context, null);
    }

    //一定要调用，到时重构要改一改
    public void setSkillCircleData(SkillCircleData skillCircleData){
        mSkillCircleData=skillCircleData;
    }

    public int getXInPool(){
        return mSkillCircleData.getX();
    }

    public int getYInPool(){
        return mSkillCircleData.getY();
    }

    private void initContext(Context context){
        mContext=context;
        mWindowManager=(WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        mLayoutParams=new WindowManager.LayoutParams();

        setClickable(true);
        setOnTouchListener(this);

        DisplayMetrics displayMetrics=context.getResources().getDisplayMetrics();
        screenWidth=displayMetrics.widthPixels;
        screenHeight=displayMetrics.heightPixels;

        touchSlop=ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId){
        this.imageId=imageId;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public void addViewToScreen(){
        this.setBackground(getResources().getDrawable(R.drawable.math));
        mLayoutParams.x=location[0];
        mLayoutParams.y=location[1];
        mWindowManager.addView(this,mLayoutParams);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isMove=false;

                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();

                touchX=event.getX();
                touchY=event.getY();

                break;
            case MotionEvent.ACTION_MOVE:

                if(Math.abs(event.getX()-touchX)>touchSlop||Math.abs(event.getX()-touchY)>touchSlop){
                    isMove=true;
                    int dx = (int) event.getRawX() - lastX;
                    int dy = (int) event.getRawY() - lastY;

                    int left = v.getLeft() + dx;
                    int top = v.getTop() + dy;
                    int right = v.getRight() + dx;
                    int bottom = v.getBottom() + dy;

                    if (left < 0) {
                        left = 0;
                        right = left + v.getWidth();
                    }
                    if (right > screenWidth) {
                        right = screenWidth;
                        left = right - v.getWidth();
                    }
                    if (top < 0) {
                        top = 0;
                        bottom = top + v.getHeight();
                    }
                    if (bottom > screenHeight) {
                        bottom = screenHeight;
                        top = bottom - v.getHeight();
                    }

                    v.layout(left, top, right, bottom);
                    lastX = (int) event.getRawX();
                    lastY = (int) event.getRawY();
                    return true;
                }

                break;
            case MotionEvent.ACTION_UP:
                if(isMove){
                    isMove=false;
                    //if not correct return before
                    v.layout(left,top,right,bottom);
                    return true;
                }
                touchX=touchY=0;
                break;
        }

        return false;
    }


}

