package vip.xjdai.redis.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流量削峰的演示
 */
@RestController
@RequestMapping("traffic")
public class FlowPeakingController {

    @Autowired
    private FlowPeakingService flowPeakingService;

    /**
     * 这是一个秒杀服务，由于是同步的，假设我们调用这个服务，只能等待整个服务调用完整..
     * 那要如何处理呢？利用redis中的消息队列来完成
     */
    @RequestMapping("spike1")
    public void spike1() {
        flowPeakingService.test1();
    }
    @RequestMapping("spike2")
    public void spike2() {
        flowPeakingService.test2();
    }
}
