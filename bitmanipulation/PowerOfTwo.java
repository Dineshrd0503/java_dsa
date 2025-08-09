package bitmanipulation;

/*
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.



Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false

 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    public static void main(String[] args) {
        // Static input values for testing
        int[] testCases = {1, 16, 3, 0, -16};

        PowerOfTwo solution = new PowerOfTwo();

        for (int n : testCases) {
            boolean result = solution.isPowerOfTwo(n);
            System.out.println("Input: " + n + ", Output: " + result);
        }
    }
}
