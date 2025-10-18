package arrays;

/*
🧩 PROBLEM STATEMENT:
---------------------
You are given an array of tuples ‘ARR’ of length ‘N’.
All the tuples are of length ‘L’.
Sort the tuples in non-decreasing order by the last element of each tuple.
If the last element of two tuples is equal, the one appearing earlier should stay first.

Note: The length of all tuples is the same.

------------------------------------------
📘 Example:
Input:
N = 3, L = 2
ARR = [(1, 1), (5, 3), (8, 2)]

Output:
[(1, 1), (8, 2), (5, 3)]

Explanation:
Last elements = [1, 3, 2]
Sorting by these → order = [1, 2, 3]
Hence output = [(1, 1), (8, 2), (5, 3)]

------------------------------------------
🧮 Constraints:
1 <= N <= 10^5
1 <= ARR[i].length <= 1000
Sum of all integers <= 10^5
Time Limit: 1 sec

------------------------------------------
📊 Sample Input:
4 2
1 2
1 1
3 5
2 3

📊 Sample Output:
1 1
1 2
2 3
3 5
*/

import java.util.*;

public class SortTuplesByLastElement {

    // Method to sort tuples by last element using a lambda comparator
    public static void sortTuples(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            // Compare based on the last element
            return Integer.compare(a[a.length - 1], b[b.length - 1]);
        });
    }

    public static void main(String[] args) {
        // 🔹 Static input
        int[][] arr = {
                {1, 2},
                {1, 1},
                {3, 5},
                {2, 3}
        };

        System.out.println("Before sorting:");
        for (int[] tuple : arr) {
            System.out.println(Arrays.toString(tuple));
        }

        // 🔹 Call the sorting method
        sortTuples(arr);

        System.out.println("\nAfter sorting by last element:");
        for (int[] tuple : arr) {
            System.out.println(Arrays.toString(tuple));
        }
    }
}

/*
------------------------------------------
✅ OUTPUT:

Before sorting:
[1, 2]
[1, 1]
[3, 5]
[2, 3]

After sorting by last element:
[1, 1]
[1, 2]
[2, 3]
[3, 5]
------------------------------------------
*/
