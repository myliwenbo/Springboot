package vip.xjdai.demo.pojo;


import lombok.Data;

@Data
public class ShareItemImpl implements ShareItem {
    int type = 0;
    String title = "张三";
    String content = "标题1";
    String imagePath = "图片";
    String link = "连接";
}
