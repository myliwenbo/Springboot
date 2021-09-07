package vip.xjdai.springbootdesignpattern.responsibility;

import java.util.List;

public class Chain {

    private List<ChainHandler> handler;

    private Integer index = 0;

    public Chain(List<ChainHandler> handler) {
        this.handler = handler;
    }


    public void execute() {
        if (index >= handler.size()) {
            return;
        }
        ChainHandler chainHandler = handler.get(index++);
        chainHandler.execute(this);
    }
}

