package geeksforgeeks;

import java.util.Arrays;


//You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.
//
//For example:
//
//If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
//If arr[i] = 0, you cannot jump forward from that position.
//Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.
////
//Note:  Return -1 if you can't reach the end of the array.
//
//Examples :
//
//Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
//Output: 3
//Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last.
//        Input: arr = [1, 4, 3, 2, 6, 7]
//Output: 2
//Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
//        Input: arr = [0, 10, 20]
//Output: -1
//Explanation: We cannot go anywhere from the 1st element.
//Constraints:
//        2 ≤ arr.size() ≤ 104
//        0 ≤ arr[i] ≤ 104




public class MinimumJumps {
    static int minJumps(int[] arr) {
        // code here
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(dp[i]==Integer.MAX_VALUE)
                continue;
            for(int j=1;j<=arr[i]&&i+j<n;j++){
                dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                if(i+j==n-1)
                    return dp[i+j];
            }
        }
        return dp[n-1]==Integer.MAX_VALUE?-1:dp[n-1];

    }

    public static void main(String[] args) {
        System.out.println("Minimum Jumps");
        int[] arr={1,3,5,8,9,2,6,7,6,8,9};
        System.out.println(minJumps(arr));
    }

}
