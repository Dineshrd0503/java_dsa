package arrays;

import java.util.Arrays;

/**
 * Solution to assign mice to holes to minimize the maximum distance traveled.
 * Problem: Given two arrays mices and holes of equal length n, where mices[i] is the position of the i-th mouse
 * and holes[i] is the position of the i-th hole on a number line, assign each mouse to a unique hole such that
 * the maximum distance any mouse travels (|mices[i] - holes[i]|) is minimized. Return this maximum distance.
 *
 * Sample Test Cases:
 * 1. mices = [1, 4, 9, 15], holes = [10, -5, 0, 16]
 *    - Sorted mices: [-5, 0, 10, 16]
 *    - Sorted holes: [1, 4, 9, 15]
 *    - Pairs: (-5-1), (0-4), (10-9), (16-15)
 *    - Distances: 6, 4, 1, 1
 *    - Output: 6 (maximum distance)
 * 2. mices = [-2, 1], holes = [1, -2]
 *    - Sorted: mices = [-2, 1], holes = [-2, 1]
 *    - Distances: |(-2)-(-2)| = 0, |1-1| = 0
 *    - Output: 0
 * 3. mices = [3], holes = [5]
 *    - Distance: |3-5| = 2
 *    - Output: 2
 * 4. mices = [], holes = []
 *    - Output: 0 (edge case, no mice/holes)
 */
public class AssignMiceToHoles {
    /**
     * Assigns mice to holes to minimize the maximum distance traveled.
     *
     * @param mices Array of mouse positions.
     * @param holes Array of hole positions.
     * @return The maximum distance any mouse travels to its assigned hole.
     * @throws IllegalArgumentException if arrays are null or have different lengths.
     */
    public int assignHole(int[] mices, int[] holes) {
        // Input validation
        if (mices == null || holes == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        if (mices.length != holes.length) {
            throw new IllegalArgumentException("Mice and holes arrays must have the same length");
        }

        int n = mices.length;
        // Handle empty arrays
        if (n == 0) {
            return 0;
        }

        // Sort arrays to align mice and holes optimally
        Arrays.sort(mices);
        Arrays.sort(holes);

        // Find maximum absolute difference
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            maxDistance = Math.max(maxDistance, Math.abs(mices[i] - holes[i]));
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        AssignMiceToHoles solution = new AssignMiceToHoles();

        // Static test cases
        int[][] miceTests = {
                {1, 4, 9, 15},    // Test case 1
                {-2, 1},          // Test case 2
                {3},              // Test case 3
                {},               // Test case 4
        };
        int[][] holeTests = {
                {10, -5, 0, 16},  // Test case 1
                {1, -2},          // Test case 2
                {5},              // Test case 3
                {},               // Test case 4
        };

        for (int i = 0; i < miceTests.length; i++) {
            try {
                int result = solution.assignHole(miceTests[i], holeTests[i]);
                System.out.println("Test Case " + (i + 1) + ":");
                System.out.println("Mice: " + Arrays.toString(miceTests[i]));
                System.out.println("Holes: " + Arrays.toString(holeTests[i]));
                System.out.println("Maximum Distance: " + result);
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Error in Test Case " + (i + 1) + ": " + e.getMessage());
            }
        }
    }
}