package stacks;

import java.util.*;
import java.io.*;

/**
 * Problem: Find The Nearest Supporter
 *
 * Problem Statement:
 * There are contestants standing in a row. Each contestant is assigned a rating (integer).
 * A contestant supports all those whose rating is GREATER than their rating.
 *
 * Task: For each contestant in the row, find the rating of their CLOSEST SUPPORTER on the LEFT.
 *       A supporter must have a LOWER rating than the current contestant.
 *       If no supporter exists on the left, store -1.
 *
 * Example: [3, 1, 5, 12, 10]
 * - Index 1 (3): No one on left → -1
 * - Index 2 (1): 3 is not a supporter (3 > 1) → -1
 * - Index 3 (5): Both 3 and 1 are supporters, but 1 is closest → 1
 * - Index 4 (12): 5 is closest supporter (3,1 are smaller but farther) → 5
 * - Index 5 (10): 5 is closest supporter (12 is not) → 5
 * Output: [-1, -1, 1, 5, 5]
 *
 * Time Complexity: O(n) - Each element pushed/popped once
 * Space Complexity: O(n) - For stack and result array
 *
 * Approach: Use a STACK to maintain indices
 * - Stack stores indices in increasing order of their values
 * - When we encounter a larger element, pop smaller elements (they become irrelevant)
 * - Top of stack is always the nearest smaller element
 */

public class FindTheNearestSupporter {

    /**
     * Method to find the previous smaller element (nearest supporter) for each element
     *
     * @param arr - ArrayList of integers containing ratings
     * @param n - Number of elements
     * @return ArrayList containing the rating of nearest supporter or -1
     */
    public static ArrayList<Integer> prevSmall(ArrayList<Integer> arr, int n) {
        // Create result ArrayList to store nearest smaller elements
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Create a stack to store indices of elements
        Stack<Integer> stack = new Stack<Integer>();

        // Process each element from left to right
        for (int i = 0; i < n; i++) {
            // Step 1: Remove elements from stack that are >= current element
            // These elements cannot be supporters of current or future elements
            while (!stack.isEmpty() && arr.get(stack.peek()) >= arr.get(i)) {
                stack.pop();
            }

            // Step 2: Check if stack is empty
            if (stack.isEmpty()) {
                // No supporter found on the left
                result.add(-1);
            } else {
                // Top of stack is the nearest smaller element (nearest supporter)
                result.add(arr.get(stack.peek()));
            }

            // Step 3: Push current index onto stack for future comparisons
            stack.push(i);
        }

        return result;
    }

    /**
     * Main method with test cases and input handling
     */
    public static void main(String[] args) {
        // Method 1: Direct test cases with hard-coded data
        System.out.println("=== Test Case 1 ===");
        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(3, 1, 5, 12, 10));
        System.out.println("Input: " + arr1);
        ArrayList<Integer> result1 = prevSmall(arr1, arr1.size());
        System.out.println("Output: " + result1);
        System.out.println("Expected: [-1, -1, 1, 5, 5]\n");

        System.out.println("=== Test Case 2 ===");
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(9, 8, 1, 2, 5, 5));
        System.out.println("Input: " + arr2);
        ArrayList<Integer> result2 = prevSmall(arr2, arr2.size());
        System.out.println("Output: " + result2);
        System.out.println("Expected: [-1, -1, -1, 1, 2, 2]\n");

        System.out.println("=== Test Case 3 ===");
        ArrayList<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 4, 5));
        System.out.println("Input: " + arr3);
        ArrayList<Integer> result3 = prevSmall(arr3, arr3.size());
        System.out.println("Output: " + result3);
        System.out.println("Expected: [-1, -1, -1, 1, 4]\n");

        System.out.println("=== Test Case 4 (Single Element) ===");
        ArrayList<Integer> arr4 = new ArrayList<Integer>(Arrays.asList(5));
        System.out.println("Input: " + arr4);
        ArrayList<Integer> result4 = prevSmall(arr4, arr4.size());
        System.out.println("Output: " + result4);
        System.out.println("Expected: [-1]\n");

        System.out.println("=== Test Case 5 (Negative Numbers) ===");
        ArrayList<Integer> arr5 = new ArrayList<Integer>(Arrays.asList(-5, -2, -8, 3, -1));
        System.out.println("Input: " + arr5);
        ArrayList<Integer> result5 = prevSmall(arr5, arr5.size());
        System.out.println("Output: " + result5);
        System.out.println("Expected: [-1, -5, -1, -8, -2]\n");

        // Method 2: Interactive input from Scanner (for real competitive programming)
        System.out.println("\n=== Interactive Mode (Scanner Input) ===");
        interactiveMode();
    }

    /**
     * Interactive mode to take input from user via Scanner
     * This is how it would work in actual competitive programming
     */
    public static void interactiveMode() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter number of elements (n): ");
            int n = sc.nextInt();

            // Create ArrayList and read elements
            ArrayList<Integer> arr = new ArrayList<Integer>();
            System.out.print("Enter " + n + " elements: ");
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            // Call solution method
            ArrayList<Integer> result = prevSmall(arr, n);

            // Print result
            System.out.print("Output: ");
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) System.out.print(" ");
            }
            System.out.println("\n");
        }

        sc.close();
    }
}
