package arrays;
import java.util.*;
import java.io.*;
import java.util.Vector;

public class MaxInColMinInRow {

    /**
     * Problem statement:
     * You are the Supreme Ninja Warrior on a visit to Ninja Class, and class can be represented as a rectangular matrix ‘ARR’ of ‘N’ rows and ‘M’ columns.
     *
     * Each Ninja has a skill level, and each element in matrix ‘ARR’ represents the skill level of the Ninja present in the class.
     * More formally, ‘ARR[i][j]’ represents the skill level of Ninja sitting in the ‘jth’ column of the ‘ith’ row.
     *
     * A ninja is said to be ‘Chunin’ if he has maximum skill among all Ninjas in his column and minimum skill level among all Ninjas in his row.
     *
     * Can you find all the ‘Chunin’ Ninjas present in the class?
     *
     * Example :
     * N = 3 M = 3
     * ARR = [ [3, 4, 5], [2, 7, 6] , [1, 2, 4] ]
     *
     * Ninja at Position (0,0) has maximum skill in ‘0th’ column and minimum skill in ‘0th’ row, it is the only Chunin Ninja.
     * So, we return [ 3 ] as our ‘ANS’.
     *
     * Input Format :
     *
     * The first line contains an integer ‘T’ denoting the number of test cases. Then each test case follows.
     *
     * The first input line of each test case contains two integers, ‘N’ and ‘M’, denoting the number of rows and columns in the matrix ‘ARR’, respectively.
     *
     * Each of the following for each test case. Print ‘N’ lines contain ‘M’ space-separated integers denoting the skill level of Ninjas.
     *
     *
     * Output format :
     *
     * For each test case, print all ‘Chunin’ Ninja present in the class. Print the output of each test case in a new line.
     *
     *
     * Note :
     *
     * You don’t need to print anything. It has already been taken care of. Just implement the given function.
     *
     *
     * Constraints :
     *
     * 1 <= T <= 10
     * 1 <= N , M <= 10^5
     * 0 <= ARR[i][j] <= 10^9
     * Sum of N*M over all Test cases <= 10^5
     *
     * Time Limit: 1 sec
     *
     *
     * Sample Input 1 :
     * 2
     * 2 2
     * 3 4
     * 2 5
     * 2 3
     * 3 4 5
     * 4 5 6
     *
     *
     * Sample Output 1 :
     * 3
     * 4
     *
     *
     * Explanation Of Sample Input 1 :
     *
     * For test case 1,
     * With skill level '3' at position (0,0), the Ninja is the only 'Chunin' Ninja as it has maximum skill level in its column and minimum skill level in its row.
     *
     * For test case 2,
     * With skill level '4' at position (1,0), the Ninja is the only 'Chunin' Ninja as it has maximum skill level in its column and minimum skill level in its row.
     *
     *
     * Sample Input 2 :
     * 1
     * 1 1
     * 1
     *
     *
     * Sample Output 2 :
     *
     * 1
     */

    public static Vector<Integer> chuninNinja(int n, int m, int arr[][]) {
        Vector<Integer> result = new Vector<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isChunin(arr, n, m, i, j)) {
                    result.add(arr[i][j]);
                }
            }
        }

        return result;
    }

    private static boolean isChunin(int[][] arr, int n, int m, int row, int col) {
        // Check if maximum in column
        for (int i = 0; i < n; i++) {
            if (arr[i][col] > arr[row][col]) {
                return false;
            }
        }

        // Check if minimum in row
        for (int j = 0; j < m; j++) {
            if (arr[row][j] < arr[row][col]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of test cases
        int t = scanner.nextInt();

        while (t-- > 0) {
            // Read dimensions of the matrix
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            // Read the matrix elements
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            // Find and print the Chunin Ninjas
            Vector<Integer> result = chuninNinja(n, m, arr);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + (i == result.size() - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}