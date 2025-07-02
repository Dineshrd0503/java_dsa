package arrays;
import java.util.*;

public class FrequenciesInALimitedArray {

    public List<Integer> frequencyCount(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            list.add(map.getOrDefault(i, 0));
        }

        return list;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }
    private static void testCase1() {
        int[] arr = {2, 3, 2, 3, 5};
        FrequenciesInALimitedArray obj = new FrequenciesInALimitedArray();
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + obj.frequencyCount(arr));
    }
    private static void testCase2() {
        int[] arr = {3, 3, 3, 3};
        FrequenciesInALimitedArray obj = new FrequenciesInALimitedArray();
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + obj.frequencyCount(arr));
    }
    private static void testCase3() {
        int[] arr = {1};
        FrequenciesInALimitedArray obj = new FrequenciesInALimitedArray();
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + obj.frequencyCount(arr));
    }
    private static void testCase4() {
        int[] arr = {4, 4, 4, 2, 1};
        FrequenciesInALimitedArray obj = new FrequenciesInALimitedArray();
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + obj.frequencyCount(arr));
    }
}