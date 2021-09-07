package vip.xjdai.springbootdesignpattern.responsibility;

public abstract class Handler {

    private Handler sucessor;

    public Handler getSucessor() {
        return sucessor;
    }

    public Handler setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
        return this;
    }

    public void execute() {
        handlerProcess();
        if(sucessor!=null){
            sucessor.execute();
        }
    }

    protected abstract void handlerProcess();
}
