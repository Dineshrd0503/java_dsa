package codingninjas;

// FindTheLoneSetBit.java
/*
Problem Statement:
=====================
You are given a single non-negative integer ‘N’ whose binary representation consists of a single ‘1’ digit and the rest of the digits are ‘0’s. Your task is to find the position of the only ‘1’ digit. In other words, your task is to find the position of the only set bit in the binary representation of the input integer ‘N’.

The position of the set bit must be counted from the LSB (Least Significant Bit) end of the Binary number. If the count of set bits in the Binary number is not equal to 1, then your function should return ‘-1’ as output.

Example:
INPUT   : N = 4
OUTPUT  : 3

In the above example, N = 4, whose Binary representation is “0100”. It is clearly visible that the binary number contains a single set bit, at a position 3 from the LSB end. Hence the output is 3

INPUT : N = 8
OUTPUT: 4

In the above example, N = 8, whose Binary representation is “1000”. It is clearly visible that the binary number contains a single set bit, at a position 4 from the LSB end. Hence the output is 4

INPUT   : N = 9
OUTPUT  : -1

In the above example, N = 9, whose Binary representation is “1001”. Now, the binary number contains 2 set bits, at a position 4 and 1 from LSB end. Hence the output is -1.

INPUT   : N = 0
OUTPUT  : -1

In the above example, N = 0, whose Binary representation is “0000”. Now, the binary number contains no set bits at all. Hence the output will be -1.

Input Format:
The first line of input contains an integer 'T' representing the number of the test case. Then the test case follows.
The only line of each test case contains a single integer ‘N’.

Output Format:
For every test case, print a single integer, which is the position of the lone set bit in the binary representation of the input integer ‘N’.

Constraints:
1 <= T <= 100
0 <= N <= 10^5

Time limit: 1 second

Sample Input:
4
2
8
11
0

Sample Output:
2
4
-1
-1
*/

import java.util.Scanner;

public class FindTheLoneSetBit {

    public static int findSetBit(int n) {
        if (n == 0) return -1; // Case when N is 0

        if ((n & (n - 1)) != 0) return -1; // Check if N has more than 1 set bit

        int position = 1; // Start counting from LSB (1st position)

        while (n > 1) {
            n >>= 1; // Right shift N by 1
            position++; // Increment position count
        }

        return position; // Return the found position
    }

    public static void main(String[] args) {
        // Static test cases
        int[] testCases = {2, 8, 11, 0}; // Example inputs

        for (int N : testCases) {
            System.out.println(findSetBit(N)); // Output the position of the lone set bit
        }
    }
}
