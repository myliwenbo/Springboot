package vip.xjdai.springbootehcache;

public class BinaryTest {
    public static int binary(int[] array, int value) {
        // 数组的最大索引
        int low = 0;
        // 数组的最大索引
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (value == array[middle]) {
                return middle;
            }
            if (value > array[middle]) {
                low = middle + 1;
            }
            if (value < array[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9, 5, 6, 7, 8, 13};
        int value = binary(a, 9);
        System.out.println(value);
    }
}