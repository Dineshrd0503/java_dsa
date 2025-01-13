package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
//Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.
//
//        Examples:
//
//Input: arr[] = [4, 2, 2, 6, 4], k = 6
//Output: 4
//Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
//Input: arr[] = [5, 6, 7, 8, 9], k = 5
//Output: 2
//Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
//Input: arr[] = [1, 1, 1, 1], k = 0
//Output: 4
//Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
public class SubArraySumXor {
    public static long subarrayXor(int arr[], int k) {
        // code here
        int xor=0,count=0;
        Map<Integer,Integer> xormap=new HashMap<>();
        xormap.put(0,1);
        for(int n:arr){
            xor^=n;
            int x=xor^k;
            if(xormap.containsKey(x))
                count+=xormap.get(x);
            xormap.put(xor,xormap.getOrDefault(xor,0)+1);

        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int k = 33;
        System.out.println("Number of subarrays with sum " + k + ": " + subarrayXor(arr, k)); // Output: 2
    }
}
