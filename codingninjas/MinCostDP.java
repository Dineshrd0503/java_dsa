package codingninjas;
import java.util.Arrays;
//There is an array of heights corresponding to 'n' stones. You have to reach from stone 1 to stone ‘n’.
//
//
//
//From stone 'i', it is possible to reach stones 'i'+1, ‘i’+2… ‘i’+'k' , and the cost incurred will be | Height[i]-Height[j] |, where 'j' is the landing stone.
//
//
//
//Return the minimum possible total cost incurred in reaching the stone ‘n’.
//
//
//
//Example:
//For 'n' = 3 , 'k' = 1, height = {2, 5, 2}.
//
//Answer is 6.
//
//Initially, we are present at stone 1 having height 2. We can only reach stone 2 as ‘k’ is 1. So, cost incurred is |2-5| = 3. Now, we are present at stone 2, we can only reach stone 3 as ‘k’ is 1. So, cost incurred is |5-2| = 3. So, the total cost is 6.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        4 2
//        10 40 30 10
//Sample Output 1:
//        40
//Explanation of sample output 1:
//For ‘n’ = 4, 'k' = 2, height = {10, 40, 30, 10}
//
//Answer is 40.
//
//Initially, we are present at stone 1 having height 10. We can reach stone 3 as ‘k’ is 2. So, cost incurred is |10-30| = 20.
//
//Now, we are present at stone 3, we can reach stone 4 as ‘k’ is 2. So, cost incurred is |30-10| = 20. So, the total cost is 40. We can show any other path will lead to greater cost.
//Sample Input 2:
//        5 3
//        10 40 50 20 60
//Sample Output 2:
//        50
//Constraints:
//        1 <= n <= 10^4
//        1 <= k <= 100
//        1 <= height[i] <= 10^4
//Time Limit: 1 sec
public class MinCostDP {
    public static int minimizeCost(int n, int k, int[] height) {
        // Initialize dp array with a large value
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: cost to reach the first stone is 0
        dp[0] = 0;

        // Calculate minimum cost for each stone
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k && i + j < n; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(height[i] - height[i + j]));
            }
        }

        // Return the minimum cost to reach the last stone
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // Test case 1
        int n1 = 4, k1 = 2;
        int[] height1 = {10, 40, 30, 10};
        System.out.println(minimizeCost(n1, k1, height1)); // Output: 40

        // Test case 2
        int n2 = 5, k2 = 3;
        int[] height2 = {10, 40, 50, 20, 60};
        System.out.println(minimizeCost(n2, k2, height2)); // Output: 50
    }
}
