package cn.lwb.ESB;

/**
 * 此类依赖于BusinessB
 *
 * @author yinwenjie
 */
@SuppressWarnings({"unused"})
public class BusinessA {
    private BusinessB bb;

    public BusinessA(BusinessB bb) {
        this.bb = bb;
    }

}
