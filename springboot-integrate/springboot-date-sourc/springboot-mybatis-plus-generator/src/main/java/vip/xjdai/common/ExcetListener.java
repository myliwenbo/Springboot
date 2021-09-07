package vip.xjdai.common;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcetListener<T> extends AnalysisEventListener<T> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 1000;
    List<T> list = new ArrayList<T>();
    private IBaseDao<T> iBaseDao;

    public ExcetListener(IBaseDao<T> iBaseDao) {
        this.iBaseDao = iBaseDao;
    }


    @Override
    public void invoke(T testCategory, AnalysisContext analysisContext) {
        list.add(testCategory);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }


    private void saveData() {
        iBaseDao.saveBatch(list, BATCH_COUNT);
    }
}
