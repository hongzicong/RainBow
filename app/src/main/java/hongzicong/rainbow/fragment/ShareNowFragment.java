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
import hongzicong.rainbow.adapter.ShareNowAdapter;
import hongzicong.rainbow.model.ShareData;
import hongzicong.rainbow.model.User;
import hongzicong.rainbow.viewInterface.RefreshViewInterface;

public class ShareNowFragment extends SwipeRefreshFragment implements RefreshViewInterface {

    @BindView(R.id.share_now_list)
    RecyclerView mRecyclerView;

    private ShareNowAdapter mShareAdapter;
    private List<ShareData> mShareDataList;

    private boolean mIsFirstTimeTouchBottom = true;

    private Unbinder mUnbinder;

    public static ShareNowFragment getInstance(){
        ShareNowFragment shareNowFragment=new ShareNowFragment();
        return shareNowFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_share_now,container,false);
        mUnbinder=ButterKnife.bind(this,v);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initUI();
        return v;
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
        if (mShareAdapter != null) {
            mShareAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setSwipeRefreshing(boolean refreshing) {
        setRefreshing(refreshing);
    }

    private void initUI(){
        testDataInit();
        mShareAdapter=new ShareNowAdapter(this,mShareDataList);
        mShareAdapter.setOnItemClickListener(new ShareNowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO 转到某一个sharedata的详细页面
            }
        });
        mRecyclerView.setAdapter(mShareAdapter);
    }

    private void testDataInit(){
        mShareDataList=new ArrayList<>();
        User userA=new User(1,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataA=new ShareData(userA,"TestTitle","TestTag","TestIntro",1,2);
        User userB=new User(2,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataB=new ShareData(userB,"TestTitle","TestTag","TestIntro",2,3);
        User userC=new User(3,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataC=new ShareData(userC,"TestTitle","TestTag","TestIntro",3,4);
        User userD=new User(4,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataD=new ShareData(userD,"TestTitle","TestTag","TestIntro",4,5);
        User userE=new User(5,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataE=new ShareData(userE,"TestTitle","TestTag","TestIntro",5,6);
        mShareDataList.add(dataA);
        mShareDataList.add(dataB);
        mShareDataList.add(dataC);
        mShareDataList.add(dataD);
        mShareDataList.add(dataE);
    }

    private RecyclerView.OnScrollListener getScrollToBottomListener(final LinearLayoutManager linearLayoutManager) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int lastItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int count = mShareAdapter.getItemCount() - 1;
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
