package vip.xjdai.FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FactoryBeanTest implements FactoryBean<FactoryBeanTest> {

    @Override
    public FactoryBeanTest getObject() throws Exception {
        return new FactoryBeanTest();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanTest.class;
    }
}
