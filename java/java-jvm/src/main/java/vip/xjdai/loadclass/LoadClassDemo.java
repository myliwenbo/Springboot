package vip.xjdai.loadclass;

import sun.misc.Launcher;

public class LoadClassDemo {

    public static void main(String[] args) {
        ClassLoader appClassLoader = Launcher.getLauncher().getClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();

        System.out.println(extClassLoader);
    }
}
