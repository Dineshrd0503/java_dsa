package geeksforgeeks;

import java.util.HashMap;
//Given a string s, find the length of the longest substring with all distinct characters.
//
//Examples:
//
//Input: s = "geeksforgeeks"
//Output: 7
//Explanation: "eksforg" is the longest substring with all distinct characters.
//Input: s = "aaa"
//Output: 1
//Explanation: "a" is the longest substring with all distinct characters.
//Input: s = "abcdefabcbb"
//Output: 6
//Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.


public class LongestSubStringWithUniqueChars {
    public int longestUniqueSubstr(String s) {
        HashMap<Character,Integer> map=new HashMap();
        int left=0,maxlen=0;
        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right)))
                left=Math.max(left,map.get(s.charAt(right))+1);
            map.put(s.charAt(right),right);
            maxlen=Math.max(maxlen,right-left+1);;


        }
        return maxlen;


        // code here
    }
    public static void main(String[] args) {
        LongestSubStringWithUniqueChars l=new LongestSubStringWithUniqueChars();
        System.out.println(l.longestUniqueSubstr("geeksforgeeks"));
    }

}
