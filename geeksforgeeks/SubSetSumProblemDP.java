package geeksforgeeks;

//Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum.
//
//Examples:
//
//Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
//Output: true
//Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
//Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
//Output: false
//Explanation: There is no subset with target sum 30.
//Input: arr[] = [1, 2, 3], sum = 6
//Output: true
//Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
//Constraints:
//        1 <= arr.size() <= 200
//        1<= arr[i] <= 200
//        1<= sum <= 104


public class SubSetSumProblemDP {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int total=0;
        for(int n:arr)
            total+=n;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for(int n:arr){
            for(int j=sum;j>=n;j--){
                if(dp[j-n])
                    dp[j]=true;

            }
        }
        return dp[sum];

    }

    public static void main(String[] args) {
        System.out.println("Subset sum problem using DP");
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        System.out.println(isSubsetSum(arr, sum)); // Output: true
    }
}
