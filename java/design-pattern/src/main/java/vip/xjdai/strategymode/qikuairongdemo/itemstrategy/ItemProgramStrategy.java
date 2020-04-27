package vip.xjdai.strategymode.qikuairongdemo.itemstrategy;


import vip.xjdai.strategymode.qikuairongdemo.Item;
import vip.xjdai.strategymode.qikuairongdemo.QueryWrapper;

public class ItemProgramStrategy implements ItemStrategy {


    @Override
    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem) {
//        itemQueryWrapper.eq(Item.TYPE, ItemTypeEnums.CASE_ITEM.getCode()); //查询方案产品
    }
}
