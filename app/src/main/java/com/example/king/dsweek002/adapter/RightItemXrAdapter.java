package com.example.king.dsweek002.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.king.dsweek002.R;
import com.example.king.dsweek002.beans.RightCls;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RightItemXrAdapter extends XRecyclerView.Adapter<RightItemXrAdapter.RightItemXrVH> {

    private Context context;
    private List<RightCls.DataBean.ListBean> list;

    public RightItemXrAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void setList(List<RightCls.DataBean.ListBean> list) {
        if (list != null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RightItemXrVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item_item,viewGroup,false);
        RightItemXrVH rightItemXrVH = new RightItemXrVH(view);
        return rightItemXrVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RightItemXrVH rightItemXrVH, int i) {
        RightCls.DataBean.ListBean listBean = list.get(i);

        rightItemXrVH.right_item_text.setText(listBean.getName());

        Glide.with(context).load(listBean.getIcon()).into(rightItemXrVH.rig_item_img);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class RightItemXrVH extends XRecyclerView.ViewHolder{

        ImageView rig_item_img;
        TextView right_item_text;
        public RightItemXrVH(@NonNull View itemView) {
            super(itemView);
            rig_item_img = itemView.findViewById(R.id.rig_item_img);
            right_item_text = itemView.findViewById(R.id.right_item_text);
        }
    }
}
