package vip.xjdai.springbootrecursion.service;

import vip.xjdai.springbootrecursion.model.CodeInfoNotifyBody;
import vip.xjdai.springbootrecursion.model.CodeInfoNotifyBodyProxy;

public class CodeCenterPullInfoServiceImppl implements CodeCenterPullInfoService {

    @Override
    public Boolean queryCodeInfo(CodeInfoNotifyBody codeInfoNotifyBody) {
        if (codeInfoNotifyBody instanceof CodeInfoNotifyBodyProxy) {
            CodeInfoNotifyBodyProxy codeInfoNotifyBodyProxy = (CodeInfoNotifyBodyProxy) codeInfoNotifyBody;
            System.out.println(codeInfoNotifyBodyProxy.getErrorPull());
        }
        return null;
    }
}
