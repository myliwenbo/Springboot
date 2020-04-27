package vip.xjdai.Decorates.implement;

public class CompetitorDecorator implements Competitor {

    /**
     * 对父类的方法进行了增强，在基础的唱歌添加了跳舞~
     */
    public void sing() {
        this.dance();
    }

    private void dance() {
        System.out.println("背景音乐");
    }
}
