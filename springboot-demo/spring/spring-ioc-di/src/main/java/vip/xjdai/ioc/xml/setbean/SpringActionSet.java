package vip.xjdai.ioc.xml.setbean;

public class SpringActionSet {

    //注入对象springDao
    private SpringDao springDao;

    //一定要写被注入对象的set方法  
    public void setSpringDao(SpringDao springDao) {
        this.springDao = springDao;
    }

    public void ok() {
        springDao.ok();
        System.out.println(springDao.getClass().getName());
    }
}