package vip.xjdai.springbootlistener.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 事件
 */
@Data
public class MyEvent extends ApplicationEvent
{

    private String  address;
    private String  text;

    public MyEvent(Object sourcee, String address, String text)
    {
        super(sourcee);
        this.address=address;
        this.text=text;
    }

}
