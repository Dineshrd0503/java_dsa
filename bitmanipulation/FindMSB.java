package bitmanipulation;

import java.util.*;

/*
    Problem: Find MSB in O(1)

    Given an integer N, find the value of the most significant set bit (MSB) of N.
    The MSB is the largest power of 2 that is less than or equal to N.

    In other words, return the maximum integer X such that:
        - X is a power of 2
        - X <= N

    Examples:
        N = 10  (binary: 1010)  -> answer = 8
        N = 18  (binary: 10010) -> answer = 16
        N = 1   (binary: 1)     -> answer = 1
        N = 0   -> answer = 0  (if the problem allows 0 as input)

    Constraint: Time complexity must be O(1).
*/

public class FindMSB {

    // Returns the value of the most significant set bit of n.
    // Uses built-in Java method: Integer.highestOneBit(n).
    public static int findMSB(int n) {
        return Integer.highestOneBit(n);
    }

    public static void main(String[] args) {
        // Static test cases
        int[] tests = {0, 1, 2, 3, 5, 10, 18, 31, 32};

        for (int n : tests) {
            int ans = findMSB(n);
            System.out.println("N = " + n + " -> MSB = " + ans);
        }

        // If you want to take input from console (like Code360 custom input),
        // you can uncomment this block:

        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findMSB(n));
        */
    }
}
