package vip.xjdai.annotation.DependsOn.demo2;


public class EventPublisherBean {

    public void initialize() {
        System.out.println("EventPublisherBean initializing");
        EventManager.getInstance().publish("event published from EventPublisherBean");
    }
}