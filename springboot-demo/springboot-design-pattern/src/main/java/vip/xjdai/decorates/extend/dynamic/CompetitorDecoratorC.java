package vip.xjdai.decorates.extend.dynamic;

import vip.xjdai.decorates.extend.Competitor;

public class CompetitorDecoratorC extends CompetitorDecorator {

    public CompetitorDecoratorC(Competitor competitor) {
        super(competitor);
        System.out.println(competitor.getClass().getName());
    }

    public void sing() {
        super.sing();
        this.introduceBackground();
    }

    private void introduceBackground() {
        System.out.println("悲惨背景介绍，博取同情，赢感情牌....");
    }
}
