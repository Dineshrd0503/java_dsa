package arrays;

import java.util.*;

public class LastMomentBeforeAllAntsFallOut
{

    /**
     * Problem Statement:
     * We have a wooden plank of length n units. Some ants are walking on the plank,
     * each ant moves with a speed of 1 unit per second, with some moving left and others right.
     * When two ants moving in two different directions meet at some point, they change their directions
     * and continue moving again. Assume changing directions does not take any additional time.
     * When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.
     * Given an integer n and two integer arrays left[] and right[], the positions of the ants
     * moving to the left and the right, return the time when the last ant(s) fall out of the plank.
     *
     * Constraints:
     * 1 <= n <= 10^5
     * 0 <= left.length, right.length <= n + 1
     * 0 <= left[i], right[i] <= n
     * 1 <= left.length + right.length <= n + 1
     * All values of left and right are unique, and each value can appear only in one of the two arrays.
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        // The core insight is that when two ants meet and change directions,
        // it's equivalent to them passing through each other without changing direction.
        // Since all ants move at the same speed (1 unit/second) and changing directions
        // takes no time, the time it takes for an ant to fall off the plank is
        // independent of collisions. We only care about the time it takes for any
        // *initial* position to reach an end.

        // Initialize max time for ants moving left to 0.
        // An ant at position 'p' moving left will take 'p' seconds to fall off the plank (reach position 0).
        int maxTimeLeft = 0;
        for (int pos : left) {
            maxTimeLeft = Math.max(maxTimeLeft, pos);
        }

        // Initialize max time for ants moving right to 0.
        // An ant at position 'p' moving right will take 'n - p' seconds to fall off the plank (reach position n).
        int maxTimeRight = 0;
        for (int pos : right) {
            maxTimeRight = Math.max(maxTimeRight, n - pos);
        }

        // The time when the last ant falls off is the maximum of the times
        // calculated for ants moving left and ants moving right.
        return Math.max(maxTimeLeft, maxTimeRight);
    }

    public static void main(String[] args) {
        LastMomentBeforeAllAntsFallOut solver = new LastMomentBeforeAllAntsFallOut();

        // Sample Test Cases:

        // Example 1
        // Input: n = 4, left[] = [2], right[] = [0, 1, 3]
        // Output: 4
        // Explanation: As seen in the above image, the last ant falls off the plank at t = 4.
        int n1 = 4;
        int[] left1 = {2};
        int[] right1 = {0, 1, 3};
        System.out.println("Input: n = " + n1 + ", left = " + Arrays.toString(left1) + ", right = " + Arrays.toString(right1));
        System.out.println("Output: " + solver.getLastMoment(n1, left1, right1)); // Expected: 4
        System.out.println("--------------------");

        // Example 2
        // Input: n = 4, left[] = [], right[] = [0, 1, 2, 3, 4]
        // Output: 4
        // Explanation: All ants are going to the right, the ant at index 0 needs 4 seconds to fall.
        int n2 = 4;
        int[] left2 = {};
        int[] right2 = {0, 1, 2, 3, 4};
        System.out.println("Input: n = " + n2 + ", left = " + Arrays.toString(left2) + ", right = " + Arrays.toString(right2));
        System.out.println("Output: " + solver.getLastMoment(n2, left2, right2)); // Expected: 4
        System.out.println("--------------------");

        // Example 3
        // Input: n = 3, left[] = [0], right[] = [3]
        // Output: 0
        // Explanation: The ants will fall off the plank as they are already on the end of the plank.
        int n3 = 3;
        int[] left3 = {0};
        int[] right3 = {3};
        System.out.println("Input: n = " + n3 + ", left = " + Arrays.toString(left3) + ", right = " + Arrays.toString(right3));
        System.out.println("Output: " + solver.getLastMoment(n3, left3, right3)); // Expected: 0
        System.out.println("--------------------");

        // Custom Test Case 1: Ants moving in both directions, one from each end
        // Input: n = 10, left[] = [7], right[] = [3]
        // Output: 7 (Ant at 7 moving left takes 7s, ant at 3 moving right takes 10-3=7s)
        int n4 = 10;
        int[] left4 = {7};
        int[] right4 = {3};
        System.out.println("Input: n = " + n4 + ", left = " + Arrays.toString(left4) + ", right = " + Arrays.toString(right4));
        System.out.println("Output: " + solver.getLastMoment(n4, left4, right4)); // Expected: 7
        System.out.println("--------------------");

        // Custom Test Case 2: Many ants, scattered
        // Input: n = 7, left[] = [1, 5], right[] = [2, 6]
        // Output: 6
        // Left: max(1, 5) = 5
        // Right: max(7-2, 7-6) = max(5, 1) = 5
        // Overall max = 5
        int n5 = 7;
        int[] left5 = {1, 5};
        int[] right5 = {2, 6};
        System.out.println("Input: n = " + n5 + ", left = " + Arrays.toString(left5) + ", right = " + Arrays.toString(right5));
        System.out.println("Output: " + solver.getLastMoment(n5, left5, right5)); // Expected: 6
        System.out.println("--------------------");
    }
}

