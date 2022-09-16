package vip.xjdai.springbootjaxb.demo3;

public class AnJiSanYuanResponse {
    private AnJiSanYuanCommonBean BASEINFO;

    public AnJiSanYuanCommonBean getBASEINFO() {
        return BASEINFO;
    }

    public void setBASEINFO(AnJiSanYuanCommonBean BASEINFO) {
        this.BASEINFO = BASEINFO;
    }

    public static <T extends AnJiSanYuanResponse> T CreateAnJiSanYuanResponse(T data, String messageId) {
        AnJiSanYuanCommonBean anJiSanYuanCommonBean = new AnJiSanYuanCommonBean();
        anJiSanYuanCommonBean.setMessageId(messageId);
        data.setBASEINFO(anJiSanYuanCommonBean);
        return data;
    }

}




