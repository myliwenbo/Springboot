package vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.itemstrategy;


import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.Item;
import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.QueryWrapper;

public class ItemAllStrategy implements ItemStrategy {


    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem) {
//        itemQueryWrapper.isNotNull(Item.ORG_ID);
//        itemQueryWrapper.ne(Item.TYPE, ItemTypeEnums.CASE_ITEM.getCode());
    }
}
