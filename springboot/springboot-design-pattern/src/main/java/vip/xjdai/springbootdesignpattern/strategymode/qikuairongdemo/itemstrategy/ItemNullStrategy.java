package vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.itemstrategy;


import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.Item;
import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.QueryWrapper;

public class ItemNullStrategy implements ItemStrategy {


    @Override

    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem) {

    }
}
