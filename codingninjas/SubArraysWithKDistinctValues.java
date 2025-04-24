package codingninjas;

import java.util.HashMap;

public class SubArraysWithKDistinctValues {

    /*
     Problem Statement:
     You are given an array ‘ARR’ having ‘N’ integers. You are also given an integer ‘K’. The task is to count the number of subarrays that have ‘K’ distinct values.

     Subarray: A consecutive sequence of one or more values taken from an array.

     For Example:
     ‘N’ = 4, ‘K’ = 2
     ‘ARR’ = [1, 1, 2, 3]

     There are ‘3’ subarrays with ‘2’ distinct elements, which are as follows: [1, 2], [2, 3], [1, 1, 2].
     Thus, you should return ‘3’ as the answer.

     Input Format:
     The first line contains two integers, ‘N’ and ‘K’.
     The second line contains ‘N’ integers representing the array ‘ARR’.

     Output Format:
     Print the number of subarrays that have exactly ‘K’ distinct values.

     Sample Input 1 :
     5 2
     2 1 3 2 4

     Sample Output 1 :
     9

     Sample Input 2 :
     5 4
     1 2 3 4 5

     Sample Output 2 :
     2

     Constraints :
     1 <= K <= N <= 10^5
     1 <= Value in each element of ‘ARR’ <= 10^9

     Time limit: 1 second
    */

    public static void main(String[] args) {
        // Example inputs
        int[] arr1 = {2, 1, 3, 2, 4};
        int result1 = kDistinctSubarrays(arr1, 5, 2);
        System.out.println(result1); // Output: 9

        int[] arr2 = {1, 2, 3, 4, 5};
        int result2 = kDistinctSubarrays(arr2, 5, 4);
        System.out.println(result2); // Output: 2
    }

    public static int kDistinctSubarrays(int[] arr, int n, int k) {
        return atMostK(arr, k) - atMostK(arr, k - 1);
    }

    private static int atMostK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < arr.length; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // When we have more than k distinct elements, shrink the window
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // Count the number of valid subarrays ending with right pointer
            count += (right - left + 1);
        }

        return count;
    }
}