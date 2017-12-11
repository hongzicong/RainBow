package hongzicong.rainbow.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by DELL-PC on 2017/12/11.
 */

public class ProgressViewPager extends ViewPager{

    public ProgressViewPager(Context context) {
        super(context);
    }

    public ProgressViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}
