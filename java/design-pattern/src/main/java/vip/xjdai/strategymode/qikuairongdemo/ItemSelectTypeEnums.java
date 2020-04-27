package vip.xjdai.strategymode.qikuairongdemo;

import java.util.Objects;

/**
 * Title: ItemTypeEnums
 * <p>
 * Description:
 *
 * @author yt
 * @version V1.0
 */
public enum ItemSelectTypeEnums {
    SELECT_ALL_ITEM("1", "平台所有产品"),
    SELECT_PROGRAM_ITEM("2", "方案产品"),
    SELECT_ORGANIZATION_ITEM("3", "机构所有产品"),
    SELECT_CONTACTLESS_ITEM("4", "无接触金融产品"),
    ;
    private String code;

    private String msg;


    ItemSelectTypeEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 通过类型获取msg
     *
     * @param type 用户类型
     * @return 结果
     */
    public static ItemSelectTypeEnums getItemSelectTypeEnums(String type) {
        ItemSelectTypeEnums[] values = ItemSelectTypeEnums.values();
        for (ItemSelectTypeEnums value : values) {
            if (Objects.equals(type, value.getCode())) {
                return value;
            }
        }
        return null;
    }
}
