package vip.xjdai.listener;

/**
 * 事件对象
 */
public class Even {

    private Robot robot;

    public Even(){
        super();
    }
    public Even(Robot robot){
        super();
        this.robot = robot;
    }


    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}