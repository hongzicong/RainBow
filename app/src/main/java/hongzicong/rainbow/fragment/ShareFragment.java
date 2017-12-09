package hongzicong.rainbow.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hongzicong.rainbow.R;
import hongzicong.rainbow.model.ShareData;
import hongzicong.rainbow.model.User;


public class ShareFragment extends Fragment {

    @BindView(R.id.share_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.tablayout_share)
    TabLayout mTabLayout;

    @BindView(R.id.view_pager_share)
    ViewPager mViewPager;

    private ShareAdapter mShareAdapter;
    private List<ShareData> mShareDataList;

    private Unbinder mUnbinder;


    class ShareHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.title_text)
        TextView title;

        @BindView(R.id.circle_image)
        ImageView avatarImage;

        @BindView(R.id.name_text)
        TextView name;

        @BindView(R.id.applaud_num)
        TextView favourNum;

        @BindView(R.id.comment_num)
        TextView commentNum;

        @BindView(R.id.article_text)
        TextView articleText;

        private ShareData mShareData;

        public ShareHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_share_item,parent,false));
            ButterKnife.bind(this,itemView);
        }

        public void bind(ShareData shareData){
            mShareData=shareData;
            avatarImage.setImageResource(mShareData.getUser().getPictureId());
            commentNum.setText(mShareData.getCommentNum()+"评论数");
            favourNum.setText(mShareData.getFavourNum()+"赞同数");
            name.setText(mShareData.getUser().getUserName());
            title.setText(mShareData.getTitle());
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
            ShareData shareData=mShareDatas.get(position);
            holder.bind(shareData);
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
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_share,container,false);

        mUnbinder=ButterKnife.bind(this,v);

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

}
