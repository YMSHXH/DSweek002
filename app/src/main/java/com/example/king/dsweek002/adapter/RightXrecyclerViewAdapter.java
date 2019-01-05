package com.example.king.dsweek002.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.king.dsweek002.R;
import com.example.king.dsweek002.beans.LeftCls;
import com.example.king.dsweek002.beans.RightCls;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RightXrecyclerViewAdapter extends XRecyclerView.Adapter<RightXrecyclerViewAdapter.RightXrecyclerVH> {

    private Context context;
    private List<RightCls.DataBean> list;

    public RightXrecyclerViewAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void setList(List<RightCls.DataBean> list) {
        if (list != null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RightXrecyclerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rightxr_item,viewGroup,false);
        RightXrecyclerVH rightXrecyclerVH = new RightXrecyclerVH(view);
        return rightXrecyclerVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RightXrecyclerVH rightXrecyclerVH, int i) {
        rightXrecyclerVH.right_text.setText(list.get(i).getName());
        List<RightCls.DataBean.ListBean> list = this.list.get(i).getList();

        RightItemXrAdapter rightItemXrAdapter = new RightItemXrAdapter(context);
        rightItemXrAdapter.setList(list);
        rightXrecyclerVH.rig_item_xr.setAdapter(rightItemXrAdapter);
        rightXrecyclerVH.rig_item_xr.setLayoutManager(new GridLayoutManager(context,3));


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    class RightXrecyclerVH extends XRecyclerView.ViewHolder{
        TextView right_text;
        XRecyclerView rig_item_xr;

        public RightXrecyclerVH(@NonNull View itemView) {
            super(itemView);
            right_text = itemView.findViewById(R.id.right_text);
            rig_item_xr = itemView.findViewById(R.id.rig_item_xr);
        }
    }
}
