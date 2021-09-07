package vip.xjdai.demo.two;

import vip.xjdai.demo.ShareListener;

public abstract class ShareItem  {

    int type;

    public ShareItem(int type) {
        this.type = type;
    }

    public abstract void doShare(ShareListener listener);
}