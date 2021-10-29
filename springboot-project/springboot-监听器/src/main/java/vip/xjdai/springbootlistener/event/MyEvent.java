package vip.xjdai.springbootlistener.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Setter
@Getter
public class MyEvent extends ApplicationEvent {

    private String message;

    public MyEvent(String message) {
        super(new Object());
        this.message = message;
    }

}
