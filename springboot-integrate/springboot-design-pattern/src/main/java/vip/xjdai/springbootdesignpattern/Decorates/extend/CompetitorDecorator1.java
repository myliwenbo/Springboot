package vip.xjdai.springbootdesignpattern.Decorates.extend;

public class CompetitorDecorator1 extends Competitor {
    /**
     * 对父类的方法进行了增强，在基础的唱歌添加了跳舞~
     */
    public void sing() {
        this.dance();
        super.sing();
    }

    private void dance() {
        System.out.println("偏偏起舞....");
    }
}