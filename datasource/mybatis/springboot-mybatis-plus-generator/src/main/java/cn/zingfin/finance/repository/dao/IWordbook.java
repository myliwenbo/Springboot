package cn.zingfin.finance.service;

import cn.vihost.farmplatform.core.exception.BizException;
import cn.vihost.farmplatform.core.exception.ExceptionUtil;
import cn.zingfin.finance.repository.dao.IWordbookDao;
import cn.zingfin.finance.repository.entity.Wordbook;
import cn.zingfin.finance.constants.WebErrorCodeEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zingfin.finance.constants.WebErrorCodeEnums;

import javax.annotation.Resource;

@Service
@Slf4j
public class WordbookService
{

    @Resource
    public IWordbookDao wordbookDao;


    /**
  * 保存分类
  *
  * @param wordbook
  * @return
  * @throws BizException
  */
    public Wordbook save(Wordbook wordbook) throws BizException {
        boolean flag = wordbookDao.save(wordbook);
        if (!flag) {
            log.error("category保存失败,request:[{}]", wordbook);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.SAVE_ERROR);
        }
        return wordbook;
    }


    /**
     * 删除分类
     *
     * @param id
     * @return
     * @throws BizException
     */
    public Boolean remove(Long id) throws BizException {
        boolean flag = wordbookDao.removeById(id);
        if (!flag) {
            log.error("category删除失败,id = {}]", id);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.DELETE_ERROR);
        }
        return flag;
    }

    /**
     * 根据ID修改分类
     *
     * @param wordbook
     * @return
     * @throws BizException
     */
    public Wordbook modifyById(Wordbook wordbook) throws BizException {
        boolean flag = wordbookDao.updateById(wordbook);
        if (!flag) {
            log.error("category修改失败,request:[{}]", wordbook);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.UPDATE_ERROR);
        }
        return wordbook;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     * @throws BizException
     */
    public Wordbook findById(Long id) throws BizException {
        Wordbook wordbook = wordbookDao.getById(id);
        if (wordbook == null) {
            log.error("category查询失败,id = [{}]", id);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.SELECT_ERROR);
        }
        return wordbook;
    }
}