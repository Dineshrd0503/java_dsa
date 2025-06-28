package arrays;
import java.util.*;
import java.io.*;

public class SortTheTuples {

    /**
     * Problem Statement:
     * You are given an array of tuples ‘ARR’ of length ‘N’. All the tuples are of length ‘L’.
     * Sort the tuples in non-decreasing order by the last element of tuples.
     * If the last element of two tuples are equal then the tuple with the smallest index should be placed first.
     *
     * Note: The length of all the tuples will be the same.
     *
     * Example:
     * Input: ‘N’ = 3, ‘L’ = 2,  ‘ARR’ = [(1, 1), (5, 3), (8, 2)].
     *
     * Output: [(1, 1), (8, 2), (5, 3)].
     *
     * The last values of each type are (1, 3, 2). Sorting them in non-decreasing order we get (1, 2, 3).
     * Hence the final result is [(1, 1), (8, 2), (5, 3)].
     */
    public static void sortTuples(int[][] arr) {
        int n = arr.length;
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(arr[i], i);
        List<int[]> list = Arrays.asList(arr);
        Comparator<int[]> comparator =
                (tuple1, tuple2) -> {
                    int ele1 = tuple1[tuple1.length - 1];
                    int ele2 = tuple2[tuple2.length - 1];
                    if (ele1 != ele2)
                        return Integer.compare(ele1, ele2);
                    else
                        return Integer.compare(map.get(tuple1), map.get(tuple2));
                };
        Collections.sort(list, comparator);
    }

    public static void main(String[] args) {
        // Sample Test Cases
        // Test Case 1
        int[][] arr1 = {{1, 2}, {1, 1}, {3, 5}, {2, 3}};
        // Expected Output: {{1, 1}, {1, 2}, {2, 3}, {3, 5}}
        System.out.println("Test Case 1: Before Sorting - " + Arrays.deepToString(arr1));
        sortTuples(arr1);
        System.out.println("Test Case 1: After Sorting - " + Arrays.deepToString(arr1));

        // Test Case 2
        int[][] arr2 = {{1, 2, 3}, {3, 2, 1}, {4, 5, 6}, {3, 1, 2}};
        // Expected Output: {{3, 1, 2}, {3, 2, 1}, {1, 2, 3}, {4, 5, 6}}
        System.out.println("Test Case 2: Before Sorting - " + Arrays.deepToString(arr2));
        sortTuples(arr2);
        System.out.println("Test Case 2: After Sorting - " + Arrays.deepToString(arr2));

        // Test Case 3
        int[][] arr3 = {{7, 81, 2, 10}, {1, 2, 4, 1}, {90, 28, 2, 19}};
        // Expected Output: {{1, 2, 4, 1}, {7, 81, 2, 10}, {90, 28, 2, 19}}
        System.out.println("Test Case 3: Before Sorting - " + Arrays.deepToString(arr3));
        sortTuples(arr3);
        System.out.println("Test Case 3: After Sorting - " + Arrays.deepToString(arr3));
    }
}