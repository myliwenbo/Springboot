package vip.xjdai.validation.difference.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.validation.difference.pojo.BasePOJO;
import vip.xjdai.validation.difference.pojo.UserPOJO;

@RestController
@RequestMapping("differenceValidatedController")
public class ValidatedController {

    /**
     * 添加的时候ID 和名称毕穿
     *
     * @param userPOJO
     * @return
     */
    @RequestMapping("add")
    public UserPOJO add(@RequestBody @Validated({BasePOJO.Add.class}) UserPOJO userPOJO) {

        return userPOJO;
    }

    /**
     * 修改的时候，只需要传递ID 即可
     *
     * @param userPOJO
     * @return
     */
    @RequestMapping("update")
    public UserPOJO update(@RequestBody @Validated({BasePOJO.Update.class}) UserPOJO userPOJO) {
        return userPOJO;
    }

    /**
     * 不使用分组，所有数据都进行校验
     *
     * @param userPOJO
     * @return
     */
    @RequestMapping("delete")
    public UserPOJO delete(@RequestBody @Validated UserPOJO userPOJO) {
        return userPOJO;
    }
}
