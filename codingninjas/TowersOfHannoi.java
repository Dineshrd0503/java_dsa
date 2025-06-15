package codingninjas;

import java.util.ArrayList;

/*
 * Problem Statement:
 * Given an integer n representing the number of disks in the Tower of Hanoi problem,
 * return the sequence of moves to transfer all disks from rod 1 (source) to rod 3 (destination),
 * using rod 2 as auxiliary. Each move is represented as [fromRod, toRod], where fromRod and toRod
 * are integers (1, 2, or 3) indicating the source and destination rods.
 * Rules:
 * - Only one disk can be moved at a time.
 * - A larger disk cannot be placed on a smaller disk.
 *
 * Constraints:
 * - 1 ≤ n ≤ 20 (assumed, as 2^n - 1 moves grow exponentially)
 * - Output: List of 2^n - 1 moves, each as [fromRod, toRod]
 *
 * Example:
 * Input: n = 2
 * Output: [[1,2], [1,3], [2,3]]
 * Explanation:
 * - Move disk 1 from rod 1 to rod 2.
 * - Move disk 2 from rod 1 to rod 3.
 * - Move disk 1 from rod 2 to rod 3.
 */
public class TowersOfHannoi {
    /*
     * Returns the sequence of moves to solve Tower of Hanoi for n disks.
     * @param n Number of disks
     * @return ArrayList of moves, each move as [fromRod, toRod]
     */
    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Start recursion with rods 1 (source), 2 (auxiliary), 3 (destination)
        solve(n, 1, 2, 3, result);
        return result;
    }

    /*
     * Recursive helper to generate moves for n disks from source to destination using auxiliary.
     * @param n Number of disks
     * @param source Source rod (1, 2, or 3)
     * @param auxiliary Auxiliary rod
     * @param destination Destination rod
     * @param result List to store moves
     */
    private static void solve(int n, int source, int auxiliary, int destination,
                              ArrayList<ArrayList<Integer>> result) {
        // Base case: For 1 disk, move directly from source to destination
        if (n == 1) {
            ArrayList<Integer> move = new ArrayList<>();
            move.add(source);
            move.add(destination);
            result.add(move);
            return;
        }

        // Step 1: Move n-1 disks from source to auxiliary, using destination
        solve(n - 1, source, destination, auxiliary, result);

        // Step 2: Move nth disk from source to destination
        ArrayList<Integer> move = new ArrayList<>();
        move.add(source);
        move.add(destination);
        result.add(move);

        // Step 3: Move n-1 disks from auxiliary to destination, using source
        solve(n - 1, auxiliary, source, destination, result);
    }

    /*
     * Main method to test towerOfHanoi with static inputs.
     * Tests n = 1, n = 2, and n = 3 to cover base and recursive cases.
     */
    public static void main(String[] args) {
        // Test Case 1: n = 1
        System.out.println("Test Case 1: n = 1");
        ArrayList<ArrayList<Integer>> result1 = towerOfHanoi(1);
        System.out.println("Output: " + result1); // Expected: [[1,3]]

        // Test Case 2: n = 2
        System.out.println("\nTest Case 2: n = 2");
        ArrayList<ArrayList<Integer>> result2 = towerOfHanoi(2);
        System.out.println("Output: " + result2); // Expected: [[1,2], [1,3], [2,3]]

        // Test Case 3: n = 3
        System.out.println("\nTest Case 3: n = 3");
        ArrayList<ArrayList<Integer>> result3 = towerOfHanoi(3);
        System.out.println("Output: " + result3);
        // Expected: [[1,2], [1,3], [2,3], [1,2], [3,1], [3,2], [1,2]]
    }
}