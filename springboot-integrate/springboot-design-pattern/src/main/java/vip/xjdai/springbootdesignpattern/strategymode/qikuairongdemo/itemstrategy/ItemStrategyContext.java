package vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.itemstrategy;

import com.google.common.collect.Maps;
import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.Item;
import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.ItemSelectTypeEnums;
import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.QueryWrapper;

import java.util.Map;

public class ItemStrategyContext {
    private static final Map<ItemSelectTypeEnums, ItemStrategy> map = Maps.newHashMap();

    static {
        map.put(ItemSelectTypeEnums.SELECT_ALL_ITEM, new ItemAllStrategy());
        map.put(ItemSelectTypeEnums.SELECT_PROGRAM_ITEM, new ItemProgramStrategy());
        map.put(ItemSelectTypeEnums.SELECT_ORGANIZATION_ITEM, new ItemOrgAllStrategy());
        map.put(ItemSelectTypeEnums.SELECT_CONTACTLESS_ITEM, new ItemContclessStrategy());
    }

    //调用策略实现的方法
    public void contextMethod(QueryWrapper<Item> itemQueryWrapper, Item iditem) {
        ItemStrategy itemStrategy = map.get(ItemSelectTypeEnums.getItemSelectTypeEnums(iditem.getSelectType()));
        itemStrategy.selectStrategy(itemQueryWrapper, iditem);

    }
}