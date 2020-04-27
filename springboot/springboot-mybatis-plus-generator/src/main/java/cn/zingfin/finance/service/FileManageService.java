package cn.zingfin.finance.service;


import cn.zingfin.finance.repository.vo.FileManageTdo;
import cn.zingfin.finance.repository.dao.FileManageDao;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.vihost.farmplatform.core.exception.BizException;
import cn.vihost.farmplatform.core.exception.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import vip.xjdai.common.WebErrorCodeEnums;

@Service
@Slf4j
public class FileManageService {

    @Resource
    public FileManageDao fileManageDao;


    /**
     *
     *
     * @param fileManageTdo
     * @return
     * @throws BizException
     */
    public FileManageTdo save(FileManageTdo fileManageTdo) throws BizException {
        boolean flag = fileManageDao.save(fileManageTdo);
        if (!flag) {
            log.error("fileManageTdo保存失败,request:[{}]", fileManageTdo);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.SAVE_ERROR);
        }
        return fileManageTdo;
    }

    public Boolean remove(Long id) throws BizException {
        boolean flag = fileManageDao.removeById(id);
        if (!flag) {
            log.error("Item删除失败,id = {}]", id);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.DELETE_ERROR);
        }
        return flag;
    }

    public FileManageTdo updataElementById(FileManageTdo fileManageTdo) throws BizException {
        boolean flag = fileManageDao.updateById(fileManageTdo);
        if (!flag) {
            log.error("${fileManageDao修改失败},request:[{}]", fileManageTdo);
            throw ExceptionUtil.buildFailException(WebErrorCodeEnums.UPDATE_ERROR);
        }
        return fileManageTdo;
    }


    public List<FileManageTdo>  queyrListByElement(FileManageTdo fileManageTdo) throws BizException {
        LambdaQueryWrapper<FileManageTdo>  fileManageTdoWrapper = new QueryWrapper<FileManageTdo>().lambda();
        return fileManageDao.list(fileManageTdoWrapper);
    }


    public IPage<FileManageTdo> pageList(FileManageTdo fileManageTdo,Page<FileManageTdo> page) throws BizException {
        LambdaQueryWrapper<FileManageTdo>  fileManageTdoWrapper = new QueryWrapper<FileManageTdo>().lambda();
        return fileManageDao.page(page, fileManageTdoWrapper);
    }

}