package hongzicong.rainbow.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hongzicong.rainbow.R;

public class NotifyFragment extends Fragment {

    @BindView(R.id.toolbar_notify)
    Toolbar mToolbar;

    @BindView(R.id.notify_list)
    RecyclerView mRecyclerView;

    private Unbinder mUnbinder;

    public static NotifyFragment newInstance() {
        NotifyFragment fragment = new NotifyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_notify,container,false);

        WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
        localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);

        mUnbinder= ButterKnife.bind(this,v);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
