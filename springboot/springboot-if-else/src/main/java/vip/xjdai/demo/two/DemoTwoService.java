package vip.xjdai.demo.two;

import org.springframework.util.ObjectUtils;
import vip.xjdai.demo.ShareListener;
import vip.xjdai.demo.pojo.ShareItem;

public class DemoTwoService {
    int TYPE_LINK = 0;
    int TYPE_IMAGE = 1;
    int TYPE_TEXT = 2;
    int TYPE_IMAGE_TEXT = 3;

    public void share(vip.xjdai.demo.two.ShareItem item, ShareListener listener) {
        if (item != null) {
            if (listener != null) {
                listener.onCallback(ShareListener.STATE_FAIL, "ShareItem 不能为 null");
            }
        }
        shareImpl(item, listener);
    }

    private void shareImpl(vip.xjdai.demo.two.ShareItem item, ShareListener listener) {
        item.doShare(listener);

    }

}
