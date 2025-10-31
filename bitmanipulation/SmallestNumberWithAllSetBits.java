package bitmanipulation;

/*
LeetCode Problem: Smallest Number With All Set Bits

Given an integer n, return the smallest integer x such that:
    - x >= n
    - All bits of x are set (the binary representation consists only of 1s).

Examples:
Input: n = 5
Output: 7   (binary: 111)

Input: n = 10
Output: 15  (binary: 1111)

Input: n = 3
Output: 3   (binary: 11)

Constraints:
1 <= n <= 10^9
*/

public class SmallestNumberWithAllSetBits {

    public static int smallestNumber(int n) {
        // Keep setting bits until n becomes of the form 2^k - 1 (all bits set)
        while ((n & (n + 1)) != 0) {
            n |= (n + 1);
        }
        return n;
    }

    public static void main(String[] args) {
        // Static input examples
        int[] testCases = {5, 10, 3, 12, 17};

        for(int n : testCases) {
            int res = smallestNumber(n);
            System.out.println("Input: " + n + "  Output: " + res + "  (binary: " + Integer.toBinaryString(res) + ")");
        }
    }
}

