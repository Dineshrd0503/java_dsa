package arrays;

import java.util.*;
import java.lang.*;

public class PoliceAndThieves {
    /**
     * Problem Statement:
     * Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief.
     * Find the maximum number of thieves that can be caught by the police.
     * Keep in mind the following conditions:
     * 1. Each policeman can catch only one thief.
     * 2. A policeman cannot catch a thief who is more than k units away from him.
     *
     * Constraints:
     * 1 <= arr.length <= 10^5
     * 1 <= k <= 1000
     * arr[i] = 'P' or 'T'
     *
     * Examples:
     * Input: arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
     * Output: 2
     * Explanation: Maximum 2 thieves can be caught. First policeman catches first thief,
     * and the second police man can catch either the second or third thief.
     *
     * Input: arr[] = ['T', 'T', 'P', 'P', 'T', 'P'], k = 2
     * Output: 3
     * Explanation: Maximum 3 thieves can be caught.
     *
     * Expected Time Complexity: O(n)
     * Expected Auxiliary Space: O(1)
     */
    public int catchThieves(char[] arr, int k) {
        int count = 0;
        Queue<Integer> thieves = new LinkedList<>();
        Queue<Integer> police = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                police.offer(i);
            } else if(arr[i] == 'T'){
                thieves.offer(i);
            }
        }

        while (!police.isEmpty() && !thieves.isEmpty()) {
            int policeIndex = police.peek();
            int thiefIndex = thieves.peek();

            if (Math.abs(policeIndex - thiefIndex) <= k) {
                count++;
                police.poll();
                thieves.poll();
            } else if (policeIndex < thiefIndex) {
                police.poll();
            } else {
                thieves.poll();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PoliceAndThieves sol = new PoliceAndThieves();

        // Test case 1
        char[] arr1 = {'P', 'T', 'T', 'P', 'T'};
        int k1 = 1;
        System.out.println("Test Case 1: " + sol.catchThieves(arr1, k1)); // Output: 2

        // Test case 2
        char[] arr2 = {'T', 'T', 'P', 'P', 'T', 'P'};
        int k2 = 2;
        System.out.println("Test Case 2: " + sol.catchThieves(arr2, k2)); // Output: 3

        // Test case 3
        char[] arr3 = {'P', 'P', 'T', 'T','P'};
        int k3 = 2;
        System.out.println("Test Case 3: " + sol.catchThieves(arr3, k3)); // Output: 2

        // Test case 4
        char[] arr4 = {'T','T','T'};
        int k4 = 2;
        System.out.println("Test Case 4: " + sol.catchThieves(arr4, k4)); // Output: 0

        // Test case 5
        char[] arr5 = {'P','P','P'};
        int k5 = 2;
        System.out.println("Test Case 5: " + sol.catchThieves(arr5, k5)); // Output: 0
    }
}