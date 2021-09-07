package vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.itemstrategy;


import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.Item;
import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.QueryWrapper;

public class ItemProgramStrategy implements ItemStrategy {


    @Override
    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem) {
//        itemQueryWrapper.eq(Item.TYPE, ItemTypeEnums.CASE_ITEM.getCode()); //查询方案产品
    }
}
