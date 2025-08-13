package bitmanipulation;

/*
Problem Statement (LeetCode 326: Power of Three):
Given an integer n, return true if it is a power of three (i.e., there exists an integer x such that n == 3^x). Otherwise, return false.

Constraints:
- -2^31 <= n <= 2^31 - 1 (i.e., -2,147,483,648 <= n <= 2,147,483,647)

Sample Test Cases:
1. Input: n = 27
   Output: true
   Explanation: 27 = 3^3, so it is a power of three.
2. Input: n = 0
   Output: false
   Explanation: No integer x satisfies 3^x = 0.
3. Input: n = -1
   Output: false
   Explanation: No integer x satisfies 3^x = -1.
*/

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        // Powers of three must be positive
        if (n <= 0) {
            return false;
        }

        // Largest power of three within constraints: 3^19 = 1,162,261,467
        // n is a power of three if it divides 3^19 evenly
        long maxPowerOfThree = 1162261467;
        return maxPowerOfThree % n == 0;
    }

    public static void main(String[] args) {
        PowerOfThree solution = new PowerOfThree();

        // Test Case 1: n = 27
        System.out.println("Test Case 1: n = 27, Output: " + solution.isPowerOfThree(27)); // Expected: true

        // Test Case 2: n = 0
        System.out.println("Test Case 2: n = 0, Output: " + solution.isPowerOfThree(0)); // Expected: false

        // Test Case 3: n = -1
        System.out.println("Test Case 3: n = -1, Output: " + solution.isPowerOfThree(-1)); // Expected: false
    }
}
