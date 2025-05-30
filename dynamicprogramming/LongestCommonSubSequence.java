package dynamicprogramming;


//Given two strings s1 and s2, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.
//
//A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "ABE" is a subsequence of "ABCDE".
//
//Examples:
//
//Input: s1 = "ABCDGH", s2 = "AEDFHR"
//Output: 3
//Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a length of 3.
//Input: s1 = "ABC", s2 = "AC"
//Output: 2
//Explanation: The longest common subsequence of "ABC" and "AC" is "AC", which has a length of 2.
//Input: s1 = "XYZW", s2 = "XYWZ"
//Output: 3
//Explanation: The longest common subsequences of "XYZW" and "XYWZ" are "XYZ" and "XYW", both of length 3.
//Constraints:
//        1<= s1.size(), s2.size() <=103
//Both strings s1 and s2 contain only uppercase English letters



public class LongestCommonSubSequence {

    static int lcs(String s1, String s2) {
        // code here
        int n=s1.length(),m=s2.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String s1="ABCDGH";
        String s2="AEDFHR";
        System.out.println(lcs(s1,s2)); // Output: 3
    }

}
