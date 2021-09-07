package vip.xjdai.springbootdesignpattern.Factory;

/**
 * 动物工厂，用于生产动物
 */
public interface Animal {

    /**
     * 吃
     *
     * @return
     */
    String eat();

    /**
     * 喝
     *
     * @return
     */
    String drink();

    /**
     * 跑
     *
     * @return
     */
    String run();

}