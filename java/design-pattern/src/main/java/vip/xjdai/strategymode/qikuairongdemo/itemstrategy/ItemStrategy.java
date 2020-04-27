package vip.xjdai.strategymode.qikuairongdemo.itemstrategy;


import vip.xjdai.strategymode.qikuairongdemo.Item;
import vip.xjdai.strategymode.qikuairongdemo.QueryWrapper;

public interface ItemStrategy {

    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem);
}
