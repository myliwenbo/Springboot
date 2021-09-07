package vip.xjdai.springbootdesignpattern.Decorates.extend;

public class CompetitorDecorator2 extends Competitor {
    /**
     * 对父类的方法进行了增强，在基础的唱歌添加了播放音乐
     */
    public void sing() {
        this.playMusic();
        super.sing();
    }

    private void playMusic() {
        System.out.println("播放背景音乐......");
    }
}
