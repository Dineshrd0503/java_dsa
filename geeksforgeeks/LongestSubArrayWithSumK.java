package geeksforgeeks;
import java.util.Map;
import java.util.HashMap;

//Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.
//
//Examples:
//
//Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
//Output: 6
//Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
//Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
//Output: 5
//Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.
//Input: arr[] = [10, -10, 20, 30], k = 5
//Output: 0
//Explanation: No subarray with sum = 5 is present in arr[].
public class LongestSubArrayWithSumK {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int currsum=0;
        Map<Integer,Integer> map=new HashMap();
        map.put(0,-1);
        int count=0;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(map.containsKey(currsum-k))
                count=Math.max(count,i-map.get(currsum-k));
            map.putIfAbsent(currsum,i);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={10, 5, 2, 7, 1, 9};
        int k=15;
        LongestSubArrayWithSumK obj=new LongestSubArrayWithSumK();
        System.out.println(obj.longestSubarray(arr,k));
    }
}
