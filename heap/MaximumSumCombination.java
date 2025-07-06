package heap;



import java.util.*;

/*
 * Problem: Top K Sum Pairs
 * Find the k largest sums of pairs (a[i], b[j]) from two arrays.
 *
 * Input:
 * - a: First array of integers
 * - b: Second array of integers
 * - k: Number of top sums to return
 *
 * Output:
 * - ArrayList<Integer> containing the k largest sums in descending order
 *
 * Example:
 * Test Case 1: a = [1, 3, 5], b = [2, 4, 6], k = 3, Output = [11, 9, 7]
 * Test Case 2: a = [1, 2], b = [3, 4], k = 4, Output = [6, 5, 5, 4]
 */
public class MaximumSumCombination {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        if (a == null || b == null || a.length == 0 || b.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        Set<String> set = new HashSet<>();
        maxheap.add(new int[]{a[n-1] + b[n-1], n-1, n-1});
        set.add((n-1) + "#" + (n-1));
        ArrayList<Integer> result = new ArrayList<>();

        while (k > 0 && !maxheap.isEmpty()) {
            int[] top = maxheap.poll();
            int sum = top[0];
            int i = top[1];
            int j = top[2];
            result.add(sum);
            k--;

            if (i-1 >= 0 && !set.contains((i-1) + "#" + j)) {
                maxheap.add(new int[]{a[i-1] + b[j], i-1, j});
                set.add((i-1) + "#" + j);
            }
            if (j-1 >= 0 && !set.contains(i + "#" + (j-1))) {
                maxheap.add(new int[]{a[i] + b[j-1], i, j-1});
                set.add(i + "#" + (j-1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumSumCombination sol = new MaximumSumCombination();
        int[] a1 = {1, 3, 5};
        int[] b1 = {2, 4, 6};
        int k1 = 3;
        System.out.println("Test Case 1: " + sol.topKSumPairs(a1, b1, k1));

        int[] a2 = {1, 2};
        int[] b2 = {3, 4};
        int k2 = 4;
        System.out.println("Test Case 2: " + sol.topKSumPairs(a2, b2, k2));
    }
}
