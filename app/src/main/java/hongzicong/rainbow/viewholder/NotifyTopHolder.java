package hongzicong.rainbow.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import hongzicong.rainbow.R;

/**
 * Created by DELL-PC on 2017/12/12.
 */

public class NotifyTopHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public NotifyTopHolder(LayoutInflater inflater, ViewGroup parent){
        super(inflater.inflate(R.layout.list_notify_top_item,parent,false));
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void onClick(View v) {

    }

}
