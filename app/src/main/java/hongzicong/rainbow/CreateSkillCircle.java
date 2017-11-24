package hongzicong.rainbow;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by DELL-PC on 2017/10/30.
 */

public class CreateSkillCircle extends View{

    private int imageId;
    private String name;
    private Context mContext;
    public WindowManager mWindowManager;
    public WindowManager.LayoutParams mLayoutParams;

    public CreateSkillCircle(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        this.mContext=context;
    }

    public CreateSkillCircle(Context context,AttributeSet attrs){
        this(context,attrs,0);
    }

    public CreateSkillCircle(Context context){
        this(context,null);
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

    public synchronized SkillCircle createSkillCircle(Context context){
        int[] location=new int[2];

        SkillCircle newSkillCircle=new SkillCircle(context);
        newSkillCircle.setName(name);
        newSkillCircle.setImageId(imageId);

        return newSkillCircle;
    }

}
