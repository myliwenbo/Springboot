package vip.xjdai.springbootrecursion.data;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.io.IOUtils;
import vip.xjdai.springbootrecursion.data.model.QtsCodeChainEipModel;
import vip.xjdai.springbootrecursion.data.model.QtsCodeChainTreeEipModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Data
public class DemoTest {
    private String name;

    public static void main(String[] args) throws IOException {
//        ClassLoader loader = FileUtil.class.getClassLoader();
//        //   读取的文件名称
//        InputStream stream = loader.getResourceAsStream("OneData.json");
//        String text = IOUtils.toString(stream, "utf8");
//        List<QtsCodeChainTreeEipModel> qtsCodeChainTreeEipModels = JSON.parseArray(text, QtsCodeChainTreeEipModel.class);
//        for (QtsCodeChainTreeEipModel qtsCodeChainTreeEipModel : qtsCodeChainTreeEipModels) {
//            QtsCodeChainEipModel relationTree = qtsCodeChainTreeEipModel.getRelationTree();
//        }l
        DemoTest DemoTest = new DemoTest();
        System.out.println(DemoTest.getName() + "123123");
        System.out.println(100 < 1);
        System.out.println(DateUtil.beginOfDay(DateUtil.offsetDay(new Date(), 0)));
    }

}
