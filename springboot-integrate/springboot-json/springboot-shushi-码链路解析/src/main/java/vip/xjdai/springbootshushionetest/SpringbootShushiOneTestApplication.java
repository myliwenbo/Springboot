package vip.xjdai.springbootshushionetest;

import vip.xjdai.springbootshushionetest.model.QtsCodeChainTreeEipModel;
import vip.xjdai.springbootshushionetest.service.QtsCodeChainTreePullOperate;
import vip.xjdai.springbootshushionetest.utils.JSONUtisl;

import java.io.IOException;
import java.util.List;

public class SpringbootShushiOneTestApplication {

    public static void main(String[] args) throws IOException {
        JSONUtisl.path = "data1";
        List<QtsCodeChainTreeEipModel> oneData = JSONUtisl.getOneData();
        QtsCodeChainTreePullOperate qtsCodeChainTreePullOperate = new QtsCodeChainTreePullOperate();
        qtsCodeChainTreePullOperate.dealChainTreeEipModelNew(oneData);
    }



}
