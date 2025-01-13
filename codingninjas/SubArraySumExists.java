package codingninjas;

import java.util.HashMap;
import java.util.Map;

//You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
//
//Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
//
//For Example :
//If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
public class SubArraySumExists {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixsum=0;
        for(int a:arr){
            prefixsum+=a;
            if(map.containsKey(prefixsum-k))
                return true;
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return false;
        // Write your code here.
    }
    public static boolean subsetSumToK2(int n, int target, int arr[]){
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int num:arr){
            for(int j=target;j>=num;j--){
                dp[j]=dp[j]||dp[j-num];
            }

        }
        return dp[target];
        // Write your code here.
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int k = 33;
        int n = arr.length;
        System.out.println(subsetSumToK(n, k, arr));
        System.out.println(subsetSumToK2(n, k, arr));
    }
}
