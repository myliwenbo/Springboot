package vip.xjdai.read;

import com.alibaba.excel.metadata.Sheet;
import org.junit.Test;
import vip.xjdai.bean.TableHeaderExcelProperty;
import vip.xjdai.utils.ExcelUtil;

import java.util.ArrayList;
import java.util.List;

public class ExcelReadDemo
{
    public static void main(String[] args)
    {
        String       filePath = "C:\\Users\\lwb\\Desktop\\学生表.xlsx";
        //第一个1代表sheet1, 第二个1代表从第几行开始读取数据，行号最小值为0
        Sheet sheet = new Sheet(1, 0);
        List<Object> objects  = ExcelUtil.readMoreThan1000RowBySheet(filePath,sheet);
        for (Object object : objects) {
            System.out.println(object.toString());
        }
    }


}
