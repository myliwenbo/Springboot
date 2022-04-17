package vip.xjdai.xmltobean.demo1;

import com.alibaba.fastjson.JSON;

public class Demo {

    //</document>
    public static void main(String[] args) {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<req>\n" +
                "    <header>header</header>\n" +
                "    <reqTwo>\n" +
                "        <j>j</j>\n" +
                "        <k>k</k>\n" +
                "    </reqTwo>\n" +
                "</req>";
        HelloRes<ReqTwo> res = new HelloRes<>();
        HelloRes<ReqTwo> helloRes = JaxbUtil.converyToJavaBean(xml, res.getClass());
        System.out.println(JSON.toJSONString(helloRes));
    }

}
