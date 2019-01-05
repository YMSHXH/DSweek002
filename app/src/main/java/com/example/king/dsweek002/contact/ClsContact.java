package com.example.king.dsweek002.contact;

import com.example.king.dsweek002.beans.LeftCls;
import com.example.king.dsweek002.beans.RightCls;
import com.example.king.dsweek002.net.OKhttpUtilsCallBack;

import java.util.List;
import java.util.Map;

public interface ClsContact {

    abstract class IClsPresenter{
       public abstract void getLeft(Map<String,String> param);
       public abstract void getRight(Map<String,String> param);
    }

    interface IClsModel{
        void getLeft(Map<String,String> param, OKhttpUtilsCallBack oKhttpUtilsCallBack);
        void getRight(Map<String,String> param,  OKhttpUtilsCallBack oKhttpUtilsCallBack);
    }

    interface IClsView{
        void onFailureLeft(String msg);
        void onSuccessLeft(List<LeftCls.DataBean> list);
        void onFailureRight(String msg);
        void onSuccessRight(List<RightCls.DataBean> list);
    }
}
