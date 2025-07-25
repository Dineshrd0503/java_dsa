package logicwhilecollections;

import java.util.Arrays;

public class MissingNumber {

    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * returns the only number missing from the array.
     *
     * @param nums the input array of distinct numbers
     * @return the missing number from the range [0, n]
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;  // Length of nums is n (since numbers are in [0, n], total numbers = n + 1)

        // Sum of numbers from 0 to n inclusive using formula n*(n+1)/2
        int expectedSum = n * (n + 1) / 2;

        // Actual sum of elements in nums
        int actualSum = Arrays.stream(nums).sum();

        // Missing number is difference between expected sum and actual sum
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();

        // Test case 1
        int[] nums1 = {3, 0, 1};
        System.out.println("Missing number (Test case 1): " + solution.missingNumber(nums1)); // Expected: 2

        // Test case 2
        int[] nums2 = {0, 1};
        System.out.println("Missing number (Test case 2): " + solution.missingNumber(nums2)); // Expected: 2

        // Test case 3
        int[] nums3 = {9,6,4,2,3,5,7,0,1};
        System.out.println("Missing number (Test case 3): " + solution.missingNumber(nums3)); // Expected: 8
    }
}

