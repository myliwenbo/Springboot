package vip.xjdai.springbootidea;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootIdeaApplication {

    private static String heihei = null;

    public static void main(String[] args) {
        //language=JSON
        heihei = "{\n" +
                "  \"employee\": {\n" +
                "    \"name\": \"Bill Gates\",\n" +
                "    \"age\": 63,\n" +
                "    \"city\": \"Seattle\"\n" +
                "  }\n" +
                "}";
        System.out.println(heihei);
    }

}
