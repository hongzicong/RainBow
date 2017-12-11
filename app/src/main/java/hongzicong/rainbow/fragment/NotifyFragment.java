package hongzicong.rainbow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hongzicong.rainbow.R;

public class NotifyFragment extends Fragment {

    private class NotifyHolder extends RecyclerView.ViewHolder{

        public NotifyHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_share_now_bottom_item,parent,false));
        }

    }

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
        return v;
    }

}
