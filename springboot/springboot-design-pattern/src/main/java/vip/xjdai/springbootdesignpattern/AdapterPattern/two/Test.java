package vip.xjdai.springbootdesignpattern.AdapterPattern.two;

import java.util.LinkedList;
import java.util.List;

public class Test {
    private List<DC5Adapter> adapters = new LinkedList<DC5Adapter>();

    public Test() {
        this.adapters.add(new ChinaPowerAdapter());
        this.adapters.add(new JapanPowerAdapter());
    }

    // 根据电压找合适的变压器
    public DC5Adapter getPowerAdapter(AC ac) {
        DC5Adapter adapter = null;
        for (DC5Adapter ad : this.adapters) {
            if (ad.support(ac)) {
                adapter = ad;
                break;
            }
        }
        if (adapter == null){
            throw new  IllegalArgumentException("没有找到合适的变压适配器");
        }
        return adapter;
    }

    public static void main(String[] args) {
        Test test = new Test();
        AC chinaAC = new AC220();
        DC5Adapter adapter = test.getPowerAdapter(chinaAC);
        adapter.outputDC5V(chinaAC);

        // 去日本旅游，电压是 110V
        AC japanAC = new AC110();
        adapter = test.getPowerAdapter(japanAC);
        adapter.outputDC5V(japanAC);
    }
}
