package cn.zingfin.finance.service;


import cn.zingfin.finance.repository.vo.TestCategoryTdo;
import cn.zingfin.finance.repository.entity.TestCategory;
import cn.zingfin.finance.repository.dao.TestCategoryDao;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.vihost.farmplatform.core.exception.BizException;
import cn.vihost.farmplatform.core.exception.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.multipart.MultipartFile;
import vip.xjdai.common.ExcetListener;
import vip.xjdai.common.WebErrorCodeEnums;

@Service
@Slf4j
public class TestCategoryService {

    @Resource
    public TestCategoryDao testCategoryDao;


    /**
     *
     *
     * @param testCategoryTdo
     * @return
     * @throws BizException
     */
    public TestCategoryTdo save(TestCategoryTdo testCategoryTdo) throws BizException {
        boolean flag = testCategoryDao.save(testCategoryTdo);
        if (!flag) {
            log.error("testCategoryTdo保存失败,request:[{}]", testCategoryTdo);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.SAVE_ERROR);
        }
        return testCategoryTdo;
    }

    public Boolean remove(Long id) throws BizException {
        boolean flag = testCategoryDao.removeById(id);
        if (!flag) {
            log.error("Item删除失败,id = {}]", id);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.DELETE_ERROR);
        }
        return flag;
    }

    public TestCategoryTdo updataElementById(TestCategoryTdo testCategoryTdo) throws BizException {
        boolean flag = testCategoryDao.updateById(testCategoryTdo);
        if (!flag) {
            log.error("${testCategoryDao修改失败},request:[{}]", testCategoryTdo);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.UPDATE_ERROR);
        }
        return testCategoryTdo;
    }


    public List<TestCategoryTdo>  queyrListByElement(TestCategoryTdo testCategoryTdo) throws BizException {
        LambdaQueryWrapper<TestCategoryTdo>  testCategoryTdoWrapper = new QueryWrapper<TestCategoryTdo>().lambda();
        return testCategoryDao.list(testCategoryTdoWrapper);
    }


    public IPage<TestCategoryTdo> pageList(TestCategoryTdo testCategoryTdo,Page<TestCategoryTdo> page) throws BizException {
        LambdaQueryWrapper<TestCategoryTdo>  testCategoryTdoWrapper = new QueryWrapper<TestCategoryTdo>().lambda();
        return testCategoryDao.page(page, testCategoryTdoWrapper);
    }

    public void importExcel(MultipartFile file) throws IOException {
//     EasyExcel.read(file.getInputStream(), TestCategory.class, new ExcetListener<TestCategoryDao>(testCategoryDao)).sheet().doRead();
    }

}