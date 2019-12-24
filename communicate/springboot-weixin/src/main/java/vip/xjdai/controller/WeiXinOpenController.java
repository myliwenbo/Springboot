package vip.xjdai.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.xjdai.bean.ReceiveXmlEntity;
import vip.xjdai.bean.WeixinMessageType;
import vip.xjdai.common.exceotion.BizException;
import vip.xjdai.common.weixin.WeixinUtils;
import vip.xjdai.sned.FormatXmlProcess;

/**
 *
 * @author leo
 *
 */
@RestController
@RequestMapping("/openwx")
public class WeiXinOpenController
{

    @RequestMapping(value = { "/mingwen" })
    public void mingwen(@RequestBody(required = false) String reqDate, HttpServletRequest request,
                        HttpServletResponse response) throws Exception
    {
        String result = "";
        /** 判断是否是微信接入激活验证，只有首次接入Token验证时才会收到echostr参数，此时需要把它直接返回 */
        String echostr = request.getParameter("echostr");
        if (StringUtils.isNotBlank(echostr)) {
            result = echostr;
        } else {
            //TODO 处理微信消息
            ReceiveXmlEntity buildResponseMessage = buildResponseMessage(reqDate);
            result = new FormatXmlProcess().formatXmlAnswer(buildResponseMessage.getFromUserName(),
                                                            buildResponseMessage.getToUserName(),
                                                            buildResponseMessage.getResultMessage());
        }
        try {
            OutputStream os = response.getOutputStream();
            os.write(result.getBytes(StandardCharsets.UTF_8));
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = { "/getAccessToken" })
    public String getAccessToken() throws Exception
    {
        String appsecret = "595ea9f7cf1075cd57e051c47804be7c";
        String appid     = "wx7e35cee0956f9fed";
        return WeixinUtils.getAccessToken(appid, appsecret);
    }

    public ReceiveXmlEntity buildResponseMessage(String reqDate)
    {
        ReceiveXmlEntity xmlToBean = xmlToBean(reqDate);
        //得到消息类型
        String            msgType     = xmlToBean.getMsgType();
        WeixinMessageType messageType = WeixinMessageType.valueOf(WeixinMessageType.class, msgType.toUpperCase());
        switch (messageType) {
            //这里可以接入只能回复，也可以直接入指令，比如用户输入1 返回视频等~
            case TEXT:
                //处理文本消息
                xmlToBean.setResultMessage("对不起，你说的话真是太高深了……");
                break;
            case IMAGE:
                //处理图片消息
                break;
            case VOICE:
                //处理语音消息
                break;
            case VIDEO:
                //处理视频消息
                break;
            case SHORTVIDEO:
                //处理小视频消息
                break;
            case LOCATION:
                //处理位置消息
                break;
            case LINK:
                //处理链接消息
                break;
            case EVENT:
                //处理事件消息,用户在关注与取消关注公众号时，微信会向我们的公众号服务器发送事件消息,开发者接收到事件消息后就可以给用户下发欢迎消息
                xmlToBean.setResultMessage("欢迎关注本公众号，本公众号给你带来不一样的体验哟");
            default:
                break;
        }
        return xmlToBean;
    }

    /**
     * @param reqDate
     */
    private ReceiveXmlEntity xmlToBean(String reqDate)
    {
        try {
            SAXReader                           reader           = new SAXReader();
            InputStream                         in_nocode        = new ByteArrayInputStream(reqDate.getBytes());
            Document                            document         = reader.read(in_nocode);
            Element                             root             = document.getRootElement();
            ReceiveXmlEntity                    receiveXmlEntity = new ReceiveXmlEntity();
            Class< ? extends ReceiveXmlEntity > clazz            = receiveXmlEntity.getClass();
            // 得到根元素的所有子节点
            @SuppressWarnings("unchecked") List< Element > elementList = root.elements();
            for (Element element : elementList) {
                Field field = clazz.getDeclaredField(element.getName());
                field.setAccessible(true);
                field.set(receiveXmlEntity, element.getData());
            }
            return receiveXmlEntity;
        } catch (Exception e) {
            throw new BizException("", "消息错误");
        }
    }

}