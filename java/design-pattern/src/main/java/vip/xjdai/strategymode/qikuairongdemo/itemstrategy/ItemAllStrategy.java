package vip.xjdai.strategymode.qikuairongdemo.itemstrategy;


import vip.xjdai.strategymode.qikuairongdemo.Item;
import vip.xjdai.strategymode.qikuairongdemo.QueryWrapper;

public class ItemAllStrategy implements ItemStrategy {


    @Override
    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem) {
//        itemQueryWrapper.isNotNull(Item.ORG_ID);
//        itemQueryWrapper.ne(Item.TYPE, ItemTypeEnums.CASE_ITEM.getCode());
    }
}
