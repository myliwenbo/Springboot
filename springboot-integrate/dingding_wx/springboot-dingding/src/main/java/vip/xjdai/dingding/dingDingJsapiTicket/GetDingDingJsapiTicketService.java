package vip.xjdai.dingding.dingDingJsapiTicket;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGetJsapiTicketRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGetJsapiTicketResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import vip.xjdai.dingding.dingDingJsapiTicket.model.DingdingJSAPIVO;
import vip.xjdai.dingding.dingDingJsapiTicket.utils.DdConfigSign;

public class GetDingDingJsapiTicketService {
    private static String getTokenUrl = "https://oapi.dingtalk.com/gettoken";


    @Autowired
    private DingTask dingTask;

    /**
     * 获取token
     */
    @SneakyThrows
    public String token() {
        DefaultDingTalkClient client = new DefaultDingTalkClient(getTokenUrl);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("dingivrnad5wguyl6txh");
        request.setAppsecret("uFQkGvfX1q4lL0T07s6zG31kbGP8OV0bg5PP9rOAdItj_G9ZmnLqzk-2T1Xy4kZm");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        return response.getAccessToken();
    }

    public DingdingJSAPIVO getDingDingJsapiTicket(DingdingJSAPIVO param) throws Exception {
        String jsapiTicket = dingTask.getJsapiTicket();
        DdConfigSign.sign(jsapiTicket, param);
        return param;
    }


    public String getJsapiTicket() {
        String accessToken = token();
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/get_jsapi_ticket");
        OapiGetJsapiTicketRequest req = new OapiGetJsapiTicketRequest();
        req.setHttpMethod("GET");
        OapiGetJsapiTicketResponse response = null;
        try {
            response = client.execute(req, accessToken);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new BizException("获取JsapiTicket错误" + e.getMessage());
        }
        return response.getTicket();

    }
