package hongzicong.rainbow.viewholder;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;
import hongzicong.rainbow.activity.NotifyDetailActivity;
import hongzicong.rainbow.utils.UIUtils;

/**
 * Created by DELL-PC on 2017/12/12.
 */

public class NotifyTopHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener{

    public static String NOTIFY_TOP_VIEW="notify_top_view_class";

    private List<Map<String,Object>> mMapList;

    private int[] icon={R.drawable.message,R.drawable.heart,R.drawable.light,
            R.drawable.help,R.drawable.reward,R.drawable.star};
    private String[] iconName={"评论","喜欢","关注","请求","赞赏","收藏"};
    private SimpleAdapter mSimpleAdapter;

    @BindView(R.id.notify_grid_view)
    GridView mGridView;

    public NotifyTopHolder(LayoutInflater inflater, ViewGroup parent){
        super(inflater.inflate(R.layout.list_notify_top_item,parent,false));
        ButterKnife.bind(this,itemView);

        mMapList=new ArrayList<>();
        getData();
        String[] from={"image","text"};
        int[] to={R.id.ic_grid_item,R.id.text_grid_item};
        mSimpleAdapter=new SimpleAdapter(UIUtils.getContext(),mMapList,R.layout.list_notify_top_grid_item,from,to);
        mGridView.setAdapter(mSimpleAdapter);
        mGridView.setOnItemClickListener(this);
    }

    private void getData(){
        for(int i=0;i<icon.length;++i){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            mMapList.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(UIUtils.getContext(), NotifyDetailActivity.class);
        intent.putExtra(NOTIFY_TOP_VIEW,position);
        UIUtils.getContext().startActivity(intent);
    }
}
