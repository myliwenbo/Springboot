package vip.xjdai.decorates.extend.dynamic;

import vip.xjdai.decorates.extend.Competitor;

public class CompetitorDecoratorB extends CompetitorDecorator {

    public CompetitorDecoratorB(Competitor competitor) {
        super(competitor);
        System.out.println(competitor.getClass().getName());
    }

    public void sing() {
        this.playMusic();
        super.sing();
    }

    private void playMusic() {
        System.out.println("播放背景音乐......");
    }
}
