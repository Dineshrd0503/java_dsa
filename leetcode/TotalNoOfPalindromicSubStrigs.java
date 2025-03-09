package leetcode;

//Given a string s, return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.

//
//
//        Example 1:
//
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//Example 2:
//
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//
//Constraints:
//
//        1 <= s.length <= 1000
//s consists of lowercase English letters.


public class TotalNoOfPalindromicSubStrigs {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // Initialize all substrings of length 1 as palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // Check substrings of length 2 or more
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        TotalNoOfPalindromicSubStrigs obj = new TotalNoOfPalindromicSubStrigs();
        String s = "abc";
        System.out.println(obj.countSubstrings(s)); // Output: 3
    }
}
