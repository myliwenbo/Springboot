package vip.xjdai.ioc.xml.statoc_;

public class MongoFileOperationUtil {

    private static AdvancedDatastore      dsForRW;
    private static MongoFileOperationUtil mongoFileOperationUtil;

    @SuppressWarnings("static-access")
    public void init() {
        mongoFileOperationUtil = this;
        mongoFileOperationUtil.dsForRW = this.dsForRW;
    }

    public AdvancedDatastore getDsForRW() {
        return dsForRW;
    }

    public void setDsForRW(AdvancedDatastore dsForRW) {
        MongoFileOperationUtil.dsForRW = dsForRW;
    }

    public MongoFileOperationUtil getMongoFileOperationUtil() {
        return mongoFileOperationUtil;
    }

    public void setMongoFileOperationUtil(MongoFileOperationUtil mongoFileOperationUtil) {
        MongoFileOperationUtil.mongoFileOperationUtil = mongoFileOperationUtil;
    }
}