package cn.lwb.json.gson;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class GsonDemo {

    @Test
    public void testName() throws Exception {
        UserSuper userSuper = new UserSuper();
        userSuper.setAge("18");
        userSuper.setName("小明");
        userSuper.setSssssssss("父类");
        userSuper.setSecretKey("123132");
        userSuper.setPassword("123456");
        userSuper.setMd5Password("123456");
        String pojo2Json = GsonUtils.pojo2Json(userSuper);
        System.out.println(pojo2Json);
        String json = "{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"}\r\n"
                      + "";
        UserSuper pojo2Json2 = GsonUtils.pojo2Json(json, UserSuper.class);
        System.out.println(pojo2Json2.toString());
    }

    /**
     * 泛型转换
     * @throws Exception
     */
    @Test
    public void genericityTransition() throws Exception {

        String text = "{\"success\":true,\"data\":[{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"},{\"name\":\"小明\",\"age\":\"18\",\"sssssssss\":\"父类\",\"password\":\"123456\",\"md5Password\":\"123456\",\"secretKey\":\"123132\"}]}";
        /**
         * 泛型转换
         */
        CommonJson4List<UserSuper> fromJson = GsonUtils.fromJson(text, UserSuper.class);
        System.out.println(GsonUtils.pojo2Json(fromJson));
    }

    @Test
    public void jsonToList() throws Exception {
        UserSuper userSuper = new UserSuper();
        userSuper.setAge("18");
        userSuper.setName("小明");
        userSuper.setSssssssss("父类");
        userSuper.setSecretKey("123132");
        userSuper.setPassword("123456");
        userSuper.setMd5Password("123456");
        List<UserSuper> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(userSuper);
        }
        String text = GsonUtils.pojo2Json(list);
        GsonUtils.json2List(text, UserSuper.class);
    }
}
