package slidingwindow;

/*
Problem: Longest Contiguous Subarray With Absolute Diff Bounded by a Limit

Given an array ARR and an integer K (limit), find the length of the longest contiguous subarray
such that the absolute difference between the maximum and minimum elements in that subarray is ≤ K.

Approach:
- Use sliding window with two deques to keep track of the maximum and minimum elements in the current window.
- Expand the window using the right pointer.
- Shrink the window from the left if the absolute difference between max and min exceeds K.
- Track the maximum window length that maintains the condition.

Example:
Input: arr = [8, 2, 4, 7], k = 4
Output: 2
Explanation: The longest subarray is [2, 4] with max-min = 2 ≤ 4.

*/

import java.util.*;

public class  LongestContiguousSubarrayWithAbsoluteDiffBoundedByLimit {
    public static int getLongestSubarrayLength(ArrayList<Integer> arr, int k) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        int left = 0, maxlen = 0;
        for (int right = 0; right < arr.size(); right++) {
            while (!max.isEmpty() && arr.get(right) > max.peekLast())
                max.pollLast();
            max.offerLast(arr.get(right));
            while (!min.isEmpty() && arr.get(right) < min.peekLast())
                min.pollLast();
            min.offerLast(arr.get(right));

            // Correction: the window is valid only if max - min <= k
            while (!max.isEmpty() && !min.isEmpty() && max.peekFirst() - min.peekFirst() > k) {
                if (max.peekFirst() == arr.get(left)) max.pollFirst();
                if (min.peekFirst() == arr.get(left)) min.pollFirst();
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        // Sample input array and k value
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(8, 2, 4, 7));
        int k = 4;
        int result = getLongestSubarrayLength(arr, k);
        System.out.println("Longest subarray length: " + result); // Expected output: 2

        // Additional test case
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 5, 6, 7, 8, 10, 6, 5, 6));
        int k2 = 4;
        int result2 = getLongestSubarrayLength(arr2, k2);
        System.out.println("Longest subarray length: " + result2); // Expected output: 5
    }
}
