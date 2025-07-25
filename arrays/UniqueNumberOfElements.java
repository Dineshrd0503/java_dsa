package arrays;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfElements {
    /**
     * 1207. Unique Number of Occurrences
     *
     * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [1,2,2,1,1,3]
     * Output: true
     * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
     * Example 2:
     *
     * Input: arr = [1,2]
     * Output: false
     * Example 3:
     *
     * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * Output: true
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:arr)
            map.put(n,map.getOrDefault(n,0)+1);
        HashSet<Integer> set=new HashSet<>();
        for(int val:map.values()){
            if(set.contains(val)) return false;
            set.add(val);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOfElements solution=new UniqueNumberOfElements();

        // Test Case 1
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        System.out.println("Test Case 1: " + solution.uniqueOccurrences(arr1)); // Expected: true

        // Test Case 2
        int[] arr2 = {1, 2};
        System.out.println("Test Case 2: " + solution.uniqueOccurrences(arr2)); // Expected: false

        // Test Case 3
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println("Test Case 3: " + solution.uniqueOccurrences(arr3)); // Expected: true

        // Test Case 4
        int[] arr4 = {1,2,3,4,5};
        System.out.println("Test Case 4: " + solution.uniqueOccurrences(arr4)); // Expected: true

        // Test Case 5
        int[] arr5 = {3,5,-2,-3,-6,-6};
        System.out.println("Test Case 5: " + solution.uniqueOccurrences(arr5)); // Expected: false

    }
}