package vip.xjdai.ioc.xml.static_factory;

public class StaticFacotryDaoImpl implements FactoryDao {

    @Override
    public void saveFactory() {
        System.out.println("我是一个对象"+this);
    }

}
