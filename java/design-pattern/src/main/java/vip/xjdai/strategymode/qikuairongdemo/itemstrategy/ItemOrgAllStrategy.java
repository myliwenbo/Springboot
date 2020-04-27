package vip.xjdai.strategymode.qikuairongdemo.itemstrategy;


import org.springframework.util.ObjectUtils;
import vip.xjdai.strategymode.qikuairongdemo.Item;
import vip.xjdai.strategymode.qikuairongdemo.QueryWrapper;

public class ItemOrgAllStrategy implements ItemStrategy {

    @Override
    public void selectStrategy(QueryWrapper<Item> itemQueryWrapper, Item iditem) {
//        itemQueryWrapper.eq(ObjectUtils.isNotEmpty(iditem.getOrgId()), Item.ORG_ID, iditem.getOrgId());
//        itemQueryWrapper.eq(Item.TYPE, ItemTypeEnums.NORMAL_ITEM.getCode());
    }

}
