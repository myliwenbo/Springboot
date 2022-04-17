package vip.xjdai.springbootrecursion.service;

import vip.xjdai.springbootrecursion.model.CodeInfoNotifyBodyProxy;

public class DemoTest1 {
    public static void main(String[] args) {
        CodeCenterPullInfoService CodeCenterPullInfoServiceImppl = new CodeCenterPullInfoServiceImppl();
        CodeInfoNotifyBodyProxy CodeInfoNotifyBodyProxy = new CodeInfoNotifyBodyProxy();
        CodeInfoNotifyBodyProxy.setErrorPull(true);
        new Thread(() -> {
            CodeCenterPullInfoServiceImppl.queryCodeInfo(CodeInfoNotifyBodyProxy);
        }).start();
    }
}
