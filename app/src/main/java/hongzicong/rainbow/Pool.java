package hongzicong.rainbow;

import java.util.List;

import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.view.View.OnClickListener;
import android.view.WindowManager;

/**
 * Created by DELL-PC on 2017/10/30.
 */

class Pool extends HorizontalScrollView /*implements OnClickListener*/{

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Integer> mDatas;

    public Pool(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
    }

    public Pool(Context context,AttributeSet attrs){
        this(context,attrs,0);
    }

    public Pool(Context context){
        this(context,null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
