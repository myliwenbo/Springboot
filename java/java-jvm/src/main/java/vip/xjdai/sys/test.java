package vip.xjdai.sys;

public class test {

  public static void main(String[] args) {
    showBootPath();
    showJavaHome();
  }

  private static void showBootPath()
  {
    String path = System.getProperty("sun.boot.class.path");
    // Logger.info("sun.boot.class.path = " + path);
    System.out.println("sun.boot.class.path = " + path);
  }
  private static void showJavaHome()
  {
    String javaHome = System.getProperty("java.home");
    System.out.println("java home = " + javaHome);
  }

}