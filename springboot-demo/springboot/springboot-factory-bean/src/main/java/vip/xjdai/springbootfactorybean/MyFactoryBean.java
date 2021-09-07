package vip.xjdai.springbootfactorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean  implements FactoryBean<MyFactoryBean> {

    @Override
    public MyFactoryBean getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
