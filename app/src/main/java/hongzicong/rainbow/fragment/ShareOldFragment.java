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
import hongzicong.rainbow.adapter.SharePastAdapter;
import hongzicong.rainbow.model.ShareData;
import hongzicong.rainbow.model.SharePastData;
import hongzicong.rainbow.model.User;
import hongzicong.rainbow.viewInterface.RefreshViewInterface;

public class ShareOldFragment extends SwipeRefreshFragment implements RefreshViewInterface {

    @BindView(R.id.share_past_list)
    RecyclerView mRecyclerView;

    private SharePastAdapter mSharePastAdapter;
    private List<SharePastData> mSharePastDatas;

    private boolean mIsFirstTimeTouchBottom = true;

    private Unbinder mUnbinder;

    public static ShareOldFragment getInstance(){
        ShareOldFragment shareOldFragment=new ShareOldFragment();
        return shareOldFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_share_past,container,false);
        mUnbinder= ButterKnife.bind(this,v);
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
        if (mSharePastAdapter != null) {
            mSharePastAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setSwipeRefreshing(boolean refreshing) {
        setRefreshing(refreshing);
    }

    private void initUI(){
        testDataInit();
        mSharePastAdapter=new SharePastAdapter(this,mSharePastDatas);
        mSharePastAdapter.setOnItemClickListener(new ShareNowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO 转到某一个sharedata的详细页面
            }
        });
        mRecyclerView.setAdapter(mSharePastAdapter);
    }

    private void testDataInit(){
        mSharePastDatas=new ArrayList<>();
    }


    private RecyclerView.OnScrollListener getScrollToBottomListener(final LinearLayoutManager linearLayoutManager) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int lastItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int count = mSharePastAdapter.getItemCount() - 1;
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
