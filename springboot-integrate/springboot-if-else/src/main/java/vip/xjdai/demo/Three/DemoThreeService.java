package vip.xjdai.demo.Three;

import org.springframework.util.ObjectUtils;
import vip.xjdai.demo.pojo.ShareItem;
import vip.xjdai.demo.ShareListener;

public class DemoThreeService {
    int TYPE_LINK = 0;
    int TYPE_IMAGE = 1;
    int TYPE_TEXT = 2;
    int TYPE_IMAGE_TEXT = 3;

    public void share(ShareItem item, ShareListener listener) {
        if (item != null) {
            if (listener != null) {
                listener.onCallback(ShareListener.STATE_FAIL, "ShareItem 不能为 null");
            }
        }
        shareImpl(item, listener);
    }

    private void shareImpl(ShareItem item, ShareListener listener) {
        if (item.type == TYPE_LINK) {
            // 分享链接
            if (!ObjectUtils.isEmpty(item.link) && !ObjectUtils.isEmpty(item.title)) {
                doShareLink(item.link, item.title, item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == TYPE_IMAGE) {
            // 分享图片
            if (!ObjectUtils.isEmpty(item.imagePath)) {
                doShareImage(item.imagePath, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == TYPE_TEXT) {
            // 分享文本
            if (!ObjectUtils.isEmpty(item.content)) {
                doShareText(item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == TYPE_IMAGE_TEXT) {
            // 分享图文
            if (!ObjectUtils.isEmpty(item.imagePath) && !ObjectUtils.isEmpty(item.content)) {
                doShareImageAndText(item.imagePath, item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else {
            listener.onCallback(ShareListener.STATE_FAIL, "不支持的分享类型");
        }
    }

    private void doShareImageAndText(String imagePath, String content, ShareListener listener) {
        //处理业务逻辑...
        //好几行代码
    }

    private void doShareText(String content, ShareListener listener) {
        //处理业务逻辑...
        //好几行代码
    }

    private void doShareImage(String imagePath, ShareListener listener) {
        //处理业务逻辑...
        //好几行代码
    }

    private void doShareLink(String link, String title, String content, ShareListener listener) { //处理业务逻辑...
        //好几行代码
    }
}
