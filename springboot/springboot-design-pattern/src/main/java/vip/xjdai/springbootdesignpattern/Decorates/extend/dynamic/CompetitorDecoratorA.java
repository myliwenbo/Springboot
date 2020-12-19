package vip.xjdai.springbootdesignpattern.Decorates.extend.dynamic;

import vip.xjdai.springbootdesignpattern.Decorates.extend.Competitor;

public class CompetitorDecoratorA extends CompetitorDecorator {

    public CompetitorDecoratorA(Competitor competitor) {
        super(competitor);
        System.out.println(competitor.getClass().getName());
    }

    public void sing() {
        this.dance();
        super.sing();
    }

    private void dance() {
        System.out.println("偏偏起舞....");
    }

}
