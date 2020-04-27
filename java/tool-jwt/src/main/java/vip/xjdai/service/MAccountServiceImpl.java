package vip.xjdai.service;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import vip.xjdai.model.BaseConstants;
import vip.xjdai.model.BaseResult;
import vip.xjdai.model.LoginParam;
import vip.xjdai.model.LoginVo;
import vip.xjdai.utils.JsonWebTokenUtil;

import java.util.UUID;

@Service
public class MAccountServiceImpl implements MAccountService
{
    @Override
    public BaseResult< LoginVo > login(LoginParam loginParam)
    {
        LoginVo loginVo = handleLogin(loginParam);
        String  subject = loginVo.getUserId();
        String jwt = JsonWebTokenUtil.issueJWT(UUID.randomUUID().toString(), subject, "token-server",
                                               BaseConstants.TOKEN_PERIOD_TIME, "", null, SignatureAlgorithm.HS512);
        loginVo.setJwt(jwt);
        return BaseResult.NewBaseResult(loginVo);
    }

    /**
     * 验证用户密码等权限
     * @param loginParam
     * @return
     */
    private LoginVo handleLogin(LoginParam loginParam)
    {
        if (loginParam.getPassword().equals("123")) {
            LoginVo loginVo = new LoginVo();
            loginVo.setUserId(UUID.randomUUID().toString().replace("-", ""));
            return loginVo;
        }
        throw new RuntimeException("我顶你肺");

    }
}
