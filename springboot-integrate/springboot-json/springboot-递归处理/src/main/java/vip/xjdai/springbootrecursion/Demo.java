package vip.xjdai.springbootrecursion;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.IOUtils;
import org.springframework.util.CollectionUtils;
import vip.xjdai.springbootrecursion.data.model.QtsCodeChainEipModel;
import vip.xjdai.springbootrecursion.data.model.QtsCodeChainTreeEipModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Demo {


    public static void main(String[] args) throws IOException {
        ArrayList<String> newArrayList = Lists.newArrayList();
        ClassLoader loader = FileUtil.class.getClassLoader();
        //   读取的文件名称
        InputStream stream = loader.getResourceAsStream("OneData.json");
        String text = IOUtils.toString(stream, "utf8");
        List<QtsCodeChainTreeEipModel> qtsCodeChainTreeEipModels = JSON.parseArray(text, QtsCodeChainTreeEipModel.class);
        for (QtsCodeChainTreeEipModel qtsCodeChainTreeEipModel : qtsCodeChainTreeEipModels) {
            QtsCodeChainEipModel relationTree = qtsCodeChainTreeEipModel.getRelationTree();
//            recursion(relationTree, newArrayList);
            forw(relationTree, newArrayList);
        }
        HashSet<String> strings = Sets.newHashSet(newArrayList);
        System.out.println(JSON.toJSONString(strings));
    }

    private static void forw(QtsCodeChainEipModel qtsCodeChainEipModel, ArrayList<String> idLsts) {
        List<QtsCodeChainEipModel> childrens = qtsCodeChainEipModel.getChildrens();
        if (CollectionUtils.isEmpty(childrens)) {
            return;
        }
        for (QtsCodeChainEipModel children : childrens) {
            idLsts.add(children.getCurrentId().toString());
            if (CollectionUtils.isEmpty(childrens)) {
                continue;
            }
            for (QtsCodeChainEipModel childrenChildren : children.getChildrens()) {
                idLsts.add(childrenChildren.getCurrentId().toString());
                if (CollectionUtils.isEmpty(childrenChildren.getChildrens())) {
                    continue;
                }
            }
        }
    }


    private static void recursion(QtsCodeChainEipModel qtsCodeChainEipModel, ArrayList<String> idLsts) {
        List<QtsCodeChainEipModel> childrens = qtsCodeChainEipModel.getChildrens();
        if (CollectionUtils.isEmpty(childrens)) {
            return;
        }
        for (QtsCodeChainEipModel children : childrens) {
            idLsts.add(children.getCurrentId().toString());
            recursion(children, idLsts);
        }
    }
}
