package vip.xjdai.Aware.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IgnoreInterfaceImpl implements IgnoreInterface {



    @Override
    public void setCustomA(AwareCustomA awareCustomA) {
        System.out.println(awareCustomA);
    }

    @Override
    public void setCustomB(AwareCustomB awareCustomB) {
        System.out.println(awareCustomB);
    }


}
