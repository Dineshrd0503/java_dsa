package codingninjas7dayschallenge;

//Problem statement
//You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
//
//Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
//
//For Example :
//If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 5
//        1 <= N <= 10^3
//        0 <= ARR[i] <= 10^9
//        0 <= K <= 10^3
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        4 5
//        4 3 2 1
//        5 4
//        2 5 1 6 7
//Sample Output 1:
//        true
//        false
//Explanation For Sample Input 1:
//In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.
//In example 2, ‘ARR’ is {2,5,1,6,7} and ‘K’ = 4. There are no subsets with sum = 4. Hence, return false.
//Sample Input 2:
//        2
//        4 4
//        6 1 2 1
//        5 6
//        1 7 2 9 10
//Sample Output 2:
//        true
//        false
//Explanation For Sample Input 2:
//In example 1, ‘ARR’ is {6,1,2,1} and ‘K’ = 4. There exist 1 subset with sum = 4. That is {1,2,1}. Hence, return true.
//In example 2, ‘ARR’ is {1,7,2,9,10} and ‘K’ = 6. There are no subsets with sum = 6. Hence, return false.
//
//
//Hints:
//        1. Can you find every possible subset of ‘ARR’ and check if its sum is equal to ‘K’?
//        2. Can you use dynamic programming and use the previously calculated result to calculate the new result?
//        3. Try to use a recursive approach followed by memoization by including both index and sum we can form.


public class SubSetSumEqualToK {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n + 1][k + 1];

        // Base case: A sum of 0 can always be formed with the empty subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the rest of the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // Do not include the current element
                dp[i][j] = dp[i - 1][j];

                // Include the current element if it does not exceed the sum
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The answer will be in dp[n][k]
        return dp[n][k];
    }
    public static void main(String[] args) {
        int[][] testCases = {
                {4, 5, 4, 3, 2, 1}, // Expected Output: true
                {5, 4, 2, 5, 1, 6, 7} // Expected Output: false
        };

        for (int[] testCase : testCases) {
            int n = testCase[0];
            int k = testCase[1];
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = testCase[i + 2];
            }
            boolean result = subsetSumToK(n, k, arr);
            System.out.println(result);
        }
    }
}
