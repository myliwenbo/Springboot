package vip.xjdai.ioc.xml.static_factory_;

public class SpringActionFactory {
    //注入对象  
    private FactoryDao staticFactoryDao;

    public void staticFactoryOk() {
        staticFactoryDao.saveFactory();
        System.out.println(staticFactoryDao.getClass().getName());
    }

    //注入对象的set方法  
    public void setStaticFactoryDao(FactoryDao staticFactoryDao) {
        this.staticFactoryDao = staticFactoryDao;
    }
}