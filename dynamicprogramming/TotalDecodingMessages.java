package dynamicprogramming;
//A message containing letters A-Z is being encoded to numbers using the following mapping:
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//
//You are given a string digits. You have to determine the total number of ways that message can be decoded.
//
//Examples:
//
//Input: digits = "123"
//Output: 3
//Explanation: "123" can be decoded as "ABC"(1, 2, 3), "LC"(12, 3) and "AW"(1, 23).
//Input: digits = "90"
//Output: 0
//Explanation: "90" cannot be decoded, as it's an invalid string and we cannot decode '0'.
//Input: digits = "05"
//Output: 0
//Explanation: "05" cannot be mapped to "E" because of the leading zero ("5" is different from "05"), the string is not a valid encoding message.
//Constraints:
//        1 ≤ digits.size() ≤ 103
public class TotalDecodingMessages
{
    public int countWays(String digits) {
        // code here
        if(digits==null||digits.length()==0)
            return 0;
        int n=digits.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=(digits.charAt(0)=='0')?0:1;
        for(int i=2;i<=n;i++){
            int onedigit=Integer.parseInt(digits.substring(i-1,i));
            int twodigit=Integer.parseInt(digits.substring(i-2,i));
            if(onedigit>=1&&onedigit<=9)
                dp[i]+=dp[i-1];
            if(twodigit>=10&&twodigit<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        TotalDecodingMessages obj=new TotalDecodingMessages();
        String digits="1234";
        int result=obj.countWays(digits);
        System.out.println("Total decoding messages: "+result);
    }
}
