package dynamicprogramming;

//Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
//
//
//
//        Example 1:
//
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//Example 2:
//
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.




public class PartitionEqualSubSetSumDP {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, partition is impossible
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        return isSubsetSum(nums, target);


    }
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
        int[] nums = {1, 5, 11, 5};
        PartitionEqualSubSetSumDP partitionEqualSubSetSumDP = new PartitionEqualSubSetSumDP();
        System.out.println(partitionEqualSubSetSumDP.canPartition(nums));
    }
}
