package vip.xjdai.springbootinitializr.fore;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

public class ForDemo {
    public static void main(String[] args) {
        Order order = new Order();
        order.setOrderD(Lists.newArrayList());
        for (int i = 0; i < 10; i++) {
            OrderD orderD = new OrderD();
            order.getOrderD().add(orderD);
        }
        order.getOrderD().forEach(item -> {
            item.setOrder(order);
        });
        for (OrderD item : order.getOrderD()) {
            System.out.println(item);
        }
    }
}

@Data
class Order {
    private List<OrderD> orderD;


    @Override
    public String toString() {
        return "Fcuk ...";
    }
}

@Data
class OrderD {

    private Order order;

}