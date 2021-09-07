package vip.xjdai.springbootspidemo;

import vip.xjdai.springbootspidemoparent.Developer;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Developer> uploadCDN = ServiceLoader.load(Developer.class);
        for (Developer developer : uploadCDN) {

        }
        Iterator<Developer> iterator = uploadCDN.iterator();
        while (iterator.hasNext()){
            Developer next = iterator.next();
            next.sayHi();
        }
    }
}
