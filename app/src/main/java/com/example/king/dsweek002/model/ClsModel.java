package com.example.king.dsweek002.model;

import com.example.king.dsweek002.apis.Apis;
import com.example.king.dsweek002.contact.ClsContact;
import com.example.king.dsweek002.net.OKhttpUtils;
import com.example.king.dsweek002.net.OKhttpUtilsCallBack;

import java.util.Map;

public class ClsModel implements ClsContact.IClsModel {
    @Override
    public void getLeft(Map<String, String> param, OKhttpUtilsCallBack oKhttpUtilsCallBack) {
        OKhttpUtils.getInstance().toPost(param,Apis.API_LEFT,oKhttpUtilsCallBack);
    }

    @Override
    public void getRight(Map<String, String> param,  OKhttpUtilsCallBack oKhttpUtilsCallBack) {
        OKhttpUtils.getInstance().toPost(param,Apis.API_RIGHT,oKhttpUtilsCallBack);
    }
}
