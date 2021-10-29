/**
 *
 */
package vip.xjdai.decorates.implement;

/**
 * @author lwb
 *
 */
public class CompetitorDecorator3 extends CompetitorDecorator {
    /**
     * 对父类的方法进行了增强，在基础的唱歌添加背景介绍
     */
    public void sing() {
        super.sing();
        this.introduceBackground();
    }

    private void introduceBackground() {
        System.out.println("悲惨背景介绍，博取同情，赢感情牌....");
    }
}
