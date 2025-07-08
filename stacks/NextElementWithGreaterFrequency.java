package stacks;

import java.util.*;

/*
 * Problem: Next Greater Element by Frequency
 * For each element in the array, find the first element to its right with a higher frequency.
 * If no such element exists, return -1.
 *
 * Input:
 * - arr: Integer array
 *
 * Output:
 * - ArrayList<Integer> containing the next element with higher frequency, or -1 if none exists
 *
 * Constraints:
 * - 1 ≤ arr.length ≤ 10^5
 * - 0 ≤ arr[i] ≤ 10^6
 *
 * Example:
 * Test Case 1: arr = [2, 1, 1, 3, 2, 1], Output = [1, -1, -1, 2, 1, -1]
 * Test Case 2: arr = [5, 1, 5, 6, 6], Output = [-1, 5, -1, -1, -1]
 */
public class NextElementWithGreaterFrequency {
    public ArrayList<Integer> findGreater(int[] arr) {
        // Handle edge cases
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        int n = arr.length;
        // Initialize result with -1 for all positions
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        // Count frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Stack to store indices of elements
        Stack<Integer> stack = new Stack<>();
        // Iterate left to right
        for (int i = 0; i < n; i++) {
            // Pop elements with lower frequency
            while (!stack.isEmpty() && frequencyMap.get(arr[stack.peek()]) < frequencyMap.get(arr[i])) {
                result.set(stack.pop(), arr[i]);
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        NextElementWithGreaterFrequency sol = new NextElementWithGreaterFrequency();
        int[][] testCases = {
                {2, 1, 1, 3, 2, 1},
                {5, 1, 5, 6, 6}
        };

        for (int t = 0; t < testCases.length; t++) {
            System.out.println("Test Case " + (t + 1) + ": Input = " + Arrays.toString(testCases[t]));
            System.out.println("Output = " + sol.findGreater(testCases[t]));
        }
    }
}
