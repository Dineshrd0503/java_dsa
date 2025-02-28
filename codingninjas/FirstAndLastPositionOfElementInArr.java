import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Statement:
=================

You have been given a sorted array/list 'arr' consisting of 'n' elements. You are also given an integer 'k'.

Now, your task is to find the first and last occurrence of 'k' in 'arr'.

**Note:**
1. If 'k' is not present in the array, then the first and the last occurrence will be -1.
2. 'arr' may contain duplicate elements.

Example:
--------
Input: 'arr' = [0, 1, 1, 5], 'k' = 1

Output: 1 2

Explanation:
If 'arr' = [0, 1, 1, 5] and 'k' = 1, then the first and last occurrence of 1 will be 1 (0-indexed) and 2.

Detailed Explanation (Input/output format, Notes, Images)
--------------------------------------------------------

Input Format:
--------------
The first line of each test case contains two single-space separated integers 'n' and 'k', respectively.
The second line of each test case contains 'n' single space-separated integers denoting the elements of the array/list 'arr'.

Output Format:
---------------
Return two single-space separated integers denoting the first and last occurrence of 'k' in 'arr', respectively.

Note:
You do not need to print anything; it has already been taken care of. Just implement the given function.

Sample Input 1:
----------------
8 2
0 0 1 1 2 2 2 2

Sample Output 1:
-----------------
4 7

Explanation of Sample Output 1:
For this testcase, the first occurrence of 2 is at index 4 and the last occurrence is at index 7.

Sample Input 2:
----------------
4 2
1 3 3 5

Sample Output 2:
-----------------
-1 -1

Expected Time Complexity:
------------------------
Try to do this in O(log(n)).

Constraints:
------------
1 <= n <= 10^5
0 <= k <= 10^9
0 <= arr[i] <= 10^9

Time Limit: 1 second
*/



public class FirstAndLastPositionOfElementInArr {
    
    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int[] result = new int[2];
        Arrays.fill(result, -1); // Initialize result with -1 for both positions

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == k) {
                if (result[0] == -1) {
                    result[0] = i; // First occurrence
                }
                result[1] = i; // Last occurrence
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Static input
        int n = 8; // Size of the array
        int k = 2; // Element to find

        // Predefined array
        Integer[] inputArray = {0, 0, 1, 1, 2, 2, 2, 2};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(inputArray));

        // Get the result from the function
        int[] result = firstAndLastPosition(arr, n, k);

        // Print the result
        System.out.println(result[0] + " " + result[1]); // Expected output: 4 7
    }
}
