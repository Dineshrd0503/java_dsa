package arrays;

/*
Problem Statement:
You are given a matrix ARR of N rows and M columns representing the skill levels of ninjas.
A 'Chunin Ninja' is defined as an element in the matrix that is:
    1. The maximum value in its column
    2. The minimum value in its row
Find and print all such 'Chunin Ninja' values.

Sample Input:
N = 3, M = 3
ARR = [
    [3, 4, 5],
    [2, 7, 6],
    [1, 2, 4]
]

Sample Output:
3

Explanation:
- Minimums of each row: [3, 2, 1]
- Maximums of each column: [3, 7, 6]
- Only 3, at position (0,0), is both minimum in its row and maximum in its column.

Additional Test Case:
N = 2, M = 3
ARR = [
    [8, 1, 9],
    [3, 1, 7]
]

Output:
No Chunin Ninja elements

*/

import java.util.*;

public class ChuninNinja {

    public static List<Integer> findChuninNinjas(int[][] ARR, int N, int M) {
        // Find row minimums
        int[] rowMin = new int[N];
        Arrays.fill(rowMin, Integer.MAX_VALUE);

        // Find column maximums
        int[] colMax = new int[M];
        Arrays.fill(colMax, Integer.MIN_VALUE);

        // Calculate rowMin and colMax
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rowMin[i] = Math.min(rowMin[i], ARR[i][j]);
                colMax[j] = Math.max(colMax[j], ARR[i][j]);
            }
        }

        List<Integer> chuninNinjas = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ARR[i][j] == rowMin[i] && ARR[i][j] == colMax[j]) {
                    chuninNinjas.add(ARR[i][j]);
                }
            }
        }
        return chuninNinjas;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int N1 = 3, M1 = 3;
        int[][] ARR1 = {
                {3, 4, 5},
                {2, 7, 6},
                {1, 2, 4}
        };
        List<Integer> result1 = findChuninNinjas(ARR1, N1, M1);
        System.out.print("Output for Test Case 1: ");
        if (result1.isEmpty()) {
            System.out.println("No Chunin Ninja elements");
        } else {
            for (int val : result1) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // Sample Test Case 2
        int N2 = 2, M2 = 3;
        int[][] ARR2 = {
                {8, 1, 9},
                {3, 1, 7}
        };
        List<Integer> result2 = findChuninNinjas(ARR2, N2, M2);
        System.out.print("Output for Test Case 2: ");
        if (result2.isEmpty()) {
            System.out.println("No Chunin Ninja elements");
        } else {
            for (int val : result2) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

