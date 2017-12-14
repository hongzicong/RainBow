package hongzicong.rainbow.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;
import hongzicong.rainbow.utils.UIUtils;

/**
 * Created by DELL-PC on 2017/12/11.
 */


public class ShareNowCenterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private List<Map<String,Object>> mMapList;

    private int[] icon={R.drawable.book,R.drawable.data,R.drawable.website,
            R.drawable.app};
    private String[] iconName={"书籍","资料","网站","App"};
    private SimpleAdapter mSimpleAdapter;

    @BindView(R.id.share_now_grid_view)
    GridView mGridView;

    public ShareNowCenterHolder(LayoutInflater inflater, ViewGroup parent){
        super(inflater.inflate(R.layout.list_share_now_center_item,parent,false));
        ButterKnife.bind(this,itemView);

        mMapList=new ArrayList<>();
        getData();
        String[] from={"image","text"};
        int[] to={R.id.square_image,R.id.square_text};
        mSimpleAdapter=new SimpleAdapter(UIUtils.getContext(),mMapList,R.layout.list_share_now_center_grid_item,from,to);
        mGridView.setAdapter(mSimpleAdapter);

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
    public void onClick(View v) {

    }
}
