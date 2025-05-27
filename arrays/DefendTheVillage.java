package arrays;

import java.util.*;

public class DefendTheVillage {

    /**
     * Defend The Village
     *
     * Problem Statement:
     * You are given an array/list of positive integers ‘HOUSES’ that represents the positions of
     * 'N' different houses in Ninja’s village on a horizontal line. There is an attack by the enemy
     * that a group of 'M' Ninjas positioned at different houses can stop as long as the houses are
     * within their radius range. The positions of these 'M' Ninjas are given in an array/list 'NINJAS'.
     *
     * Your task is to return the minimum radius standard of the defender Ninjas so that those
     * Ninjas could defend all houses in 'HOUSES' array.
     *
     * Input Format:
     * - The first line of input contains a single integer ‘T’ denoting the number of test cases given.
     * - For each test case:
     *   - The first line contains two space-separated integers, where the first integer 'N' represents
     *     the length of the ‘HOUSES’ array and the second integer 'M' represents the length of ‘NINJAS' array.
     *   - The second line contains ‘N’ space-separated integers which are the elements of the
     *     position of houses (‘HOUSES’) array.
     *   - The third line contains ‘M’ space-separated integers which are the elements of the
     *     position of Ninjas (‘NINJAS’) array.
     *
     * Output Format:
     * - For every test case, print an integer denoting the minimum radius standard of
     *   (‘NINJAS’) Ninjas so that those Ninjas could defend all houses.
     *
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N, M <= 3 * 10^3
     * 1 <= HOUSES[i], NINJAS[i] <= 10^9
     *
     * Sample Input:
     * 2
     * 4 2
     * 1 2 3 4
     * 1 4
     * 2 1
     * 1 5
     * 2
     *
     * Sample Output:
     * 1
     * 3
     */

    public static int findMinimumRadiusRange(int[] houses, int[] ninjas, int n, int m) {
        int minRadius = 0; // This will hold our result

        // For each house, determine the minimum distance to any ninja
        for (int house : houses) {
            int minDistance = Integer.MAX_VALUE; // Start with a large number

            // Calculate distance from this house to each ninja
            for (int ninja : ninjas) {
                int distance = Math.abs(house - ninja);
                if (distance < minDistance) {
                    minDistance = distance; // Update the minimum distance for this house
                }
            }

            // We want the maximum of these minimum distances
            minRadius = Math.max(minRadius, minDistance);
        }

        return minRadius;
    }

    public static void main(String[] args) {
        // Sample test cases
        int T = 2; // Number of test cases
        int[][] housesArray = {
                {1, 2, 3, 4}, // Test case 1 houses
                {1, 5}        // Test case 2 houses
        };
        int[][] ninjasArray = {
                {1, 4}, // Test case 1 ninjas
                {2}      // Test case 2 ninjas
        };

        for (int i = 0; i < T; i++) {
            int[] houses = housesArray[i];
            int[] ninjas = ninjasArray[i];
            int result = findMinimumRadiusRange(houses, ninjas, houses.length, ninjas.length);
            System.out.println(result);
        }
    }
}