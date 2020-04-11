package cn.zingfin.finance.manager;

import lombok.extern.slf4j.Slf4j;
import cn.vihost.farmplatform.core.exception.BizException;
import cn.vihost.farmplatform.core.util.BeanCopyUtil;
import cn.zingfin.finance.repository.entity.Wordbook;
import cn.zingfin.finance.vo.WordbookVo;

import javax.annotation.Resource;

import cn.zingfin.finance.service.WordbookService;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class WordbookManager
{

    @Resource
    public WordbookService wordbookService;

    public WordbookVo save(WordbookVo wordbookVo) throws BizException
    {

        Wordbook wordbook =BeanCopyUtil.copy(wordbookVo, Wordbook. class);
        return BeanCopyUtil.copy(wordbookService.save(wordbook), WordbookVo.class);

    }

    public Boolean remove(WordbookVo wordbookVo) throws BizException
    {

        Wordbook wordbook =BeanCopyUtil.copy(wordbookVo, Wordbook. class);
        return wordbookService.remove(wordbook.getId());

    }

    public WordbookVo modifyById(WordbookVo wordbookVo) throws BizException
    {


        Wordbook wordbook =BeanCopyUtil.copy(wordbookVo, Wordbook. class);
        return BeanCopyUtil.copy(wordbookService.modifyById( wordbook),  WordbookVo.class);

    }

    public WordbookVo findById(WordbookVo wordbookVo) throws BizException
    {



        Wordbook wordbook =BeanCopyUtil.copy(wordbookVo, Wordbook. class);
        return BeanCopyUtil.copy(wordbook.findById(wordbookVo.getId()),  WordbookVo.class);

    }
}