package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

//Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
//
//        Examples:
//
//Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
//Output: 6
//Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
//        Input: arr[] = [0, 0, 1, 1, 0]
//Output: 4
//Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
//        Input: arr[] = [0]
//Output: 0
//Explnation: There is no subarray with an equal number of 0s and 1s.
//        Constraints:
//        1 <= arr.size() <= 105
//        0 <= arr[i] <= 1
//
//Company Tags

public class LongestSubArrayWith0s1s {
    public int maxLen(int[] arr) {
        if(arr.length==1)
            return 0;
        Map<Integer,Integer> map=new HashMap();
        map.put(0,-1);
        int ans=0,sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i]==1?1:-1;
            if(map.containsKey(sum))
                ans=Math.max(ans,i-map.get(sum));
            else

                map.putIfAbsent(sum,i);
        }
        return ans;
        // Your code here
    }
    public static void main(String[] args) {
        int arr[]={1,0,1,1,1,0,0};
        LongestSubArrayWith0s1s obj=new LongestSubArrayWith0s1s();
        System.out.println(obj.maxLen(arr));
    }

}