package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.model.BaseResult;
import vip.xjdai.model.LoginParam;
import vip.xjdai.model.LoginVo;
import vip.xjdai.service.MAccountService;

@RestController
@RequestMapping("/jwt")
public class JWTController
{

    @Autowired
    private MAccountService mAccountService;

    @RequestMapping("/login")
    public BaseResult< LoginVo > accountLogin(@RequestBody LoginParam loginParam)
    {
        return mAccountService.login(loginParam);
    }

    @RequestMapping("/test")
    public BaseResult< LoginVo > getUser(@RequestBody LoginParam loginParam)
    {
        return mAccountService.login(loginParam);
    }
}
