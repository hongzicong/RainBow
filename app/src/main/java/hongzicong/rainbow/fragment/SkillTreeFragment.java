package hongzicong.rainbow.fragment;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;

public class SkillTreeFragment extends Fragment {

    private TabLayout tabLayout;
    private Toolbar toolBar;

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
        tabLayout=(TabLayout)v.findViewById(R.id.tablayout);
        toolBar=(Toolbar)v.findViewById(R.id.toolbar_skill_tree);
        initAllWidget();
        return v;
    }

    private void initAllWidget(){
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolBar);
        tabLayout.addTab(tabLayout.newTab().setText("专家"));
        tabLayout.addTab(tabLayout.newTab().setText("我"));
    }

}
