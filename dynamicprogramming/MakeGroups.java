package dynamicprogramming;

import java.util.Arrays;

public class MakeGroups {

    public static int findTwoGroups(int n) {
        // Calculate the total sum of numbers from 1 to N
        int total = (n * (n + 1)) / 2;
        // If total is even, return 0; if odd, return 1
        return (total % 2 == 0) ? 0 : 1;
    }

    public static void main(String[] args) {
        // Sample Inputs
        int[] testCases = {4, 2, 5}; // You can modify these cases

        // Output the results for each test case
        for (int n : testCases) {
            int result = findTwoGroups(n);
            System.out.println("Minimum absolute difference for N = " + n + " is: " + result);
        }
    }

    /*
    Problem statement:
    Given a positive integer 'N', divide numbers from 1 to 'N' into two groups
    such that the absolute difference of sum of each group is minimum and print
    the absolute difference.

    Example:
    If 'N' : 3
    Then the two groups can be : {3} and {2, 1}
    The absolute difference of sum between above two groups is : 0

    Detailed explanation (Input/output format, Notes, Images):

    Input Format:
    The first line of input contains an integer 'T' representing the number of test cases.
    The test cases follow:
    Each test case contains a single integer 'N'.

    Output Format:
    For each test case, print the minimum absolute difference of sum of each group.

    Note:
    You do not need to print anything; it has already been taken care of. Just implement
    the given function.

    Constraints:
    1 <= T <= 100
    2 <= N <= 10^4

    Time Limit: 1 sec

    Sample Input 1:
    2
    4
    2

    Sample Output 1:
    0
    1

    Explanation For Sample Input 1:
    For the first test case,
    First group can be {1, 4}, sum of first group is: 4 + 1 = 5
    Second group can be {2, 3}, sum of second group is: 3 + 2 = 5
    Minimum absolute difference: |5 - 5| = 0

    For the second test case,
    First group can be {1}, sum of first group is: 1
    Second group can be {2}, sum of second group is: 2
    Minimum absolute difference: |1 - 2| = 1

    Sample Input 2:
    1
    5

    Sample Output 2:
    1

    Explanation For Sample Input 2:
    First group can be {2, 5}, sum of first group is: 5 + 2 = 7
    Second group can be {1, 3, 4}, sum of second group is: 4 + 3 + 1 = 8
    Minimum absolute difference: |7 - 8| = 1
    */
}