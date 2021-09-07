package vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.itemstrategy;


import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.Item;
import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.QueryWrapper;

public class ItemContclessStrategy implements ItemStrategy {


    @Override
    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem) {
//        itemQueryWrapper.eq(Item.TYPE, ItemTypeEnums.EXTERNAL_ITEM.getCode()); //查询外部商品
    }
}
