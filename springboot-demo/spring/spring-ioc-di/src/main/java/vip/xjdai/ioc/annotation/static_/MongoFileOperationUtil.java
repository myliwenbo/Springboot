package vip.xjdai.ioc.annotation.static_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoFileOperationUtil {

    private static AdvancedDatastore dsForRW;

    @Autowired
    public void setDatastore(AdvancedDatastore dsForRW) {
        MongoFileOperationUtil.dsForRW = dsForRW;
    }

    public AdvancedDatastore getDsForRW() {
        return dsForRW;
    }

}