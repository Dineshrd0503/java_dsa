package greedyalgorithms;

import java.util.Arrays;

/**
 * PROBLEM STATEMENT - BUS CONDUCTOR
 *
 * You are conductor of a bus. You are given two arrays chairs[] and passengers[]
 * of equal length, where:
 * - chairs[i] is the position of the i-th chair
 * - passengers[j] is the position of the j-th passenger
 *
 * You may perform the following move any number of times:
 * - Increase or decrease the position of the j-th passenger by 1
 *   (i.e., moving the j-th passenger from position x to x+1 or x-1)
 *
 * TASK: Return the MINIMUM NUMBER OF MOVES required to move each passenger to get a chair.
 *
 * NOTE: Although multiple chairs can occupy the same position, each passenger must
 * be assigned to exactly one unique chair.
 *
 * CONSTRAINTS:
 * - 1 ≤ n ≤ 10^5
 * - 1 ≤ chairs[i], passengers[j] ≤ 10^4
 *
 * TIME COMPLEXITY: O(n log n)
 * SPACE COMPLEXITY: O(1)
 *
 * EXAMPLES:
 *
 * Example 1:
 * Input: chairs[] = [3, 1, 5], passengers[] = [2, 7, 4]
 * Output: 4
 * Explanation: After sorting both arrays:
 *   chairs = [1, 3, 5], passengers = [2, 4, 7]
 *   Passenger 2 moves to chair 1: 1 move
 *   Passenger 4 moves to chair 3: 1 move
 *   Passenger 7 moves to chair 5: 2 moves
 *   Total = 4 moves
 *
 * Example 2:
 * Input: chairs[] = [2, 2, 6, 6], passengers[] = [1, 3, 2, 6]
 * Output: 4
 * Explanation: After sorting both arrays:
 *   chairs = [2, 2, 6, 6], passengers = [1, 2, 3, 6]
 *   Passenger 1 moves to chair 2: 1 move
 *   Passenger 2 moves to chair 2: 0 moves
 *   Passenger 3 moves to chair 6: 3 moves
 *   Passenger 6 moves to chair 6: 0 moves
 *   Total = 4 moves
 */

public class BusConductor {

    // Main solution method
    public long minimumMoves(int[] chairs, int[] passengers) {
        // Sort both arrays in ascending order
        Arrays.sort(chairs);
        Arrays.sort(passengers);

        // Calculate total moves by matching i-th passenger to i-th chair
        long totalMoves = 0;
        for (int i = 0; i < passengers.length; i++) {
            totalMoves += Math.abs(passengers[i] - chairs[i]);
        }

        return totalMoves;
    }

    // Main method with test cases
    public static void main(String[] args) {
        BusConductor bc = new BusConductor();

        System.out.println("===== BUS CONDUCTOR - MINIMUM MOVES =====\n");

        // Test Case 1
        System.out.println("Test Case 1:");
        int[] chairs1 = {3, 1, 5};
        int[] passengers1 = {2, 7, 4};
        long result1 = bc.minimumMoves(chairs1, passengers1);
        System.out.println("Input: chairs = " + Arrays.toString(chairs1) +
                ", passengers = " + Arrays.toString(passengers1));
        System.out.println("Output: " + result1);
        System.out.println("Explanation: After sorting [1,3,5] and [2,4,7]");
        System.out.println("  |2-1| + |4-3| + |7-5| = 1 + 1 + 2 = 4\n");

        // Test Case 2
        System.out.println("Test Case 2:");
        int[] chairs2 = {2, 2, 6, 6};
        int[] passengers2 = {1, 3, 2, 6};
        long result2 = bc.minimumMoves(chairs2, passengers2);
        System.out.println("Input: chairs = " + Arrays.toString(chairs2) +
                ", passengers = " + Arrays.toString(passengers2));
        System.out.println("Output: " + result2);
        System.out.println("Explanation: After sorting [2,2,6,6] and [1,2,3,6]");
        System.out.println("  |1-2| + |2-2| + |3-6| + |6-6| = 1 + 0 + 3 + 0 = 4\n");

        // Test Case 3
        System.out.println("Test Case 3:");
        int[] chairs3 = {1, 2, 3};
        int[] passengers3 = {1, 2, 3};
        long result3 = bc.minimumMoves(chairs3, passengers3);
        System.out.println("Input: chairs = " + Arrays.toString(chairs3) +
                ", passengers = " + Arrays.toString(passengers3));
        System.out.println("Output: " + result3);
        System.out.println("Explanation: All passengers already at chairs");
        System.out.println("  |1-1| + |2-2| + |3-3| = 0 + 0 + 0 = 0\n");

        // Test Case 4
        System.out.println("Test Case 4:");
        int[] chairs4 = {5};
        int[] passengers4 = {2};
        long result4 = bc.minimumMoves(chairs4, passengers4);
        System.out.println("Input: chairs = " + Arrays.toString(chairs4) +
                ", passengers = " + Arrays.toString(passengers4));
        System.out.println("Output: " + result4);
        System.out.println("Explanation: Single passenger");
        System.out.println("  |2-5| = 3\n");

        // Test Case 5
        System.out.println("Test Case 5:");
        int[] chairs5 = {10, 1, 5, 20};
        int[] passengers5 = {15, 2, 6, 8};
        long result5 = bc.minimumMoves(chairs5, passengers5);
        System.out.println("Input: chairs = " + Arrays.toString(chairs5) +
                ", passengers = " + Arrays.toString(passengers5));
        System.out.println("Output: " + result5);
        System.out.println("Explanation: After sorting [1,5,10,20] and [2,6,8,15]");
        System.out.println("  |2-1| + |6-5| + |8-10| + |15-20| = 1 + 1 + 2 + 5 = 9\n");
    }
}
