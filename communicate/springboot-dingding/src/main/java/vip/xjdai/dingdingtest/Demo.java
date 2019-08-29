/**
 * 
 */
package vip.xjdai.dingdingtest;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import vip.xjdai.bean.dingding.DingDingMessageText;
import vip.xjdai.common.util.HttpClientUtil;

/**
 * @author lwb
 * 参考文档: https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.karFPe&treeId=257&articleId=105735&docType=1#s4
 */
public class Demo {

    /**
     * 这里的URL是钉钉群的机器人生成的
     */
    private static String url = "https://oapi.dingtalk.com/robot/send?access_token=b399ad6c470c34a7b0e82e5c5c457d461c0fb979c8eb69f16f355fd67849e4a6";

    public static void main(String[] args)
    {

        DingDingMessageText dingDingMessageText = DingDingMessageText
            .getDingDingMessageText("我就是我,  @18600600814 是不一样的烟火", Lists.newArrayList("18600600814"));

        System.out.println(JSON.toJSONString(dingDingMessageText));

        HttpClientUtil.sendPostWithJson(url, dingDingMessageText);
    }

}
