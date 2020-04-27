package cn.lwb.json.jackson;

import org.junit.Test;

/**
 * 
 * @author lwb
 *
 */
public class JackSon {

    @Test
    public void testname() throws Exception {
        UserSuper userSuper = new UserSuper();
        userSuper.setAge("18");
        userSuper.setName("小明");
        userSuper.setSssssssss("父类");
        userSuper.setSecretKey("123132");
        userSuper.setPassword("123456");
        userSuper.setMd5Password("123456");
        String objectToJson = JsonUtils.objectToJson(userSuper);
        System.out.println(objectToJson);

    }

    @Test
    public void testname1() throws Exception {
        String json = "{\"name\":\"小明\",\"age\":\"18\",\"password\":null,\"md5Password\":\"123456\",\"xxx\":\"xxxx\"}\r\n"
                      + "";
        UserSuper jsonToPojo = JsonUtils.jsonToPojo(json, UserSuper.class);
        System.out.println(JsonUtils.objectToJson(jsonToPojo));
    }
}
