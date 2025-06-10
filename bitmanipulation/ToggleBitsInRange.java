package bitmanipulation;

/**
 * Toggle bits in the given range
 * Difficulty: Easy
 * Accuracy: 65.19%
 * Submissions: 22K+
 * Points: 2
 *
 * Given a non-negative number **n** and two values **l** and **r**.
 * The problem is to toggle the bits in the range l to r in the binary representation of n,
 * i.e., to toggle bits from the **lth** least significant bit to the **rth** least significant bit
 * (the rightmost bit as counted as the **first** bit).
 *
 * A toggle operation **flips** a bit **0** to **1** and a bit **1** to **0**.
 *
 * Example 1:
 * Input: n = 17 , l = 2 , r = 3
 * Output: 23
 * Explanation:
 * (17)10 = (10001)2. After toggling all
 * the bits from 2nd to 3rd position we get
 * (10111)2 = (23)10
 *
 * Example 2:
 * Input: n = 50 , l = 2 , r = 5
 * Output: 44
 * Explanation:
 * (50)10 = (110010)2. After toggling all
 * the bits from 2nd to 5th position we get
 * (101100)2 = (44)10
 *
 * Your Task:
 * You don't need to read input or print anything.
 * Your task is to complete the function **toggleBits()** which takes
 * **three** Integers n, l and r as input and returns the modified **Integer** as the answer.
 *
 * Expected Time Complexity: O(1)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= n <= 10^5
 * 1 <= l <= r <= Number of Bits in n
 */

public class ToggleBitsInRange{

    static int toggleBits(int n, int l, int r) {
        // Create a mask to toggle bits from l to r
        // (1 << (r - l + 1)) - 1 creates a mask of r-l+1 bits set to 1
        int mask = (1 << (r - l + 1)) - 1;

        // Shift the mask to the left by (l - 1) to align it with the l-th bit
        mask <<= (l - 1);

        // Toggle the bits using XOR
        return n ^ mask;
    }

    public static void main(String[] args) {

        // Example Test Cases
        System.out.println("Example Test Case 1:");
        // Test case 1
        int n1 = 17, l1 = 2, r1 = 3;
        System.out.println("Input: n = " + n1 + ", l = " + l1 + ", r = " + r1);
        System.out.println("Output: " + toggleBits(n1, l1, r1)); // Expected Output: 23

        System.out.println("Example Test Case 2:");
        // Test case 2
        int n2 = 50, l2 = 2, r2 = 5;
        System.out.println("Input: n = " + n2 + ", l = " + l2 + ", r = " + r2);
        System.out.println("Output: " + toggleBits(n2, l2, r2)); // Expected Output: 44
    }
}