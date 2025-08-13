package arrays;

/*
Problem Statement:
Given an array arr[] of size n, where arr[i] represents the number of soldiers in the i-th troop, and an integer k, a troop is considered "lucky" if its number of soldiers is a multiple of k. Find the minimum total number of soldiers to add across all troops so that at least ⌈n/2⌉ troops become lucky.

Constraints:
- 1 ≤ n ≤ 10^5
- 1 ≤ k ≤ 10^5
- 1 ≤ arr[i] ≤ 10^5

Sample Test Cases:
1. Input: arr = [5, 6, 3, 2, 1], k = 2
   Output: 1
   Explanation: Add 1 soldier to troop with 1 soldier to get [5, 6, 3, 2, 2]. Now 3 troops (6, 2, 2) are lucky (multiples of 2), satisfying ⌈5/2⌉ = 3.
2. Input: arr = [3, 5, 6, 7, 9, 10], k = 4
   Output: 4
   Explanation: Need at least ⌈6/2⌉ = 3 lucky troops. Add 1 to troop 3 (3→4), 2 to troop 6 (6→8), 1 to troop 7 (7→8). New array: [3, 5, 4, 8, 9, 8], with 3 lucky troops (4, 8, 8). Total = 1 + 2 + 1 = 4.
*/

import java.util.Arrays;

public class TywinsWarStrategy {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        // Calculate the minimum number of lucky troops needed: ⌈n/2⌉
        int target = (int) Math.ceil(n / 2.0);

        // Array to store soldiers needed to make each troop lucky
        int[] soldiersNeeded = new int[n];

        // Calculate soldiers needed for each troop to be divisible by k
        for (int i = 0; i < n; i++) {
            // Soldiers needed = (k - (arr[i] % k)) % k
            // This gives the minimum soldiers to reach the next multiple of k
            soldiersNeeded[i] = (k - (arr[i] % k)) % k;
        }

        // Sort the soldiers needed to select the minimum additions
        Arrays.sort(soldiersNeeded);

        // Sum the smallest target additions
        int totalSoldiers = 0;
        for (int i = 0; i < target; i++) {
            totalSoldiers += soldiersNeeded[i];
        }

        return totalSoldiers;
    }

    public static void main(String[] args) {
        TywinsWarStrategy solution = new TywinsWarStrategy();

        // Test Case 1: arr = [5, 6, 3, 2, 1], k = 2
        int[] arr1 = {5, 6, 3, 2, 1};
        int k1 = 2;
        System.out.println("Test Case 1: arr = " + Arrays.toString(arr1) + ", k = " + k1 + ", Output: " + solution.minSoldiers(arr1, k1)); // Expected: 1

        // Test Case 2: arr = [3, 5, 6, 7, 9, 10], k = 4
        int[] arr2 = {3, 5, 6, 7, 9, 10};
        int k2 = 4;
        System.out.println("Test Case 2: arr = " + Arrays.toString(arr2) + ", k = " + k2 + ", Output: " + solution.minSoldiers(arr2, k2)); // Expected: 4
    }
}
