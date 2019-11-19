/**
 * 
 */
package vip.xjdai.bean.dingding;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lwb
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DingDingMessageText extends DingDingMessage {

    /**
     * 消息类型
     */
    private String msgtype = "text";

    private Text   text;
    private At     at;

    /**
     * 
     * @param content 消息
     * @param phone 手机号
     * @return  具体的消息类
     */
    public static DingDingMessageText getDingDingMessageText(String content, List<String> phone)
    {
        DingDingMessageText dingDingMessageText = new DingDingMessageText();
        dingDingMessageText.setText(dingDingMessageText.new Text(content));
        dingDingMessageText.setAt(dingDingMessageText.new At(phone, false));
        return dingDingMessageText;
    }

    class Text {
        /**
         * 发送的信息
         */
        private String content;

        /**
         * @param content2
         */
        public Text(String content2) {
            Text.this.content = content2;
        }

        public String getContent()
        {
            return content;
        }
    }

    class At {
        /**
         * 被@人的Phone
         * 
         */
        private List<String> atMobiles;
        /**
         * @所有人时:true,否则为:false
         */
        private Boolean      isAtAll = false;

        /**
         * @param phone
         */
        public At(List<String> atMobiles, Boolean isAtAll) {
            At.this.atMobiles = atMobiles;
            At.this.isAtAll = isAtAll;
        }

        public Boolean getIsAtAll()
        {
            return isAtAll;
        }

        public void setIsAtAll(Boolean isAtAll)
        {
            this.isAtAll = isAtAll;
        }

        public List<String> getAtMobiles()
        {
            return atMobiles;
        }

        public void setAtMobiles(List<String> atMobiles)
        {
            this.atMobiles = atMobiles;
        }

    }

}
