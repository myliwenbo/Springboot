package vip.xjdai.write;

import com.alibaba.excel.metadata.Sheet;
import org.junit.Test;
import vip.xjdai.bean.TableHeaderExcelProperty;
import vip.xjdai.utils.ExcelUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelWriteDemo
{
    public static void main(String[] args)
    {
        String                 filePath = "C:\\Users\\lwb\\Desktop\\测试.xlsx";
        List< List< Object > > data     = new ArrayList<>();
        data.add(Arrays.asList("111", "222", "333"));
        data.add(Arrays.asList("111", "222", "333"));
        data.add(Arrays.asList("111", "222", "333"));
        List< String > head = Arrays.asList("表头1", "表头2", "表头3");
        ExcelUtil.writeBySimple(filePath, data, head);
    }

    @Test
    public void test()
    {
        String                                filePath = "C:\\Users\\lwb\\Desktop\\测试.xlsx";
        ArrayList< TableHeaderExcelProperty > data     = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
            tableHeaderExcelProperty.setName("cmj" + i);
            tableHeaderExcelProperty.setAge(22 + i);
            tableHeaderExcelProperty.setSchool("清华大学" + i);
            data.add(tableHeaderExcelProperty);
        }

        ExcelUtil.writeWithTemplate(filePath, data);

    }
}
