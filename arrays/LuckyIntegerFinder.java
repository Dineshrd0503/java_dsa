package arrays;
import java.util.HashMap;
import java.util.Map;

public class LuckyIntegerFinder {
    /**
     * Given an array of integers `arr`, a **lucky integer** is an integer that has a frequency in the array equal to its value.
     *
     * Return _the largest **lucky integer** in the array_. If there is no **lucky integer** return `-1`.
     *
     * **Example 1:**
     *
     * **Input:** arr = \[2,2,3,4]
     * **Output:** 2
     * **Explanation:** The only lucky number in the array is 2 because frequency\[2] == 2.
     *
     * **Example 2:**
     *
     * **Input:** arr = \[1,2,2,3,3,3]
     * **Output:** 3
     * **Explanation:** 1, 2 and 3 are all lucky numbers, return the largest of them.
     *
     * **Example 3:**
     *
     * **Input:** arr = \[2,2,2,3,3]
     * **Output:** -1
     * **Explanation:** There are no lucky numbers in the array.
     *
     * **Constraints:**
     *
     * *   `1 <= arr.length <= 500`
     * *   `1 <= arr[i] <= 500`
     *
     * @param arr The input array of integers
     * @return The largest lucky integer in the array, or -1 if there is no lucky integer
     */
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                max = Math.max(max, entry.getKey());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LuckyIntegerFinder solution = new LuckyIntegerFinder();

        // Test case 1
        int[] arr1 = {2, 2, 3, 4};
        System.out.println("Input: arr = [2, 2, 3, 4]");
        System.out.println("Output: " + solution.findLucky(arr1)); // Expected output: 2

        // Test case 2
        int[] arr2 = {1, 2, 2, 3, 3, 3};
        System.out.println("Input: arr = [1, 2, 2, 3, 3, 3]");
        System.out.println("Output: " + solution.findLucky(arr2)); // Expected output: 3

        // Test case 3
        int[] arr3 = {2, 2, 2, 3, 3};
        System.out.println("Input: arr = [2, 2, 2, 3, 3]");
        System.out.println("Output: " + solution.findLucky(arr3)); // Expected output: -1

        //Test case 4
        int[] arr4 = {5,5,5,5,5,5,5,5,5,5};
        System.out.println("Input: arr = [5,5,5,5,5,5,5,5,5,5]");
        System.out.println("Output: " + solution.findLucky(arr4)); //Expected output: 5
    }
}