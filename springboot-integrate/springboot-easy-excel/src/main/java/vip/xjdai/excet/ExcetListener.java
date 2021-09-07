package vip.xjdai.excet;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vip.xjdai.dao.IBaseDao;
import vip.xjdai.pojo.BaseDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @param <T>
 */
public class ExcetListener<T extends BaseDo<T>> extends AnalysisEventListener<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcetListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 30;
    List<T> addList = new ArrayList<>();
    List<T> updataList = new ArrayList<>();
    private IBaseDao<T> iBaseDao;
    private Boolean isUpData = Boolean.FALSE;

    public ExcetListener(IBaseDao<T> iBaseDao) {
        this.iBaseDao = iBaseDao;
    }

    public ExcetListener(IBaseDao<T> iBaseDao, Boolean isUpData) {
        this(iBaseDao);
        this.isUpData = isUpData;

    }


    /**
     * 这个每一条数据解析都会来调用
     *
     * @param testCategory
     * @param analysisContext
     */
    @SneakyThrows
    @Override
    public void invoke(T testCategory, AnalysisContext analysisContext) {
        if (isUpData) {
            updataList.add(testCategory);
        } else {
            addList.add(testCategory);
        }
        if (addList.size() >= BATCH_COUNT || updataList.size() >= BATCH_COUNT) {
            saveData();
            addList.clear();
            updata();
            updataList.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param analysisContext
     */
    @SneakyThrows
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        updata();
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        if (addList.isEmpty()) {
            return;
        }
        iBaseDao.saveBatch(addList, BATCH_COUNT);
    }

    private void updata() throws Exception {
        if (updataList.isEmpty()) {
            return;
        }
        //这些是要进行更新的
        Map<String, T> updataMap = iBaseDao.listBatchByEntityList(getQueryList()).stream()
                .collect(Collectors.toMap(T::getOnlyCode, Function.identity()));
        //所有数据
        Map<String, T> collect = updataList.stream().collect(Collectors.toMap(T::getOnlyCode, Function.identity()));
        collect.forEach((key, value) -> {
            T t = updataMap.get(key);
            if (t != null) {
                value.setId(t.getId());
            }
        });
        updataList = new ArrayList<>(collect.values());
        iBaseDao.saveOrUpdateBatch(updataList);
    }

    public List<T> getQueryList() throws Exception {
        List<T> queryList = Lists.newArrayList();
        for (T t : updataList) {
            try {
                Class<? extends BaseDo> aClass = t.getClass();
                T baseDo = (T) aClass.newInstance();
                baseDo.setOnlyCode(t.getOnlyCode());
                queryList.add(baseDo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return queryList;
    }

}
