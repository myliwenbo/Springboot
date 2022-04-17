package vip.xjdai.springbootreentrantlock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.xjdai.springbootreentrantlock.mapper.OrderMapper;
import vip.xjdai.springbootreentrantlock.mapper.ProdectMapper;
import vip.xjdai.springbootreentrantlock.model.Order;
import vip.xjdai.springbootreentrantlock.model.Prodect;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProdectMapper prodectMapper;

    private final Lock lock = new ReentrantLock();

    @Transactional(rollbackFor = Exception.class)
    public void func() {
        try {
            lock.lock();
            System.out.println("我进入来");
            Prodect prodect = prodectMapper.selectById(1);
            // 如果库存数量大于 0
            if (prodect.getStock() > 0) {
                prodect.setStock(prodect.getStock() - 1);
                prodectMapper.updateById(prodect);
                Order order = new Order();
                order.setName(prodect.getName());
                order.setNumber(1L);
                orderMapper.insert(order);
            } else {
                System.out.println("库存不太够");
                throw new RuntimeException("库存存量不太够");
            }
        } finally {
            lock.unlock();
        }

    }

}
