import cn.hutool.core.date.DateUtil;

import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {
        System.out.println(DateUtil.formatDate(DateUtil.offsetDay(new Date(), -9)));
    }

}
