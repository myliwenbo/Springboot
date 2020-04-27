package vip.xjdai.demo.two;

import org.springframework.util.ObjectUtils;
import vip.xjdai.demo.ShareListener;

public class Link extends ShareItem {
    private static int TYPE_LINK = 0;
    String title;
    String content;
    String link;

    public Link(String link, String title, String content) {
        super(TYPE_LINK);
        this.link = !ObjectUtils.isEmpty(link) ? link : "default";
        this.title = !ObjectUtils.isEmpty(title) ? title : "default";
        this.content = !ObjectUtils.isEmpty(content) ? content : "default";
    }

    @Override
    public void doShare(ShareListener listener) {
        //处理业务逻辑...
        //好几行代码
    }
}
