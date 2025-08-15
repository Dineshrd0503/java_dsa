package bitmanipulation;

/*
Problem Statement:
Given a positive integer 'n', determine if it is a power of four. A power of four is an integer of the form
4^k where k is a non-negative integer (e.g., 1, 4, 16, 64, ...). Note that 0 is not considered a power of
four, and the number must be positive.

Examples:
- n = 16 -> Returns true (16 = 4^2)
- n = 5 -> Returns false (5 is not a power of four)
- n = 1 -> Returns true (1 = 4^0)
- n = 64 -> Returns true (64 = 4^3)
- n = 0 -> Returns false (0 is not a power of four)

Constraints:
- 0 <= n <= 2^31 - 1 (fits within a 32-bit signed integer)
Time Limit: 1 second

Sample Test Cases:
1. Input: n = 16
   Output: true
   Explanation: 16 is 4^2.
2. Input: n = 5
   Output: false
   Explanation: 5 is not a power of four.
3. Input: n = 1
   Output: true
   Explanation: 1 is 4^0.
4. Input: n = 64
   Output: true
   Explanation: 64 is 4^3.
5. Input: n = 0
   Output: false
   Explanation: 0 is not a power of four.
*/

public class PowerofFour {
    public static boolean isPowerOfFour(int n) {
        // Optimized approach using bit manipulation
        // A number is a power of four if:
        // 1. It is a power of two (exactly one set bit)
        // 2. The set bit is at an odd position (1-based) in its binary representation
        if (n <= 0) return false; // Handle non-positive numbers
        // Check if it's a power of two using n & (n - 1) == 0
        if ((n & (n - 1)) != 0) return false;
        // Check if the set bit is at an odd position using n & 0x55555555
        // 0x55555555 is a mask with 1s at odd positions (101010... in binary)
        return (n & 0x55555555) != 0;

        /*
        // Alternative Approach 1: Using logarithm
        if (n <= 0) return false;
        double logResult = Math.log(n) / Math.log(4);
        return logResult == (int)logResult;

        // Alternative Approach 2: Iterative division by 4
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 4 != 0) return false;
            n /= 4;
        }
        return n == 1;
        */
    }

    public static void main(String[] args) {
        // Static test cases
        int[] testCases = {16, 5, 1, 64, 0};
        for (int n : testCases) {
            boolean result = isPowerOfFour(n);
            System.out.println("n = " + n + ", Is Power of Four? = " + result);
        }
    }
}
