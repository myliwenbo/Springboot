package cn.zingfin.finance.manager;

import cn.zingfin.finance.bean.BeanCopyUtil;
import cn.zingfin.finance.bean.BizException;
import cn.zingfin.finance.service.TestCategoryService;
import cn.zingfin.finance.repository.vo.TestCategoryVo;
import cn.zingfin.finance.repository.entity.TestCategory;
import cn.zingfin.finance.repository.vo.TestCategorySaveRequest;
import cn.zingfin.finance.repository.vo.TestCategoryQueryRequest;
import cn.zingfin.finance.repository.vo.TestCategoryTdo;
import vip.xjdai.common.PageInfo;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@Slf4j
public class TestCategoryManager {

    @Resource
    public TestCategoryService testCategoryService;

    public TestCategoryVo save(TestCategorySaveRequest testCategorySaveRequest) throws BizException {
        TestCategoryTdo testCategoryTdo = BeanCopyUtil.copy(testCategorySaveRequest, TestCategoryTdo.class);
        return BeanCopyUtil.copy(testCategoryService.save(testCategoryTdo), TestCategoryVo.class);
    }

    public TestCategoryVo remove(TestCategoryQueryRequest testCategoryQueryRequest) throws BizException {
        TestCategoryTdo testCategoryTdo = BeanCopyUtil.copy(testCategoryQueryRequest, TestCategoryTdo.class);
        return BeanCopyUtil.copy(testCategoryService.remove(testCategoryTdo.getId()), TestCategoryVo.class);
    }

    public TestCategoryVo updataElementById(TestCategoryQueryRequest testCategoryQueryRequest) throws BizException {
        TestCategoryTdo testCategoryTdo = BeanCopyUtil.copy(testCategoryQueryRequest, TestCategoryTdo.class);
        return BeanCopyUtil.copy(testCategoryService.updataElementById(testCategoryTdo), TestCategoryVo.class);
    }


    public TestCategoryVo queyrListByElement(TestCategoryQueryRequest testCategoryQueryRequest) throws BizException {
        TestCategoryTdo testCategoryTdo = BeanCopyUtil.copy(testCategoryQueryRequest, TestCategoryTdo.class);
        return BeanCopyUtil.copy(testCategoryService.queyrListByElement(testCategoryTdo), TestCategoryVo.class);
    }

    public PageInfo<TestCategoryVo> pageList(TestCategoryQueryRequest testCategoryQueryRequest) throws BizException {
        TestCategoryTdo testCategoryTdo = BeanCopyUtil.copy(testCategoryQueryRequest, TestCategoryTdo.class);
        IPage<TestCategoryTdo> testCategoryVoIPage = testCategoryService.pageList(testCategoryTdo, testCategoryQueryRequest.getPage());
        return new PageInfo<>(testCategoryVoIPage);
    }

    public void export(HttpServletResponse httpServletResponse, TestCategoryQueryRequest testCategoryQueryRequest) throws IOException, BizException {
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setHeader("Content-disposition", "attachment;filename=分类表.xlsx");
        EasyExcel.write(httpServletResponse.getOutputStream(), TestCategory.class)
                .sheet("分类表")
                .doWrite(pageList(testCategoryQueryRequest).getRecords());
    }

    /**
     * 导入数据
     *
     * @param file
     * @throws IOException
     */
    public void importExcel(MultipartFile file) throws IOException {
        testCategoryService.importExcel(file);
    }
}