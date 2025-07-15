package arrays;

import java.util.*;
import java.io.*;

public class NinjasShikanji{

    /**
     * Ninja's Shikanji Problem:
     *
     * Ninja opened a shikanji’s stall to earn a living f+or him. In his stall, each
     * shikanji drink costs ‘5$’. Customers are standing in the form queue and each
     * customer either pays ‘5$, 10$, 20$ ‘ so now Ninja has to give them change so
     * that each customer exactly pays ‘5$’.
     *
     * So now help the ninja to find out whether he is able to charge exactly ‘5$’
     * from each customer by providing them the change.
     *
     * Your task is to write a code to check whether ninja can provide change to the
     * customer if they paid extra to him. You will be provided with the
     * ‘BILL_ARR’ array denoting the amount paid by each customer you have to return
     * ‘True’ if it is possible else you have to return ‘False’.
     *
     * Example: Suppose given ‘BILL_ARR’ array is { 5, 5, 5, 10, 20 } so we return
     * ‘True’ for this test case as from first ‘3’ customers we take ‘5$’ from each
     * customer then ‘4th’ customer give ‘10$’ we give him ‘5$’ back now we have
     * ‘2’, ‘5$’ note and ‘1’, ‘10$’ note than ‘5th’ customer give ‘20$’ so we give
     * him back one ‘10$’ and one ‘5$’ note.
     *
     * Input Format: The first line of input contains a ‘T’ number of test cases.
     * The first line of each test case contains an integer ‘N’ i.e size of the
     * array ‘BILL_ARR’. The second line of each test case contains an array
     * ‘BILL_ARR’, where ‘BILL_ARR[i]’ denotes the money paid for ‘i-th’ shikanji.
     *
     * Output Format: For each test case, print ‘True’ if it is possible else print
     * ‘False’.
     *
     * Note: 1. You don’t have any changes at starting. 2. You are not required to
     * print anything explicitly. It has already been taken care of. Just implement
     * the function.
     *
     * Constraints: 1 <= T <= 10^2 1 <= N <= 10^3 BILL_ARR[i] = [ ‘5’, ‘10’, ‘20’ ]
     *
     * Where ‘T’ represents the number of test cases and ‘N’ represents the size of
     * the array and ‘BILL_ARR[i]’ represents the elements of the array.
     *
     * Time Limit: 1 sec
     */
    public static boolean ninjaShikanji(ArrayList<Integer> bill, int n) {
        // Write your code here.
        int fives = 0, tens = 0;
        for (int a : bill) {
            if (a == 5)
                fives++;
            else if (a == 10) {
                if (fives > 0) {
                    fives--;
                    tens++;
                } else
                    return false;
            } else { // a == 20
                if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                } else if (fives >= 3)
                    fives -= 3;
                else
                    return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        // Sample Test Cases (from the problem description)

        // Test Case 1: Sample Input 1
        // Input: 2
        //        5
        //        5 10 5 20 5
        //        4
        //        5 20 5 10
        // Output:
        // True
        // False
        ArrayList<Integer> bill1 = new ArrayList<>(Arrays.asList(5, 10, 5, 20, 5));
        System.out.println("Test Case 1: " + ninjaShikanji(bill1, bill1.size())); // Expected Output: True

        ArrayList<Integer> bill2 = new ArrayList<>(Arrays.asList(5, 20, 5, 10));
        System.out.println("Test Case 2: " + ninjaShikanji(bill2, bill2.size())); // Expected Output: False

        // Test Case 3: Sample Input 2
        // Input:
        // 2
        // 3
        // 5 10 20
        // 7
        // 5 5 10 5 5 20 10
        // Output:
        // False
        // True

        ArrayList<Integer> bill3 = new ArrayList<>(Arrays.asList(5, 10, 20));
        System.out.println("Test Case 3: " + ninjaShikanji(bill3, bill3.size())); // Expected Output: False

        ArrayList<Integer> bill4 = new ArrayList<>(Arrays.asList(5, 5, 10, 5, 5, 20, 10));
        System.out.println("Test Case 4: " + ninjaShikanji(bill4, bill4.size())); // Expected Output: True

        // Additional Test Cases:

        // Test Case 5: Only 5s
        ArrayList<Integer> bill5 = new ArrayList<>(Arrays.asList(5, 5, 5, 5));
        System.out.println("Test Case 5: " + ninjaShikanji(bill5, bill5.size())); // Expected Output: True

        // Test Case 6: Only 10s (should fail)
        ArrayList<Integer> bill6 = new ArrayList<>(Arrays.asList(10, 10, 10));
        System.out.println("Test Case 6: " + ninjaShikanji(bill6, bill6.size())); // Expected Output: False

        // Test Case 7: Only 20s (should fail)
        ArrayList<Integer> bill7 = new ArrayList<>(Arrays.asList(20, 20, 20));
        System.out.println("Test Case 7: " + ninjaShikanji(bill7, bill7.size())); // Expected Output: False

        // Test Case 8: Mix of 5, 10, 20 (complex case - needs both 5s and 10s for
        // change)
        ArrayList<Integer> bill8 = new ArrayList<>(Arrays.asList(5, 5, 10, 20, 5, 5, 5, 10, 20));
        System.out.println("Test Case 8: " + ninjaShikanji(bill8, bill8.size())); // Expected Output: True
    }
}
