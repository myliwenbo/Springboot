package vip.xjdai.annotation.DependsOn.demo2;


/**
 *
 */
public class EventListenerBean {

    private void initialize() {
        EventManager.getInstance().addListener(s ->
                        System.out.println("event received in EventListenerBean : " + s));
    }
}