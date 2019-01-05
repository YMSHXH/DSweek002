package com.example.king.dsweek002.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.king.dsweek002.R;
import com.example.king.dsweek002.beans.LeftCls;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LeftXrecyclerViewAdapter extends XRecyclerView.Adapter<LeftXrecyclerViewAdapter.LeftXrecyclerVH> {

    private ItemClickListener itemClickListener;
    private Context context;
    private List<LeftCls.DataBean> list;

    public LeftXrecyclerViewAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void setList(List<LeftCls.DataBean> list) {
        if (list != null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LeftXrecyclerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.leftxr_item,viewGroup,false);
        LeftXrecyclerVH leftXrecyclerVH = new LeftXrecyclerVH(view);
        return leftXrecyclerVH;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftXrecyclerVH leftXrecyclerVH, final int i) {
        final LeftCls.DataBean dataBean = list.get(i);
        leftXrecyclerVH.left_text.setText(dataBean.getName());

        //点击事件
        leftXrecyclerVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.click(dataBean.getCid());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    class LeftXrecyclerVH extends XRecyclerView.ViewHolder{

        TextView left_text;
        public LeftXrecyclerVH(@NonNull View itemView) {
            super(itemView);
            left_text = itemView.findViewById(R.id.left_text);
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void click(String cid);
    }
}
