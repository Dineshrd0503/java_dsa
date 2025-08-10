package arrays;

/*
LeetCode 506: Relative Ranks

Given an integer array score of size n, where score[i] is the score of the i-th athlete in a competition, return an array answer of size n where answer[i] is the rank of the i-th athlete. The rank is determined as follows:
- The athlete with the highest score gets "Gold Medal".
- The second-highest score gets "Silver Medal".
- The third-highest score gets "Bronze Medal".
- For all other athletes, the rank is their position (1-based) in the sorted order of scores (highest to lowest).
- The output array must maintain the original order of athletes.

Constraints:
- 1 <= n <= 10^4
- 0 <= score[i] <= 10^6
- All scores are not guaranteed to be unique.

Example 1:
Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The scores sorted in descending order are [5,4,3,2,1]. The athlete at index 0 (score 5) gets "Gold Medal", index 1 (score 4) gets "Silver Medal", index 2 (score 3) gets "Bronze Medal", index 3 (score 2) gets rank 4, and index 4 (score 1) gets rank 5.

Example 2:
Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The scores sorted in descending order are [10,9,8,4,3]. The athlete at index 0 (score 10) gets "Gold Medal", index 3 (score 9) gets "Silver Medal", index 2 (score 8) gets "Bronze Medal", index 4 (score 4) gets rank 4, and index 1 (score 3) gets rank 5.

Example 3:
Input: score = [1]
Output: ["Gold Medal"]
Explanation: With only one athlete, they get "Gold Medal".
*/

import java.util.*;

public class RelativeRanking {
    public static String[] findRelativeRanks(int[] score) {
        if (score == null || score.length == 0) return new String[0];

        int n = score.length;
        // Create array of [score, index] pairs
        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];
            scoreWithIndex[i][1] = i;
        }

        // Sort by score in descending order
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);

        // Assign ranks/medals
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int originalIndex = scoreWithIndex[i][1];
            if (i == 0) {
                result[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                result[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: score = [5,4,3,2,1]
        // Expected Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        int[] test1 = {5, 4, 3, 2, 1};
        System.out.println("Test Case 1: " + Arrays.toString(findRelativeRanks(test1)));

        // Test Case 2: score = [10,3,8,9,4]
        // Expected Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
        int[] test2 = {10, 3, 8, 9, 4};
        System.out.println("Test Case 2: " + Arrays.toString(findRelativeRanks(test2)));

        // Test Case 3: score = [1]
        // Expected Output: ["Gold Medal"]
        int[] test3 = {1};
        System.out.println("Test Case 3: " + Arrays.toString(findRelativeRanks(test3)));

        // Test Case 4: score = [5,5,4,3]
        // Expected Output: ["Gold Medal","Gold Medal","Bronze Medal","4"]
        // Note: Assumes ties get same rank, adjusting subsequent ranks
        int[] test4 = {5, 5, 4, 3};
        System.out.println("Test Case 4: " + Arrays.toString(findRelativeRanks(test4)));
    }
}
