package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        Set<String> set=new HashSet<>();
        int maxlen=0;
        for(String word:dictionary){
            set.add(word);
            if(word.length()>maxlen)
                maxlen=word.length();
        }
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            int start=Math.max(0,i-maxlen);
            for(int j=start;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];


    }

    public static void main(String[] args) {
        System.out.println("Word Break");
        WordBreak wordBreak=new WordBreak();
        String s="leetcode";
        String[] dictionary={"leet","code"};
        boolean result=wordBreak.wordBreak(s,dictionary);
        System.out.println("Result: "+result);


    }

}
