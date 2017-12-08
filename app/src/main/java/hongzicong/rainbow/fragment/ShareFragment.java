package hongzicong.rainbow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hongzicong.rainbow.R;
import hongzicong.rainbow.model.ShareData;
import hongzicong.rainbow.model.User;


public class ShareFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ShareAdapter mShareAdapter;
    private List<ShareData> mShareDataList;

    private class ShareHolder extends RecyclerView.ViewHolder{

        public ShareHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_share_item,parent,false));
        }
    }

    private class ShareAdapter extends RecyclerView.Adapter<ShareHolder>{

        private List<ShareData> mShareDatas;

        public ShareAdapter(List<ShareData> shareDatas){
            this.mShareDatas=shareDatas;
        }

        @Override
        public ShareHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new ShareHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(ShareHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mShareDatas.size();
        }
    }

    public static ShareFragment newInstance() {
        ShareFragment fragment = new ShareFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_share,container,false);
        mRecyclerView=(RecyclerView)v.findViewById(R.id.share_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }

    private void updateUI(){
        testDataInit();
        mShareAdapter=new ShareAdapter(mShareDataList);
        mRecyclerView.setAdapter(mShareAdapter);
    }

    private void testDataInit(){
        mShareDataList=new ArrayList<>();
        User userA=new User(1,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataA=new ShareData(userA,"TestTitle","TestTag","TestIntro");
        User userB=new User(2,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataB=new ShareData(userB,"TestTitle","TestTag","TestIntro");
        User userC=new User(3,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataC=new ShareData(userC,"TestTitle","TestTag","TestIntro");
        User userD=new User(4,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataD=new ShareData(userD,"TestTitle","TestTag","TestIntro");
        User userE=new User(5,"TestName",R.drawable.test_avatar,"TestUserIntro");
        ShareData dataE=new ShareData(userE,"TestTitle","TestTag","TestIntro");
        mShareDataList.add(dataA);
        mShareDataList.add(dataB);
        mShareDataList.add(dataC);
        mShareDataList.add(dataD);
        mShareDataList.add(dataE);
    }

}
