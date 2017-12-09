package hongzicong.rainbow.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import hongzicong.rainbow.view.ProgressHelper;

/**
 * Created by DELL-PC on 2017/12/10.
 */

public class BaseFragment extends Fragment {

    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext=getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void toast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    private ProgressHelper progressHelper;

    public void showProgress() {
        showProgress(null);
    }

    public void showProgress(String msg) {
        if (progressHelper == null) {
            progressHelper = new ProgressHelper(getActivity());
        }
        progressHelper.showProgress(msg);
    }

    public void hideProgress() {
        progressHelper.hideProgress();
    }

}
