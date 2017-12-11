package hongzicong.rainbow.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import hongzicong.rainbow.R;

/**
 * Created by DELL-PC on 2017/12/11.
 */

public class ShareNowTopHolder extends RecyclerView.ViewHolder {

    public ShareNowTopHolder(LayoutInflater inflater, ViewGroup parent){
        super(inflater.inflate(R.layout.list_share_now_top_item,parent,false));
        ButterKnife.bind(this,itemView);
    }

}
