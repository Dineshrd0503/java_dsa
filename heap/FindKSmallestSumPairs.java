package heap;

/*
Problem Statement:
Given two sorted integer arrays arr1[] and arr2[], and an integer k,
find the k pairs (one from each array) with the smallest sums.
Each pair should be formatted as [arr1[i], arr2[j]].

Sample Test Case:
Input:
    arr1[] = {1, 7, 11}
    arr2[] = {2, 4, 6}
    k = 3
Output:
    [[1, 2], [1, 4], [1, 6]]
*/

import java.util.*;

public class FindKSmallestSumPairs {
    public List<List<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr1.length, m = arr2.length;

        // Min-heap to store [sum, i, j]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Only push first k elements from arr1 paired with arr2[0]
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new int[]{arr1[i] + arr2[0], i, 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int i = cur[1], j = cur[2];
            result.add(Arrays.asList(arr1[i], arr2[j]));

            // Expand to next element in arr2
            if (j + 1 < m) {
                minHeap.offer(new int[]{arr1[i] + arr2[j + 1], i, j + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Static test input
        int[] arr1 = {1, 7, 11};
        int[] arr2 = {2, 4, 6};
        int k = 3;
        FindKSmallestSumPairs sol = new FindKSmallestSumPairs();

        List<List<Integer>> pairs = sol.kSmallestPair(arr1, arr2, k);
        System.out.println(pairs); // Output: [[1, 2], [1, 4], [1, 6]]
    }
}

