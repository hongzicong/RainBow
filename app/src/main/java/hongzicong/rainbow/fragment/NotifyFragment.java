package hongzicong.rainbow.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hongzicong.rainbow.R;
import hongzicong.rainbow.activity.NotifyDetailActivity;
import hongzicong.rainbow.adapter.NotifyAdapter;
import hongzicong.rainbow.model.NotifyData;
import hongzicong.rainbow.model.User;
import hongzicong.rainbow.viewInterface.RefreshViewInterface;

public class NotifyFragment extends SwipeRefreshFragment implements RefreshViewInterface {

    public static final String EXTRA_NOTIFY_NAME="hongzicong.rainbow.fragment.notify.user_name";
    public static final String EXTRA_NOTIFY_PICTURE_ID="hongzicong.rainbow.fragment.notify.picture_id";
    public static final String EXTRA_NOTIFY_AWARD="hongzicong.rainbow.fragment.notify.award";
    public static final String EXTRA_NOTIFY_ARTICAL="hongzicong.rainbow.fragment.notify.artical";

    @BindView(R.id.toolbar_notify)
    Toolbar mToolbar;

    @BindView(R.id.notify_list)
    RecyclerView mRecyclerView;

    private NotifyAdapter mNotifyAdapter;
    private List<NotifyData> mNotifyDatas;

    private boolean mIsFirstTimeTouchBottom = true;

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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        //todo 搞懂有什么用
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initUI();
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }



    private RecyclerView.OnScrollListener getScrollToBottomListener(final LinearLayoutManager linearLayoutManager) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int lastItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int count = mNotifyAdapter.getItemCount() - 1;
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

    @Override
    public void refreshList() {
        if (mNotifyAdapter != null) {
            mNotifyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setSwipeRefreshing(boolean refreshing) {
        setRefreshing(refreshing);
    }

    private void initUI(){
        testDataInit();
        mNotifyAdapter=new NotifyAdapter(this,mNotifyDatas);
        mRecyclerView.setAdapter(mNotifyAdapter);
        mNotifyAdapter.setOnItemClickListener(new NotifyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("HONGZICONG","1");
                Intent intent=new Intent(getActivity(),NotifyDetailActivity.class);
                intent.putExtra(EXTRA_NOTIFY_NAME,mNotifyDatas.get(position-2).getUser().getUserName());
                intent.putExtra(EXTRA_NOTIFY_ARTICAL,mNotifyDatas.get(position-2).getArticle());
                intent.putExtra(EXTRA_NOTIFY_AWARD,mNotifyDatas.get(position-2).getAward());
                intent.putExtra(EXTRA_NOTIFY_PICTURE_ID,mNotifyDatas.get(position-2).getUser().getPictureId());
                startActivity(intent);
            }
        });
    }


    private void testDataInit(){
        mNotifyDatas=new ArrayList<>();
        User user=new User(1,"TestName",R.drawable.test_avatar,"TestIntro");
        NotifyData notifyData=new NotifyData(user,"TestIntro","TestTag","TestArticle","TestAward",1);
        mNotifyDatas.add(notifyData);
        notifyData=new NotifyData(user,"TestIntro","TestTag","TestArticle","TestAward",2);
        mNotifyDatas.add(notifyData);
        notifyData=new NotifyData(user,"TestIntro","TestTag","TestArticle","TestAward",3);
        mNotifyDatas.add(notifyData);
        notifyData=new NotifyData(user,"TestIntro","TestTag","TestArticle","TestAward",4);
        mNotifyDatas.add(notifyData);
        notifyData=new NotifyData(user,"TestIntro","TestTag","TestArticle","TestAward",5);
        mNotifyDatas.add(notifyData);
        notifyData=new NotifyData(user,"TestIntro","TestTag","TestArticle","TestAward",6);
        mNotifyDatas.add(notifyData);
    }

}
