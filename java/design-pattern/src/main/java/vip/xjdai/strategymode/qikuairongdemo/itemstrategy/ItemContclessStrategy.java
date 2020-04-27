package vip.xjdai.strategymode.qikuairongdemo.itemstrategy;


import vip.xjdai.strategymode.qikuairongdemo.Item;
import vip.xjdai.strategymode.qikuairongdemo.QueryWrapper;

public class ItemContclessStrategy implements ItemStrategy {


    @Override
    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem) {
//        itemQueryWrapper.eq(Item.TYPE, ItemTypeEnums.EXTERNAL_ITEM.getCode()); //查询外部商品
    }
}
