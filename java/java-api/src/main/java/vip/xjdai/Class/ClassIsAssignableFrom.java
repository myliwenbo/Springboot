package vip.xjdai.Class;

import java.util.Objects;

/**
 * 判断 是不是调用者的子接口或者实现类
 */
public class ClassIsAssignableFrom
{

    public static void main(String[] args)
    {
        System.out.println(AA.class.isAssignableFrom(CC.class));
    }
}

class A extends ClassIsAssignableFrom {};

class B extends A {};

interface AA{}
interface BB extends AA{}
interface CC extends BB{}