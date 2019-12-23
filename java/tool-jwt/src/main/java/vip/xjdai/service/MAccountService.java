package vip.xjdai.service;

import vip.xjdai.model.BaseResult;
import vip.xjdai.model.LoginParam;
import vip.xjdai.model.LoginVo;

public interface MAccountService
{
    BaseResult< LoginVo> login(LoginParam loginParam);
}
