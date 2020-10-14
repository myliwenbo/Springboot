package vip.xjdai.demo.threadLocal;

import lombok.Data;
import lombok.ToString;

@Data
public class User
{
    private String thread;
    private String serviceThread;

    @Override
    public String toString()
    {
        return "User{" + "thread='" + thread + '\'' + ", serviceThread='" + serviceThread + '\'' + '}';
    }
}
