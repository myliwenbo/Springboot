package cn.zingfin.finance.controller;


import cn.zingfin.finance.manager.FileManageManager;
import cn.zingfin.finance.repository.vo.FileManageSaveRequest;
import cn.zingfin.finance.repository.vo.FileManageQueryRequest;
import cn.zingfin.finance.repository.vo.FileManageVo;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;
import cn.vihost.farmplatform.core.exception.BizException;
import cn.vihost.farmplatform.core.support.ResultMsg;
import cn.vihost.farmplatform.core.util.ResultUtil;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/bak/fileManage" )
public class FileManageController {

    @Resource
    private FileManageManager fileManageManager;


    @ApiOperation(value ="保存内容",response = FileManageVo.class)
    @RequestMapping(value = "/v1/save", method = {RequestMethod.POST})
    public ResultMsg save(@RequestBody FileManageSaveRequest fileManageSaveRequest)throws BizException{
        return ResultUtil.successResult(fileManageManager.save(fileManageSaveRequest));
    }


    @ApiOperation(value ="删除数据，根据ID")
    @RequestMapping(value = "/v1/remove", method = {RequestMethod.POST})
    public ResultMsg remove(@RequestBody FileManageQueryRequest fileManageQueryRequest) throws BizException {
        return ResultUtil.successResult(fileManageManager.remove( fileManageQueryRequest));
    }

    @ApiOperation(value ="修改数据，根据ID")
    @RequestMapping(value = "/v1/updataElementById", method = {RequestMethod.POST})
    public ResultMsg updataElementById(@RequestBody  FileManageQueryRequest fileManageQueryRequest) throws BizException {
        return ResultUtil.successResult(fileManageManager.updataElementById(fileManageQueryRequest));
    }

    //查单条-查询
    @ApiOperation(value ="批量查询，非分页",response = FileManageVo.class)
    @RequestMapping(value = "/v1/selectByElement", method = {RequestMethod.POST})
    public ResultMsg updataElement(@RequestBody FileManageQueryRequest fileManageQueryRequest) throws BizException {
        return ResultUtil.successResult(fileManageManager.queyrListByElement(fileManageQueryRequest));
    }

    //分页-条件分页
    @ApiOperation(value ="分页查询",response = FileManageVo.class)
    @RequestMapping(value = "/v1/pageList", method = {RequestMethod.POST})
    public ResultMsg pageList(@RequestBody FileManageQueryRequest fileManageQueryRequest) throws BizException {
        return ResultUtil.successResult(fileManageManager.pageList( fileManageQueryRequest));
    }

}