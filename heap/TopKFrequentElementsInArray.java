package heap;

/*
====================================================================================
Problem Statement: Top K Frequent Elements in Array (With Tie-breaker)
====================================================================================

Given an array of integers and a value k, find the k most frequently occurring numbers.
If two numbers have the same frequency, the larger number should be given the higher priority in the result.

Return the list of these k numbers, sorted by descending frequency (and by value if tie).

Sample Input:
-------------
int[] arr = {1, 1, 1, 2, 2, 3};
int k = 2;

Sample Output:
--------------
[1, 2]         // 1 occurs 3 times, 2 occurs 2 times

Tie-break example:
int[] arr = {4, 4, 1, 1, 2};
k = 2;
Output: [4, 1] // 4 and 1 both occur 2 times, but 4 > 1 so 4 comes first

====================================================================================

Code:
====================================================================================
*/

import java.util.*;
public class TopKFrequentElementsInArray {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // Count frequency of each element
        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);

        // PriorityQueue with custom comparator: frequency desc, value desc
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((a, b) -> {
                    if (b.getValue() != a.getValue())
                        return b.getValue() - a.getValue();
                    else
                        return b.getKey() - a.getKey();
                });

        queue.addAll(map.entrySet());
        for (int i = 0; i < k && !queue.isEmpty(); i++)
            result.add(queue.poll().getKey());
        return result;
    }
    public static void main(String[] args) {
        TopKFrequentElementsInArray sol = new TopKFrequentElementsInArray();


        // Test case 1
        int[] arr1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(sol.topKFreq(arr1, k1)); // Output: [1, 2]

        // Test case 2 (Tie-break on value)
        int[] arr2 = {4, 4, 1, 1, 2};
        int k2 = 2;
        System.out.println(sol.topKFreq(arr2, k2)); // Output: [4, 1]
    }
}
