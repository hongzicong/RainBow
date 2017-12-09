package hongzicong.rainbow.viewInterface;

import android.content.Context;

/**
 * Created by DELL-PC on 2017/12/10.
 */

public interface MVPView {

    Context getContext();

    void showProgress();
    void hideProgress();

    void toast(String msg);

}
