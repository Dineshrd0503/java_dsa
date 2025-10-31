package arrays;

/*
LeetCode Problem: The Two Sneaky Numbers of Digitville

You are given an array of integers nums representing numbers in Digitville. Two numbers are considered "sneaky" if they appear more than once in the array. Return an int[] containing all sneaky numbers in ascending order.

Example:
Input: nums = [0,1,1,0]
Output: [0,1]
*/

import java.util.*;

public class TwoSneakyNumbersInArray {
    public int[] getSneakyNumbers(int[] nums) {
        // Using frequency array for performance, assuming numbers are single digits (0-9)
        int[] freq = new int[10];
        for (int n : nums) freq[n]++;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) ans.add(i);
        }
        // Convert List<Integer> to int[]
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    // Main method for testing
    public static void main(String[] args) {
        TwoSneakyNumbersInArray sol = new TwoSneakyNumbersInArray();
        int[] nums = {0, 1, 1, 0}; // example input
        int[] result = sol.getSneakyNumbers(nums);
        System.out.println(Arrays.toString(result)); // Output: [0, 1]
    }
}

