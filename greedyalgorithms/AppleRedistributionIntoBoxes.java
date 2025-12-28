package greedyalgorithms;

/**
 * Problem: 3074. Apple Redistribution into Boxes (LeetCode - Easy)
 *
 * Description:
 * You are given an array 'apple' of size 'n' and an array 'capacity' of size 'm'.
 *
 * There are n packs where the i-th pack contains apple[i] apples.
 * There are m boxes as well, and the i-th box has a capacity of capacity[i] apples.
 *
 * Return the MINIMUM number of boxes you need to select to redistribute these n packs
 * of apples into boxes.
 *
 * Note that apples from the same pack can be distributed into different boxes.
 *
 * Constraints:
 * - 1 <= n == apple.length <= 50
 * - 1 <= m == capacity.length <= 50
 * - 1 <= apple[i], capacity[i] <= 50
 * - The input is generated such that it's possible to redistribute packs into boxes.
 *
 * Approach:
 * 1. Calculate total apples from all packs
 * 2. Sort capacity array in descending order (greedy approach - use largest boxes first)
 * 3. Iterate through sorted capacity and accumulate total capacity
 * 4. Return count of boxes when total capacity >= total apples
 */

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {

    public static int minimumBoxes(int[] apple, int[] capacity) {
        // Step 1: Calculate total apples needed
        int totalApples = 0;
        for (int ap : apple) {
            totalApples += ap;
        }

        // Step 2: Convert to Integer[] to use Comparator.reverseOrder()
        Integer[] cap = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            cap[i] = capacity[i];
        }

        // Step 3: Sort capacity in descending order (largest first)
        Arrays.sort(cap, (a, b) -> b - a);  // Or use: Arrays.sort(cap, Collections.reverseOrder());

        // Step 4: Greedily select boxes until total capacity >= total apples
        int totalCapacity = 0;
        for (int i = 0; i < cap.length; i++) {
            totalCapacity += cap[i];
            if (totalCapacity >= totalApples) {
                return i + 1;  // Return number of boxes used (i+1 because indexing starts at 0)
            }
        }

        return cap.length;  // Return all boxes if needed
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] apple1 = {1, 3, 2};
        int[] capacity1 = {4, 3, 1, 5, 2};
        System.out.println("Test Case 1:");
        System.out.println("Input: apple = [1, 3, 2], capacity = [4, 3, 1, 5, 2]");
        System.out.println("Output: " + minimumBoxes(apple1, capacity1));
        System.out.println("Expected: 2");
        System.out.println("Explanation: Total apples = 6. Use boxes with capacities 5 and 4. Total = 9 >= 6");
        System.out.println();

        // Test Case 2
        int[] apple2 = {5, 5, 5};
        int[] capacity2 = {2, 4, 2, 7};
        System.out.println("Test Case 2:");
        System.out.println("Input: apple = [5, 5, 5], capacity = [2, 4, 2, 7]");
        System.out.println("Output: " + minimumBoxes(apple2, capacity2));
        System.out.println("Expected: 4");
        System.out.println("Explanation: Total apples = 15. Need all boxes (7+4+2+2 = 15)");
        System.out.println();

        // Test Case 3
        int[] apple3 = {1, 8, 3, 3, 5};
        int[] capacity3 = {3, 9, 5, 1, 9};
        System.out.println("Test Case 3:");
        System.out.println("Input: apple = [1, 8, 3, 3, 5], capacity = [3, 9, 5, 1, 9]");
        System.out.println("Output: " + minimumBoxes(apple3, capacity3));
        System.out.println("Expected: 3");
        System.out.println("Explanation: Total apples = 20. Sorted capacity desc: [9, 9, 5, 3, 1]. Use 9+9+5 = 23 >= 20");
        System.out.println();

        // Test Case 4
        int[] apple4 = {10};
        int[] capacity4 = {5, 5};
        System.out.println("Test Case 4:");
        System.out.println("Input: apple = [10], capacity = [5, 5]");
        System.out.println("Output: " + minimumBoxes(apple4, capacity4));
        System.out.println("Expected: 2");
        System.out.println("Explanation: Total apples = 10. Need both boxes (5+5 = 10)");
    }
}
