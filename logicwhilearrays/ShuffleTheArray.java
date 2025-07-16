package logicwhilearrays;
/*
Problem Statement:
Given an array nums consisting of 2n elements in the form [x1, x2, ..., xn, y1, y2, ..., yn], shuffle the array into the form [x1, y1, x2, y2, ..., xn, yn].

Sample Input 1:
nums = {2, 5, 1, 3, 4, 7}
Sample Output 1:
2 3 5 4 1 7

Sample Input 2:
nums = {1, 2, 3, 4}
Sample Output 3:
6 9 7 10 8 11
 */

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] shuffled = new int[nums.length];

        for (int i = 0; i < n; i++) {
            shuffled[2 * i] = nums[i];       // Place the first half elements at even indices
            shuffled[2 * i + 1] = nums[i + n]; // Place the second half elements at odd indices
        }

        // Print the shuffled array
        for (int num : shuffled) {
            System.out.print(num + " ");
        }
    }
}
