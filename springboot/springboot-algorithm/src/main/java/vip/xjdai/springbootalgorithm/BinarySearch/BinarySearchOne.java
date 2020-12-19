package vip.xjdai.springbootalgorithm.BinarySearch;

public class BinarySearchOne {
    private int[] array;
    /**
     * 递归实现二分查找
     * @param target
     * @return
     */
    public int searchRecursion(int target) {
        if (array != null) {
            return searchRecursion(target, 0, array.length - 1);
        }
        return -1;
    }

    private int searchRecursion(int target, int start, int end) {
        //开始 > 结束
        if (start > end) {
            return -1;
        }
         // 开始 +  结束- 开始 /2
        int mid = start + (end - start) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (target < array[mid]) {
            return searchRecursion(target, start, mid - 1);
        } else {
            return searchRecursion(target, mid + 1, end);
        }
    }
}