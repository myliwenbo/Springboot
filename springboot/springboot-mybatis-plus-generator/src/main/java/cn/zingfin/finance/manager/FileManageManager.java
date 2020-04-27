package cn.zingfin.finance.manager;

import cn.zingfin.finance.service.FileManageService;
import cn.zingfin.finance.repository.vo.FileManageVo;
import cn.zingfin.finance.repository.vo.FileManageSaveRequest;
import cn.zingfin.finance.repository.vo.FileManageQueryRequest;
import cn.zingfin.finance.repository.vo.FileManageTdo;

import lombok.extern.slf4j.Slf4j;
import cn.vihost.farmplatform.core.exception.BizException;
import cn.vihost.farmplatform.core.util.BeanCopyUtil;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FileManageManager {

    @Resource
    public FileManageService fileManageService;

    public FileManageVo save(FileManageSaveRequest fileManageSaveRequest) throws BizException {
    FileManageTdo fileManageTdo =BeanCopyUtil.copy(fileManageSaveRequest,FileManageTdo.class);
        return BeanCopyUtil.copy(fileManageService.save(fileManageTdo), FileManageVo.class);
    }

    public FileManageVo remove(FileManageQueryRequest fileManageQueryRequest) throws BizException {
    FileManageTdo fileManageTdo =BeanCopyUtil.copy(fileManageQueryRequest,FileManageTdo.class);
        return BeanCopyUtil.copy(fileManageService.remove(fileManageTdo.getId()), FileManageVo.class);
    }

    public FileManageVo updataElementById(FileManageQueryRequest fileManageQueryRequest) throws BizException {
    FileManageTdo fileManageTdo =BeanCopyUtil.copy(fileManageQueryRequest,FileManageTdo.class);
        return BeanCopyUtil.copy(fileManageService.updataElementById(fileManageTdo), FileManageVo.class);
    }

    public FileManageVo queyrListByElement(FileManageQueryRequest fileManageQueryRequest) throws BizException {
    FileManageTdo fileManageTdo =BeanCopyUtil.copy(fileManageQueryRequest,FileManageTdo.class);
        return BeanCopyUtil.copy(fileManageService.queyrListByElement(fileManageTdo), FileManageVo.class);
    }
    public FileManageVo pageList(FileManageQueryRequest fileManageQueryRequest) throws BizException {
    FileManageTdo fileManageTdo =BeanCopyUtil.copy(fileManageQueryRequest,FileManageTdo.class);

        return BeanCopyUtil.copy(fileManageService.pageList(fileManageTdo,fileManageQueryRequest.getPage()), FileManageVo.class);
    }
}