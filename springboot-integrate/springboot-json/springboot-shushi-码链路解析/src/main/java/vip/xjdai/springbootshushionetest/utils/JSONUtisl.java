package vip.xjdai.springbootshushionetest.utils;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import pro.shushi.pamirs.meta.util.JsonUtils;
import vip.xjdai.springbootshushionetest.model.QtsCodeChainTreeEipModel;
import vip.xjdai.springbootshushionetest.model.QtsCodeProductInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONUtisl {

    public static String path = "";

    public static List<QtsCodeChainTreeEipModel> getOneData() throws IOException {
        ArrayList<String> newArrayList = Lists.newArrayList();
        ClassLoader loader = FileUtil.class.getClassLoader();
        //   读取的文件名称
        InputStream stream = loader.getResourceAsStream(path + "/OneData.json");
        String text = IOUtils.toString(stream, StandardCharsets.UTF_8);
        return JSON.parseArray(text, QtsCodeChainTreeEipModel.class);
    }


    public static List<QtsCodeProductInfo> getProduct() {
        ArrayList<String> newArrayList = Lists.newArrayList();
        ClassLoader loader = FileUtil.class.getClassLoader();
        //   读取的文件名称
        InputStream stream = loader.getResourceAsStream(path + "/product.json");
        String text = null;
        try {
            text = IOUtils.toString(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonUtils.parseObjectList(text, QtsCodeProductInfo.class);
    }


}
