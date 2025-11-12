package bitmanipulation;

/*
Problem Statement:
You are given an integer NUM (in the range [0, 2^31 - 1]) and an array ARR of size N.
For each ARR[i], flip the bit of NUM at that 1-based position (from least significant bit).
Return the final integer after performing all flips.

Example 1:
NUM = 21 (10101 in binary)
ARR = [4, 2, 1]
Flipped: Position 4→1, Position 2→0, Position 1→0
Result: 30 (11110)

Example 2:
NUM = 40 (101000 in binary)
ARR = [4]
Flipped: Position 4→0
Result: 32 (100000)
*/

public class FlipGivenBits {
    public static int flipBits(int num, int[] arr) {
        for (int pos : arr) {
            num ^= (1 << (pos - 1));
        }
        return num;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int num1 = 21;
        int[] arr1 = {4, 2, 1};
        System.out.println(flipBits(num1, arr1)); // Output: 30

        // Sample Test Case 2
        int num2 = 40;
        int[] arr2 = {4};
        System.out.println(flipBits(num2, arr2)); // Output: 32

        // Add more static test cases below as needed!
    }
}
