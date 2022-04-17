package vip.xjdai.springbootinitializr.jsonmodel;

@lombok.Data
public class Demo {
    private String barCode;
    private String code;
    private long createDate;
    private long createUid;
    private Currency currency;
    private String currencyCode;
    private double id;
    private InvSku invSku;
    private String invSkuBarCode;
    private String invSkuCode;
    private String invSkuName;
    private Item item;
    private double itemID;
    private String itemOutID;
    private Item libraItem;
    private String name;
    private String outCode;
    private String outID;
    private double sellerPartnerID;
    private String shopCode;
    private long writeDate;
    private long writeUid;
}

// Currency.java


@lombok.Data
class Currency {
    private String code;
}

// InvSku.java

@lombok.Data
class InvSku {
    private String boxPropertyStr;
    private double id;
}

// Item.java
@lombok.Data
class Item {
    private double id;
}
