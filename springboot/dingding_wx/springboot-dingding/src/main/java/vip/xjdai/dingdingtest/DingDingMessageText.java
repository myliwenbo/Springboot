package vip.xjdai.dingdingtest;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DingDingMessageText extends DingDingMessage {
    private String msgtype = "text";
    private DingDingMessageText.Text text;
    private DingDingMessageText.At at;

    public static DingDingMessageText getDingDingMessageText(String content, List<String> phone) {
        DingDingMessageText dingDingMessageText = new DingDingMessageText();
        dingDingMessageText.setText(new Text(content));
        dingDingMessageText.setAt(new At(phone, false));
        return dingDingMessageText;
    }


    @Data
    public static class At {
        private List<String> atMobiles;
        private Boolean isAtAll = false;

        public At(List<String> atMobiles, Boolean isAtAll) {
            this.atMobiles = atMobiles;
            this.isAtAll = isAtAll;
        }

    }

    @Data
    static
    class Text {
        private String content;

        public Text(String content) {
        }
    }
}
