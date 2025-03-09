package geeksforgeeks;

//Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2.
//
//Examples
//
//Input: s = "abaab"
//Output: 3
//Explanation: All palindromic substrings are : "aba" , "aa" , "baab".
//Input: s = "aaa"
//Output: 3
//Explanation: All palindromic substrings are : "aa", "aa", "aaa".
//Input: s = "abbaeae"
//Output: 4
//Explanation: All palindromic substrings are : "bb" , "abba" , "aea", "eae".
//Constraints:
//        2 ≤ s.size() ≤ 103
//string contains only lowercase english characters


public class TotalNoOfPalindromicSubStrings {
    public int countPS(String s) {
        // code here
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int count=0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                count++;
            }
        }

        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)&&(dp[i+1][j-1])){
                    dp[i][j]=true;
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println("total no of palindromic substrings");
        TotalNoOfPalindromicSubStrings obj=new TotalNoOfPalindromicSubStrings();
        System.out.println(obj.countPS("abbaeae"));
    }
}
