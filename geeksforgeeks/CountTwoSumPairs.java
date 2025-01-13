package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
//Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.
//
//Examples:
//
//Input: arr[] = [1, 5, 7, -1, 5], target = 6
//Output: 3
//Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5).
//Input: arr[] = [1, 1, 1, 1], target = 2
//Output: 6
//Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
//Input: arr[] = [10, 12, 10, 15, -1], target = 125
//Output: 0

public class CountTwoSumPairs {
    static int countPairs(int arr[], int target) {
        // Your code here
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int n:arr){
            int complement=target-n;
            if(map.containsKey(complement))
                count+=map.get(complement);
            map.put(n,map.getOrDefault(n,0)+1);

        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 9, 11, 15};
        int target = 10;
        System.out.println("Count of pairs is " + countPairs(arr, target));
    }
}
