package vip.xjdai.springbootrecursion.service;

import vip.xjdai.springbootrecursion.model.CodeInfoNotifyBody;

public interface CodeCenterPullInfoService {
    final static String FUN_NAMESPACE = "qts.eip.CodeCenterPullInfoService";

    Boolean queryCodeInfo(CodeInfoNotifyBody codeInfoNotifyBody);
}