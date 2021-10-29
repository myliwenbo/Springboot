package cn.lwb.xml.jaxb;

import com.alibaba.fastjson.JSON;

public class Demo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        String text = "<document>\r\n" + "    <response>\r\n" + "\r\n"
                      + "        <head>\r\n" + "            <version>3.7.0</version>\r\n"
                      + "            <appid>2016012900930739</appid>\r\n"
                      + "            <function>alipay.medical.card.query</function>\r\n"
                      + "            <respTime>20180330122158</respTime>\r\n"
                      + "            <respTimeZone>UTC+8</respTimeZone>\r\n"
                      + "            <reqMsgId>78bc03b3-8c81-4ae7-a1c5-a02cfd0803a2</reqMsgId>\r\n"
                      + "        </head>\r\n" + "\r\n" + "        <body>\r\n"
                      + "            <resultInfo>\r\n"
                      + "                <resultStatus>S</resultStatus>\r\n"
                      + "                <resultCode>SUCCESS</resultCode>\r\n"
                      + "                <resultMsg>业务成功</resultMsg>\r\n"
                      + "            </resultInfo>\r\n"
                      + "            <medical_card_id>6049735182</medical_card_id>\r\n"
                      + "            <medical_card_no>B6C989166</medical_card_no>\r\n"
                      + "            <medical_card_validate_date>2038-03-30</medical_card_validate_date>\r\n"
                      + "            <medical_card_status>active</medical_card_status>\r\n"
                      + "            <medical_card_type>finance</medical_card_type>\r\n"
                      + "            <bank_card_no>6214677200012756150</bank_card_no>\r\n"
                      + "            <out_real_name>林海毅</out_real_name>\r\n"
                      + "            <out_user_card_type>01</out_user_card_type>\r\n"
                      + "            <out_user_card_no>450502198805230162</out_user_card_no>\r\n"
                      + "            <social_card_no>450502198805230162</social_card_no>\r\n"
                      + "            <extend_params>{\\\"card_query\\\":{\\\"dnh\\\":\\\"640750316\\\"}}</extend_params>\r\n"
                      + "        </body>\r\n" + "    </response>\r\n"
                      + "    <signature>LuhjShqmZjFUHQ7SVxqELZnyUHB4EU/nWO4Or8RUJBbmSfsS+ChONxpGNCXYjGvd5Jfn8+t3ugqqKYPCGsRy3UDec63a2PllSKJCA1sOYSGfKDz0W38mSIgL/jWNXd4ryiijzQi4BQbTlHIoms6X5AhXeL30QW6dLpdvZlPHYWrjtS97n/991FJZDcb7df/UYYjZaicL+LhjUpG1WkN93PJc3RLzsHXF2u3OMAirTR7bhYx2L9bnY2VxnWiMPBcxBVB26r03bD5I5iqL8iLqmVcFqOQHt7iozUGywe71eBEV8dlgzDCswv3unCiywU8Ndvw/VOKdZXQ6OERbpGDCqA==</signature>\r\n"
                      + "</document>";
        ResponseDocumentBO<ResponseBoby> b = new ResponseDocumentBO<>();

        ResponseDocumentBO<ResponseBoby> converyToJavaBean = JaxbUtil
            .converyToJavaBean(text, b.getClass());
        String jsonString = JSON.toJSONString(converyToJavaBean);
        System.out.println(jsonString);

    }

}
