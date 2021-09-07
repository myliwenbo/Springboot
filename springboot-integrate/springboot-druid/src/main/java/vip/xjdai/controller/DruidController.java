package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.mapper.TUser;
import vip.xjdai.mapper.TUserMapper;

import java.util.List;
import java.util.UUID;

@EnableTransactionManagement
@RestController
@RequestMapping("druidTest")
public class DruidController
{

//    @Autowired
//    private TUserMapper tUserMapper;
//
//    @RequestMapping("test")
//    public List< TUser > test()
//    {
//        return tUserMapper.selectAllUser();
//
//    }
}
