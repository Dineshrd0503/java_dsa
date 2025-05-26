package arrays;

import java.util.ArrayList;

public class FindPalindromes {

    // Method to find all palindromic numbers from 1 to n
    public static int[] getPalindromes(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (isPalindrome(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    // Helper method to check if a number is palindromic
    private static boolean isPalindrome(int n) {
        int t = n;
        int r = 0;
        while (n > 0) {
            int a = n % 10;
            r = r * 10 + a;
            n /= 10;
        }
        return t == r;
    }

    public static void main(String[] args) {
        // Sample inputs
        int[] testCases = {12, 5, 15, 22};

        // Output the results for each test case
        for (int n : testCases) {
            System.out.print("Palindromes from 1 to " + n + ": ");
            int[] palindromes = getPalindromes(n);
            for (int palindrome : palindromes) {
                System.out.print(palindrome + " ");
            }
            System.out.println(); // For newline after each test case
        }
    }
}

/*
Problem statement
=================

You are given an integer ‘N’. Your task is to find all palindromic numbers from 1 to ‘N’.

Palindromic integers are those integers that read the same backward or forwards.

**Note:**
Order of numbers should be in the non-decreasing manner.

**For example:**
You are given ‘N’ as 12, so the output should be [1, 2, 3, 4, 5, 6, 7, 8, 9, 11], as all single-digit numbers are palindromic, and 11 is also a palindromic number.

Detailed explanation (Input/output format, Notes, Images)
-----------------------------------------------------

**Input Format:**
The first line contains a single integer ‘T’ representing the number of test cases.
The first line of each test case consists of a single integer ‘N’, representing the given integer.

**Output Format:**
For each test case, print all the palindromic integers space-separated from 1 to ‘N’ in increasing order.
Print a separate line for each test case.

**Note:**
You do not need to print anything; it has already been taken care of. Just implement the given function.

**Constraints:**
1 <= T <= 10
1 <= N <= 10^9

**Sample Input 1:**
2
12
5

**Sample Output 1:**
1 2 3 4 5 6 7 8 9 11
1 2 3 4 5

**Explanation:**
For the first test case, all the single-digit numbers are palindromic, and the number 11 is also palindromic.
Hence the output is [1, 2, 3, 4, 5, 6, 7, 8, 9, 11].

For the second test case, N is less than 9. Therefore all the numbers from 1 to N are palindromes.
Hence the output is [1, 2, 3, 4, 5].

**Sample Input 2:**
2
15
22

**Sample Output 2:**
1 2 3 4 5 6 7 8 9 11
 2 3 4 5 6 7 8 9 11 22
*/