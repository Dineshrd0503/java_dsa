package arrays;

import java.util.*;
import java.io.*;

/*
Problem statement
-----------------

Ayush is given a number ‘X’. He has been told that he has to find the first ‘X’ terms of the series 3 * ‘N’ + 2, which are not multiples of 4. Help Ayush to find it as he has not been able to answer.

Example: Given an ‘X’ = 4. The output array/list which must be passed to Ayush will be [ 5, 11, 14, 17 ].

Detailed explanation ( Input/output format, Notes, Images )

Input Format:

    The first line contains a single integer ‘T’ representing the number of test cases.

    The first line of each test case will contain one integer, ‘X’ that denotes the number of terms he has to answer.


Output Format:

    For each test case, return a vector with the first ‘X’ integer of the series 3 * ‘N’ + 2, which is not multiple of 4.

    Output for every test case will be printed in a separate line.


Note:

    You don’t need to print anything; It has already been taken care of.


Constraints:

    1 <= T <= 10^2
    1 <= X <= 10^5

    Time Limit: 1 sec


##### Sample Input 1:

    2
    2
    5


##### Sample Output 1:

    5 11
    5 11 14 17 23


##### Explanation For Sample Input 1:

    In the first test case, the first number is 5, while the second number cannot be 8 as it is divisible by 4, and so, the next number is directly 11 as it is not divisible by 4.

    In the second test case, the first two numbers are 5 and 11. While following three numbers are 14, 17 and 23 for ‘N’ = 4, 5 and 7 respectively. 20 is divisible by 4, and thus, 20 cannot be included in the list.


##### Sample Input 2:

    2
    7
    8


##### Sample Output 2:

    5 11 14 17 23 26 29
    5 11 14 17 23 26 29 35
*/


public class TermsofAP {

    public static int[] termsOfAP(int x) {
        // Write your code here.
        int count = 0, n = 1;
        int[] result = new int[x];
        while (count < x) {
            int term = (3 * n) + 2;
            if (term % 4 != 0) {
                result[count] = term;
                count++;
            }
            n++;
        }
        return result;
    }

    public static void main(String[] args) {
        // Static inputs for testing
        int[] testCases = {2, 5, 7, 8}; // Define static test cases here, each value denotes x in termsOFAp()

        // Process each test case and print the output
        for (int x : testCases) {
            int[] result = termsOfAP(x);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println(); // Move to the next line after printing the results for one test case

        }
    }
}