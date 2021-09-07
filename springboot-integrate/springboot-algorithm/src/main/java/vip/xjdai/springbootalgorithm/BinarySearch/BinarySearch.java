package vip.xjdai.springbootalgorithm.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[101];
        for (int i = 0; i < 101; i++) {
            array[i] = i;
        }
        BinarySearch value = new BinarySearch(array);
        value.search(79);
    }

    private int[] array;

    /**
     * 初始化数组
     *
     * @param array
     */
    public BinarySearch(int[] array) {
        this.array = array;
    }

    /**
     * 二分查找
     *
     * @param target
     * @return
     */
    public int search(int target) {
        if (array == null) {
            return -1;
        }
        // 从 索引 0开始
        int start = 0;
        // 获取结尾索引
        int end = array.length - 1;
        // 如果 开始索引 <= 结束 索引 ，也就说 开始索引已经是最后一个了
        while (start <= end) {
            //从数组中间获取值
            int mid = start + (end - start) / 2;
            // 如果中间值 == 目标值
            if (array[mid] == target) {
                //返回中间值
                return mid;
                // 如果 目标值 小于 中间值
            } else if (target < array[mid]) {
                // 则  50-1 =49
                end = mid - 1;
            } else {
                // 则 50+1 =51
                start = mid + 1;
            }
        }
        return -1;
    }


}