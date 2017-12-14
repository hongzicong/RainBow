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
import hongzicong.rainbow.adapter.SkillTreeExpertAdapter;
import hongzicong.rainbow.model.SkillTreeExpertData;
import hongzicong.rainbow.viewInterface.RefreshViewInterface;

/**
 * Created by DELL-PC on 2017/12/14.
 */

public class SkillTreeExpertFragment extends SwipeRefreshFragment implements RefreshViewInterface {

    @BindView(R.id.skill_tree_expert_list)
    RecyclerView mRecyclerView;

    private SkillTreeExpertAdapter mSkillTreeExpertAdapter;
    private List<SkillTreeExpertData> mSkillTreeExpertDatas;

    private boolean mIsFirstTimeTouchBottom = true;

    private Unbinder mUnbinder;

    public static SkillTreeExpertFragment getInstance(){
        SkillTreeExpertFragment skillTreeExpertFragment=new SkillTreeExpertFragment();
        return skillTreeExpertFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_skill_tree_expert,container,false);
        mUnbinder= ButterKnife.bind(this,v);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initUI();
        return v;
    }

    private void initUI(){
        mSkillTreeExpertDatas=new ArrayList<>();
    }

    private void testDataInit(){
        mSkillTreeExpertDatas=new ArrayList<>();

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
        if (mSkillTreeExpertAdapter != null) {
            mSkillTreeExpertAdapter.notifyDataSetChanged();
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
                int count = mSkillTreeExpertAdapter.getItemCount() - 1;
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
