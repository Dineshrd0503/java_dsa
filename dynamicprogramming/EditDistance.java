package dynamicprogramming;

//Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2.
//The possible operations are permitted:
//
//Insert a character at any position of the string.
//Remove any character from the string.
//Replace any character from the string with any other character.
//Examples:
//
//Input: s1 = "geek", s2 = "gesek"
//Output: 1
//Explanation: One operation is required, inserting 's' between two 'e' in s1.
//Input: s1 = "gfg", s2 = "gfg"
//Output: 0
//Explanation: Both strings are same.
//Input: s1 = "abcd", s2 = "bcfe"
//Output: 3
//Explanation: We can convert s1 into s2 by removing ‘a’, replacing ‘d’ with ‘f’ and inserting ‘e’ at the end.
//        Constraints:
//        1 ≤ s1.length(), s2.length() ≤ 103
//Both the strings are in lowercase.




public class EditDistance {
    public int editDistance(String s1, String s2) {
        // Code here
        int n=s1.length(),m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=i;
        for(int j=0;j<=m;j++) dp[0][j]=j;
        for(int  i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));

            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        String s1 = "sunday";
        String s2 = "saturday";
        System.out.println(obj.editDistance(s1, s2)); // Output: 3
    }
}
