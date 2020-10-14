package vip.xjdai.interface18;

interface Formula {

    double calculate(int a);

    /**
     * 默认实现方法
     *
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}