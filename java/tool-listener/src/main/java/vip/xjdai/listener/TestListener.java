package vip.xjdai.listener;

public class TestListener
{

    public static void main(String[] args)
    {
        Robot robot = new Robot();
        robot.registerListener(new MyRobotListener());
        robot.working();
        robot.dancing();
    }
}