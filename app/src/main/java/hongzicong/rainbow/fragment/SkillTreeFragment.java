package hongzicong.rainbow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hongzicong.rainbow.R;

public class SkillTreeFragment extends Fragment {

    public static SkillTreeFragment newInstance() {
        SkillTreeFragment fragment = new SkillTreeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_skill_tree,container,false);
        return v;
    }

}
