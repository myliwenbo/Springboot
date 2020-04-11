package cn.lwb.ESB;

/**
 * 此类依赖于BusinessC
 *
 * @author yinwenjie
 */
@SuppressWarnings({"unused"})
public class BusinessB {
    private BusinessC bc;

    public BusinessB(BusinessC bc) {
        this.bc = bc;
    }

}