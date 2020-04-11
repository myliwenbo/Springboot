package cn.zingfin.finance.controller;

import cn.zingfin.finance.manager.WordbookManager;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;
import cn.vihost.farmplatform.core.exception.BizException;
import cn.vihost.farmplatform.core.support.ResultMsg;
import cn.vihost.farmplatform.core.util.ResultUtil;
import cn.zingfin.finance.vo.WordbookVo;

@RestController
@RequestMapping("/wordbook")
public class WordbookController
{

    @Resource
    public WordbookManager wordbookManager;

    /**
    *  保存内容
    * @param wordbookVo
    * @return
    * @throws BizException
    */
    @RequestMapping(value = "/save", method = { RequestMethod.POST })
    public ResultMsg save(@RequestBody WordbookVo wordbookVo) throws BizException
    {
        return ResultUtil.successResult(wordbookManager.save(wordbookVo));
    }

    /**
    * 根据ID 删除对象
    * @param wordbookVo
    * @return
    * @throws BizException
    */
    @RequestMapping(value = "/remove", method = { RequestMethod.POST })
    public ResultMsg remove(@RequestBody WordbookVo wordbookVo) throws BizException
    {
        return ResultUtil.successResult(wordbookManager.remove(wordbookVo));
    }

    /**
    * 根据ID 修改
    * @param Vo
    * @return
    * @throws BizException
    */
    @RequestMapping(value = "/modifyById", method = { RequestMethod.POST })
    public ResultMsg modifyById(@RequestBody WordbookVo wordbookVo) throws BizException
    {
        return ResultUtil.successResult(wordbookManager.modifyById(wordbookVo));
    }

    /**
    * 根据ID查询
    * @param Vo
    * @return
    * @throws BizException
    */
    @RequestMapping(value = "/findById", method = { RequestMethod.POST })
    public ResultMsg findById(@RequestBody WordbookVo wordbookVo) throws BizException
    {
        return ResultUtil.successResult(wordbookManager.findById(wordbookVo));
    }
}
