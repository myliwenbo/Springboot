package vip.xjdai.spi;

public   class JavaDeveloper implements Developer {

    @Override
    public void sayHi() {
        System.out.println("Hi, I am a Java Developer.");
    }
}