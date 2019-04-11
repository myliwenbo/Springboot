package cn.lwb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.lwb.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "header", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "thuempire"), })
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
                    @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(/*@RequestHeader("username") String username, @RequestParam("password") String password*/) {
        User us = new User();
        us.setUserName("thuempire");
        us.setPassword("123456");
        us.setAge(18);
        return us;
    }

}