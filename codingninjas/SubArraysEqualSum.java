package codingninjas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.
//
//        For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.
//
//Follow Up:
//
//Can you solve this using not more than O(S) extra space, where S is the sum of all elements of the given array?
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= 'T' <= 10
//        1 <= 'N' <= 100
//        1 <= 'ARR'[i] <= 100
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        6
//        3 1 1 2 2 1
//        5
//        5 6 5 11 6
//Sample Output 1:
//        true
//        false
//Explanation Of Sample Input 1:
//For the first test case, the array can be partitioned as ([2,1,1,1] and [3, 2]) or ([2,2,1], and [1,1,3]) with sum 5.
//
//For the second test case, the array can’t be partitioned.
//Sample Input 2:
//        2
//        9
//        2 2 1 1 1 1 1 3 3
//        6
//        8 7 6 12 4 5
//Sample Output 2:
//        false
//        true

public class SubArraysEqualSum {
    public static boolean canPartition(int[] arr, int n) {
        int totalsum = Arrays.stream(arr).sum();

        // If the total sum is odd, partition is not possible
        if (totalsum % 2 != 0)
            return false;

        int target = totalsum / 2; // The sum each subset needs to reach
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: sum 0 is always possible

        int prefixsum = 0;
        for (int num : arr) {
            prefixsum += num;

            // Check if we have seen the required complement to form 'target'
            if (map.containsKey(prefixsum - target))
                return true;

            // Update map with the current prefix sum
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }

        return false;
    }
    public static boolean canPartition2(int[] arr, int n) {
        int totalsum = Arrays.stream(arr).sum();

        if (totalsum % 2 != 0)
            return false;

        int target = totalsum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        int n = arr.length;
        System.out.println(canPartition(arr, n)); // Output: true
        int arr2[]={4,9,11,3,2};
        System.out.println(canPartition2(arr2, n)); // Output: true
    }

}
