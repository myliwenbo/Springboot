/**
 * 
 */
package vip.xjdai.springbootdesignpattern.Decorates.implement;

/**
 * @author lwb
 *
 */
public class CompetitorDecoratorDemo {

    public static void main(String[] args) {
        //这里进行增强
        Competitor competitorDecorator1 = new CompetitorDecorator1();
        competitorDecorator1.sing();
        //可是如果既要偏偏起舞又要背景音乐咋能呢，如果直接把背景音乐的代码copy一份那就太浪费资源了
        //TODO  参考 vip.xjdai.decorates.extend.dynamic.Client
    }
}
