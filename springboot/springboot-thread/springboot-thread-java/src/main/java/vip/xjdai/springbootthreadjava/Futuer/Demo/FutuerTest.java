package vip.xjdai.springbootthreadjava.Futuer.Demo;

public class FutuerTest {
    public static void main(String[] args) {

    }
}

interface Futuer {
    Integer getReuqest();

    void setReuqest(Integer reuqest);
}

class FutuerUtils implements Futuer {

    private Futuer futuer;

    public FutuerUtils(Futuer futuer) {
        this.futuer = futuer;
    }

    @Override
    public Integer getReuqest() {
        //此时属于阻塞状态..
        return this.futuer.getReuqest();
    }

    @Override
    public void setReuqest(Integer reuqest) {
        new Thread(() -> {
            this.futuer.setReuqest(reuqest);
        });
    }
}
