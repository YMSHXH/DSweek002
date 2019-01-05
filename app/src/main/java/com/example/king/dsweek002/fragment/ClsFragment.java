package com.example.king.dsweek002.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.king.dsweek002.adapter.LeftXrecyclerViewAdapter;
import com.example.king.dsweek002.R;
import com.example.king.dsweek002.adapter.RightXrecyclerViewAdapter;
import com.example.king.dsweek002.beans.LeftCls;
import com.example.king.dsweek002.beans.RightCls;
import com.example.king.dsweek002.contact.ClsContact;
import com.example.king.dsweek002.presenter.ClsPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ClsFragment extends Fragment implements ClsContact.IClsView{

    private Unbinder bind;

    @BindView(R.id.xre_left)
    XRecyclerView xre_left;
    @BindView(R.id.xre_right)
    XRecyclerView xre_right;
    private ClsPresenter clsPresenter;
    private LeftXrecyclerViewAdapter leftXrecyclerViewAdapter;
    private RightXrecyclerViewAdapter rightXrecyclerViewAdapter;
    private Map<String, String> param;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cls,container,false);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initView() {

        xre_left.setLayoutManager(new LinearLayoutManager(getActivity()));
        xre_right.setLayoutManager(new LinearLayoutManager(getActivity()));

        leftXrecyclerViewAdapter = new LeftXrecyclerViewAdapter(getActivity());
        rightXrecyclerViewAdapter = new RightXrecyclerViewAdapter(getActivity());
        //设置适配器
        xre_left.setAdapter(leftXrecyclerViewAdapter);
        xre_right.setAdapter(rightXrecyclerViewAdapter);

        leftXrecyclerViewAdapter.setItemClickListener(new LeftXrecyclerViewAdapter.ItemClickListener() {
            @Override
            public void click(String cid) {
                param.put("cid",cid + "");
                clsPresenter.getRight(param);
            }
        });
    }

    private void initData() {
        clsPresenter = new ClsPresenter(this);
        clsPresenter.getLeft(null);
        param = new HashMap<>();
        param.put("cid","1");
        clsPresenter.getRight(param);

    }


    @Override
    public void onFailureLeft(String msg) {

    }

    @Override
    public void onSuccessLeft(List<LeftCls.DataBean> list) {
        //Toast.makeText(getActivity(),list.get(1).getName(),Toast.LENGTH_SHORT).show();
        leftXrecyclerViewAdapter.setList(list);
    }

    @Override
    public void onFailureRight(String msg) {

    }

    @Override
    public void onSuccessRight(List<RightCls.DataBean> list) {
        //Toast.makeText(getActivity(),list+"",Toast.LENGTH_SHORT).show();
        rightXrecyclerViewAdapter.setList(list);
    }

}
