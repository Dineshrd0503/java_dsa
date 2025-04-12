package codingninjas30daychallenge;

/**
 * Problem Statement:
 * 'N' friends have wallet balances in array 'ARR'. In one transaction, a friend with balance >= K
 * can give Rs. K to another friend. Find the minimum transactions needed to equalize all balances,
 * or return -1 if impossible.
 *
 * Input Format:
 * - int k: Amount transferred per transaction
 * - int[] arr: Wallet balances of friends
 *
 * Output Format:
 * - int: Minimum transactions or -1
 *
 * Example Input/Output:
 *
 * Input: k=2, arr=[4,6,6,8]
 * Output: 1
 * Explanation: Person 4 gives Rs.2 to Person 1 → All balances become 6.
 *
 * Input: k=3, arr=[4,2,6]
 * Output: -1
 * Explanation: Cannot equalize balances (sum=12, not divisible by 3).
 */

import java.util.Arrays;

public class DistributionOfMoney {

    public static int minTransactions(int k, int[] arr) {
        int n = arr.length;

        // Step 1: Check if equalization is possible
        int totalSum = Arrays.stream(arr).sum();
        if (totalSum % n != 0) return -1;

        // Step 2: Calculate target balance
        int target = totalSum / n;

        // Step 3: Validate differences and calculate total imbalance
        int totalImbalance = 0;
        for (int balance : arr) {
            int diff = balance - target;
            if (diff % k != 0) return -1; // Must be divisible by K
            totalImbalance += Math.abs(diff);
        }

        // Step 4: Each transaction fixes 2K imbalance (give + receive)
        return totalImbalance / (2 * k);
    }

    public static void main(String[] args) {
        // Test Case 1 (Sample Input 1)
        int[] arr1 = {4, 6, 6, 8};
        System.out.println(minTransactions(2, arr1)); // Output: 1

        // Test Case 2 (Sample Input 1)
        int[] arr2 = {4, 2, 6};
        System.out.println(minTransactions(3, arr2)); // Output: -1

        // Test Case 3 (Sample Input 2)
        int[] arr3 = {3, 3, 7, 3};
        System.out.println(minTransactions(1, arr3)); // Output: 3

        // Test Case 4 (Sample Input 2)
        int[] arr4 = {3, 3, 3, 3};
        System.out.println(minTransactions(2, arr4)); // Output: 0

        // Edge Case: Single friend
        int[] arr5 = {5};
        System.out.println(minTransactions(2, arr5)); // Output: 0

        // Edge Case: Large K
        int[] arr6 = {10, 20, 30};
        System.out.println(minTransactions(5, arr6)); // Output: 2
    }
}

