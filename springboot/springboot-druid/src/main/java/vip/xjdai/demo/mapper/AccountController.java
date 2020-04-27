package vip.xjdai.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController
{

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("test")
    public List<Account> test()
    {
        return accountMapper.selectAllUser();

    }
}
