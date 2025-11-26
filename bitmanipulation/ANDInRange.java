package bitmanipulation;

/*
Problem Statement:
Given two integers l and r, find the result after applying the series of Bitwise AND (&) operation on every natural number between the range l to r (including both).

Example:
Input: l = 8, r = 13
Output: 8
Explanation: 8 & 9 & 10 & 11 & 12 & 13 = 8

Constraints:
1 <= l <= r <= 10^9
*/

// GFG Driver class for context
public class ANDInRange
{
    // Function to compute Bitwise AND in range [l, r]
    public int andInRange(int l, int r)
    {
        int shift = 0; // Count of how many bits are right-shifted

        // Find common prefix. Every time l and r differ, right shift both to remove differing bits.
        while (l < r) {
            l >>= 1;
            r >>= 1;
            shift++;
        }

        // Left shift back to get the answer in original place
        return l << shift;
    }
    public static void main(String[] args)
    {
        ANDInRange obj = new ANDInRange();
        int l = 8;
        int r = 13;
        System.out.println(obj.andInRange(l, r));
        // Output: 8
        // Explanation: 8 & 9 & 10 & 11 & 12 & 13 = 8

    }
}
