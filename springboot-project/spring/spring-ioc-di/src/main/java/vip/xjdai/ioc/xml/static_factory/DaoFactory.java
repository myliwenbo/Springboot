package vip.xjdai.ioc.xml.static_factory;

public class DaoFactory {
    //静态工厂  
    public static final FactoryDao getStaticFactoryDaoImpl() {
        return new StaticFacotryDaoImpl();
    }
}