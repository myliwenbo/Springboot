package vip.xjdai.springbootjava.JVM.parent;

import org.junit.jupiter.api.Test;
import vip.xjdai.springbootjava.JVM.parent.io.FileInputStreamImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DifferentClassLoaderTest {
    @Test
    public void parent1() throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream stream = getClass().getResourceAsStream(fileName);
                if (stream == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[stream.available()];
                    // 将流写入字节数组b中
                    stream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return super.loadClass(name);
            }
        };
        Object obj = classLoader.loadClass("vip.xjdai.springbootjava.JVM.parent.DifferentClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof DifferentClassLoaderTest);
        System.out.println(new DifferentClassLoaderTest() instanceof DifferentClassLoaderTest);
    }

    @Test
    public void parent2() throws Exception {
        System.out.println(DifferentClassLoaderTest.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(Integer.class.getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(InputStream.class.getClassLoader());
        System.out.println(FileInputStream.class.getClassLoader());
        System.out.println(FileInputStreamImpl.class.getClassLoader());
    }
}