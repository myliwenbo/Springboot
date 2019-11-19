/**
 * 
 */
package vip.xjdai.bean.weixin;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;
import vip.xjdai.common.exceotion.BizException;
import vip.xjdai.common.util.HttpClientUtil;
import vip.xjdai.common.util.JSONUtil;

/**
 * @author lwb
 *
 */
@Slf4j
public class WeixinUtils {
    public final static String ENTERPRISE_ACCESS_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    public final static String PUBLIC_ACCESS_URL     = "https://api.weixin.qq.com/cgi-bin/token";
    private final String       appid;
    private final String       appsecret;
    private long               weixinTokenEndTime;

    private AccessToken        accessToken;
    private static WeixinUtils weixinUtils;

    private static WeixinUtils getWeixinUtils(final String appid, final String appsecret)
    {
        if (weixinUtils == null) {
            weixinUtils = new WeixinUtils(appid, appsecret);
        }
        return weixinUtils;
    }

    public static String getAccessToken(final String appid, final String appsecret)
    {
        WeixinUtils weixinUtils = WeixinUtils.getWeixinUtils(appid, appsecret);
        if (weixinUtils.weixinTokenEndTime == System.currentTimeMillis()) {
            final long now = System.currentTimeMillis();
            weixinUtils.initToken(now);
        }
        return weixinUtils.accessToken.getAccess_token();
    }

    public WeixinUtils(final String appid, final String appsecret) {
        this.appid = appid;
        this.appsecret = appsecret;
        final long now = System.currentTimeMillis();
        this.initToken(now);
    }

    private void initToken(final long refreshTime)
    {
        this.weixinTokenEndTime = System.currentTimeMillis();
        Map<String, String> map = Maps.newHashMap();
        map.put("grant_type", "client_credential");
        map.put("appid", this.appid);
        map.put("secret", this.appsecret);
        //请求后微信后台会返回一个json格式字符串,
        String result = HttpClientUtil.sendGet(PUBLIC_ACCESS_URL, map);
        AccessToken accessToken = JSONUtil.toBean(result, AccessToken.class);
        if (StringUtils.equals("OK", accessToken.getErrcode()) || StringUtils.equals("0", accessToken.getErrcode())
            || StringUtils.isBlank(accessToken.getErrcode())) {
            this.accessToken = accessToken;
            this.weixinTokenEndTime += accessToken.getExpires_in();
        } else {
            log.error("获取accessToken错误,错误代码:" + accessToken.getErrcode() + "错误信息为:" + accessToken.getErrmsg());
            throw new BizException("",
                "获取accessToken错误,错误代码:" + accessToken.getErrcode() + "错误信息为:" + accessToken.getErrmsg());
        }
    }

}
