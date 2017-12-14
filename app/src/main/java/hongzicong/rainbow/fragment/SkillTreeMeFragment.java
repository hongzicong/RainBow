package hongzicong.rainbow.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hongzicong.rainbow.R;
import hongzicong.rainbow.adapter.SkillTreeMeAdapter;
import hongzicong.rainbow.model.SkillTreeMeData;
import hongzicong.rainbow.viewInterface.RefreshViewInterface;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class SkillTreeMeFragment extends SwipeRefreshFragment implements RefreshViewInterface {

    @BindView(R.id.skill_tree_me_list)
    RecyclerView mRecyclerView;

    private SkillTreeMeAdapter mSkillTreeMeAdapter;
    private List<SkillTreeMeData> mSkillTreeMeDatas;

    private boolean mIsFirstTimeTouchBottom = true;

    private Unbinder mUnbinder;

    public static SkillTreeMeFragment getInstance(){
        SkillTreeMeFragment skillTreeMeFragment=new SkillTreeMeFragment();
        return skillTreeMeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_skill_tree_me,container,false);
        mUnbinder= ButterKnife.bind(this,v);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initUI();
        return v;
    }

    private void initUI(){

    }

    private void testDataInit(){
        mSkillTreeMeDatas=new ArrayList<>();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onRefreshing() {
        super.onRefreshing();
    }

    @Override
    public void refreshList() {
        if (mSkillTreeMeAdapter != null) {
            mSkillTreeMeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setSwipeRefreshing(boolean refreshing) {
        setRefreshing(refreshing);
    }

    private RecyclerView.OnScrollListener getScrollToBottomListener(final LinearLayoutManager linearLayoutManager) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int lastItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int count = mSkillTreeMeAdapter.getItemCount() - 1;
                boolean isBottom = (lastItem == count);
                if (!mSwipeRefreshLayout.isRefreshing() && isBottom) {
                    if (!mIsFirstTimeTouchBottom) {
                        Log.e("onScrolled=>", "refresh.... ");
                        //todo 载入新页面
                    } else {
                        mIsFirstTimeTouchBottom = false;
                    }
                }
            }
        };
    }


}
