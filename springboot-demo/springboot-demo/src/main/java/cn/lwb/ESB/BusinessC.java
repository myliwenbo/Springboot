package cn.lwb.ESB;

/**
 * 此类依赖于BusinessA
 *
 * @author yinwenjie
 */
@SuppressWarnings({"unused"})
public class BusinessC {
    private BusinessA ac;

    public BusinessC(BusinessA ac) {
        this.ac = ac;
    }
}