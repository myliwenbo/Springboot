/**
 *
 */
package cn.lwb.test;

/**
 * @author lwb
 *
 */
public class ShareItem {

    public static final int TYPE_LINK = 0;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_TEXT = 2;
    public static final int TYPE_IMAGE_TEXT = 3;

    int type;
    String title;
    String content;
    String imagePath;
    String link;

    public void isNull(ShareItem item, ShareListener listener) {
        if (item != null) {
        } else {
            if (listener != null) {
                listener.onCallback(ShareListener.STATE_FAIL, "ShareItem 不能为 null");
            }
        }
        if (listener == null) {
            listener = new ShareListener() {
                @Override
                public void onCallback(int state, String msg) {
                    System.out.println("ShareListener is null");
                }
            };
        }
    }

    public void share(ShareItem item, ShareListener listener) {
        if (item.type == TYPE_LINK) {
            // 分享链接
            if (!TextUtils.isEmpty(item.link) && !TextUtils.isEmpty(item.title)) {
                doShareLink(item.link, item.title, item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == TYPE_IMAGE) {
            // 分享图片
            if (!TextUtils.isEmpty(item.imagePath)) {
                doShareImage(item.imagePath, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == TYPE_TEXT) {
            // 分享文本
            if (!TextUtils.isEmpty(item.content)) {
                doShareText(item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == TYPE_IMAGE_TEXT) {
            // 分享图文
            if (!TextUtils.isEmpty(item.imagePath) && !TextUtils.isEmpty(item.content)) {
                doShareImageAndText(item.imagePath, item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else {
            listener.onCallback(ShareListener.STATE_FAIL, "不支持的分享类型");
        }

    }

    /**
     * @param content2
     * @param listener
     */
    private void doShareText(String content2, ShareListener listener) {
        // TODO Auto-generated method stub

    }

    /**
     * @param imagePath2
     * @param listener
     */
    private void doShareImage(String imagePath2, ShareListener listener) {
        // TODO Auto-generated method stub

    }

    /**
     * @param link2
     * @param title2
     * @param content2
     * @param listener
     */
    private void doShareLink(String link2, String title2, String content2,
                             ShareListener listener) {
        // TODO Auto-generated method stub

    }

    /**
     * @param imagePath2
     * @param content2
     * @param listener
     */
    private void doShareImageAndText(String imagePath2, String content2,
                                     ShareListener listener) {

    }
}
