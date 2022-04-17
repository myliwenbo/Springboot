package cn.zingfin.finance.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import cn.zingfin.finance.bean.BizException;
import cn.zingfin.finance.bean.ResultMsg;
import cn.zingfin.finance.bean.ResultUtil;
import cn.zingfin.finance.manager.TestCategoryManager;
import cn.zingfin.finance.repository.vo.TestCategoryQueryRequest;
import cn.zingfin.finance.repository.vo.TestCategorySaveRequest;
import cn.zingfin.finance.repository.vo.TestCategoryVo;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
@RequestMapping("/api/bak/testCategory" )
public class TestCategoryController {

    @Resource
    private TestCategoryManager testCategoryManager;


    @ApiOperation(value ="保存内容分类表",response = TestCategoryVo.class)
    @RequestMapping(value = "/v1/save", method = {RequestMethod.POST})
    public ResultMsg save(@RequestBody TestCategorySaveRequest testCategorySaveRequest)throws BizException {
        return ResultUtil.successResult(testCategoryManager.save(testCategorySaveRequest));
    }


    @ApiOperation(value ="删除分类表数据，根据ID")
    @RequestMapping(value = "/v1/remove", method = {RequestMethod.POST})
    public ResultMsg remove(@RequestBody TestCategoryQueryRequest testCategoryQueryRequest) throws BizException {
        return ResultUtil.successResult(testCategoryManager.remove( testCategoryQueryRequest));
    }

    @ApiOperation(value ="修改分类表数据，根据ID")
    @RequestMapping(value = "/v1/updataElementById", method = {RequestMethod.POST})
    public ResultMsg updataElementById(@RequestBody  TestCategoryQueryRequest testCategoryQueryRequest) throws BizException {
        return ResultUtil.successResult(testCategoryManager.updataElementById(testCategoryQueryRequest));
    }

    //查单条-查询
    @ApiOperation(value ="批量查询分类表，非分页",response = TestCategoryVo.class)
    @RequestMapping(value = "/v1/selectByElement", method = {RequestMethod.POST})
    public ResultMsg updataElement(@RequestBody TestCategoryQueryRequest testCategoryQueryRequest) throws BizException {
        return ResultUtil.successResult(testCategoryManager.queyrListByElement(testCategoryQueryRequest));
    }

    //分页-条件分页
    @ApiOperation(value ="分页查询分类表",response = TestCategoryVo.class)
    @RequestMapping(value = "/v1/pageList", method = {RequestMethod.POST})
    public ResultMsg pageList(@RequestBody TestCategoryQueryRequest testCategoryQueryRequest) throws BizException {
        return ResultUtil.successResult(testCategoryManager.pageList( testCategoryQueryRequest));
    }

    @RequestMapping(value = "/v1/export", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "导出分类表数据", response = String.class)
    public void export(@RequestBody TestCategoryQueryRequest testCategoryQueryRequest,
        HttpServletResponse httpServletResponse) throws IOException, BizException {
        testCategoryManager.export(httpServletResponse, testCategoryQueryRequest);
    }
    @RequestMapping(value = "/v1/import", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "导出分类表数据", response = String.class)
    public void importExcel(@RequestParam("file") MultipartFile file,
        HttpServletResponse httpServletResponse) throws IOException, BizException {
        testCategoryManager.importExcel(file);
    }
}