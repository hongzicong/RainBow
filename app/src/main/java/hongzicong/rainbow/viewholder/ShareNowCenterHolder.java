package hongzicong.rainbow.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import hongzicong.rainbow.R;

/**
 * Created by DELL-PC on 2017/12/11.
 */


public class ShareNowCenterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @BindView(R.id.question_layout)
    LinearLayout quesionLayout;

    @BindView(R.id.rank_layout)
    LinearLayout rankLayout;

    @BindView(R.id.square_layout)
    LinearLayout squareLayout;

    @BindView(R.id.update_layout)
    LinearLayout updateLayout;

    public ShareNowCenterHolder(LayoutInflater inflater, ViewGroup parent){
        super(inflater.inflate(R.layout.list_share_now_center_item,parent,false));
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void onClick(View v) {

    }
}
