package codingninjas;

import java.util.HashMap;
import java.util.Map;
//Problem statement
//You have been given an array/list(ARR) of positive and negative integers. Print the number of pairs where:
//
//arr[i] = -arr[j] and i != j
//Note:
//Given array/list can contain duplicate elements and will not contain '0'.
//Sample Input 1:
//        9
//        -1 3 6 2 5 -4 3 2 -4
//Sample Output 1:
//        0
//Explanation For Sample Input 1:
//Since there doesn't exist any positive-negative pair, the Output is '0'.
//Sample Input 2:
//        6
//        -2 8 2 5 -2 -5
//Sample Output 2:
//        3

//        (arr[i],arr[j]) and (arr[j],arr[i]) are considered same.
public class CountPositiveNegativepairs {
    public static long countPositiveNegativePairs(int[] arr) {
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int negative = -n;
            if (map.containsKey(negative))
                count += map.get(negative);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return count;
        //Write your code here
    }
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -5, 6};
        System.out.println(countPositiveNegativePairs(arr)); // Output: 4
    }
}
