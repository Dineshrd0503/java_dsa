package bitmanipulation;

/*
Problem Statement:
You are given a positive integer 'N'. Your task is to find the greatest integer less than or equal to 'N'
which is a power of 2. A power of 2 is an integer of the form 2^k where k is a non-negative integer
(e.g., 1, 2, 4, 8, 16, ...).

For Example:
- If N = 14, the nearest integer that is less than or equal to 14 and is a power of two is 8 (2^3).
  So, the answer is 8.
- If N = 4, the answer is 4 (2^2) since 4 is already a power of two.

Follow-Up:
Can you solve this in constant time and space complexity?

Constraints:
- 1 <= T <= 2 * 10^3 (number of test cases)
- 1 <= N <= 10^9
Time Limit: 1 second

Sample Test Cases:
1. Input: N = 4
   Output: 4
   Explanation: 4 itself is a power of two (2^2).
2. Input: N = 22
   Output: 16
   Explanation: The nearest integer that is less than or equal to 22 and is a power of two is 16 (2^4).
3. Input: N = 1
   Output: 1
   Explanation: 1 itself is a power of two (2^0).
4. Input: N = 63
   Output: 32
   Explanation: The nearest integer that is less than or equal to 63 and is a power of two is 32 (2^5).
5. Input: N = 10^9
   Output: 536870912
   Explanation: The nearest integer that is less than or equal to 10^9 and is a power of two is 2^29 (536,870,912).
*/

public class GreatestPowerOfTwolessThanOrEqualToN {
    public static int findMSB(int n) {
        // Find the largest power of 2 less than or equal to n using bit manipulation
        return Integer.highestOneBit(n);
    }

    public static void main(String[] args) {
        // Static test cases
        int[] testCases = {4, 22, 1, 63, 1000000000}; // 10^9
        for (int n : testCases) {
            int result = findMSB(n);
            System.out.println("N = " + n + ", Largest Power of 2 <= N = " + result);
        }
    }
}