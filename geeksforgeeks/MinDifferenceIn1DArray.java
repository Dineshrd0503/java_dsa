//Given an array arr[]. find the minimum difference between any pair in the given array.
//
//        Examples:
//
//Input: arr[] = [2, 4, 5, 9, 7]
//Output: 1
//Explanation: Difference between 5 and 4 is 1.
//Input: arr[] = [3, 10, 8, 6]
//Output: 2
//Explanation: Difference between 8 and 6 is 2.
//Constraints:
//        2 <= arr.size() <= 105
//        1 <= arr[i] <= 109


package geeksforgeeks;

import java.util.Arrays;

public class MinDifferenceIn1DArray {
    public static int minimumDifference(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        
        // Variable to store the minimum difference
        int minDiff = Integer.MAX_VALUE;
        
        // Loop through the sorted array and find the minimum difference
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }

    public static void main(String[] args){
        int[] arr1 = {2, 4, 5, 9, 7}; // Example 1
        int[] arr2 = {3, 10, 8, 6};   // Example 2
        
        System.out.println("Minimum difference: " + minimumDifference(arr1)); // Output: 1
        System.out.println("Minimum difference: " + minimumDifference(arr2)); // Output: 2
    }
}
