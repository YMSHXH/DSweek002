package com.example.king.dsweek002.presenter;

import com.example.king.dsweek002.beans.LeftCls;
import com.example.king.dsweek002.beans.RightCls;
import com.example.king.dsweek002.contact.ClsContact;
import com.example.king.dsweek002.model.ClsModel;
import com.example.king.dsweek002.net.OKhttpUtilsCallBack;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class ClsPresenter extends ClsContact.IClsPresenter {

    private ClsContact.IClsView iClsView;
    private ClsModel clsModel;

    public ClsPresenter(ClsContact.IClsView iClsView) {
        this.iClsView = iClsView;
        this.clsModel = new ClsModel();
    }

    @Override
    public void getLeft(Map<String, String> param) {
        if (iClsView != null){
            clsModel.getLeft(param, new OKhttpUtilsCallBack() {
                @Override
                public void failure(String msg) {
                    if (iClsView != null) {
                        iClsView.onFailureLeft(msg);
                    }
                }

                @Override
                public void success(String result) {
                    if (iClsView != null) {
                        LeftCls leftCls = new Gson().fromJson(result, LeftCls.class);
                        List<LeftCls.DataBean> list = leftCls.getData();
                        iClsView.onSuccessLeft(list);
                    }
                }
            });
        }
    }

    @Override
    public void getRight(Map<String, String> param) {
        if (iClsView != null){
            clsModel.getRight(param, new OKhttpUtilsCallBack() {
                @Override
                public void failure(String msg) {
                    if (iClsView != null) {
                        iClsView.onFailureRight(msg);
                    }
                }

                @Override
                public void success(String result) {
                    if (iClsView != null) {
                        RightCls rightCls = new Gson().fromJson(result, RightCls.class);
                        List<RightCls.DataBean> list = rightCls.getData();
                        iClsView.onSuccessRight(list);
                    }
                }
            });
        }
    }
}
