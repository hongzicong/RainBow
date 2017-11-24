package hongzicong.rainbow;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.LayoutInflater;

/**
 * Created by DELL-PC on 2017/10/30.
 */

public class SkillCircleAdapter extends RecyclerView.Adapter<SkillCircleAdapter.ViewHolder> implements View.OnClickListener{

    private List<CreateSkillCircle> mCircleList;
    private OnItemClickListener mOnItemClickListener=null;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView circleImage;

        public ViewHolder(View view){
            super(view);
            circleImage=(ImageView)view.findViewById(R.id.circle_image);
        }
    }

    public SkillCircleAdapter(List<CreateSkillCircle> CircleList){
        mCircleList=CircleList;
    }

    @Override
    public void onClick(View v) {
        if(mOnItemClickListener!=null){
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.create_skill_circle,parent,false);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CreateSkillCircle circle=mCircleList.get(position);
        holder.circleImage.setImageResource(circle.getImageId());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mCircleList.size();
    }


}
