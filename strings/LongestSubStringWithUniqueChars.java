package strings;

import java.util.HashMap;
//Given a string 'S' of length 'L', return the length of the longest substring without repeating characters.
//
//        Example:
//
//Suppose given input is "abacb", then the length of the longest substring without repeating characters will be 3 ("acb").
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        0 <= L <= 10^5
//
//Time limit: 1 sec
//Sample Input 1:
//xyxyz
//Sample Output 1:
//        3
//Explanation for Sample Output 1:
//The substrings without repeating characters are "xy", "yx", "xyz", "yz", "z".
//The longest substring out of these substrings is “xyz” of length 3.
//Sample Input 2:
//xxx
//Sample Output 2:
//        1
//Explanation for Sample Output 2:
//The substrings without repeating characters is only "x" with length 1.

public class LongestSubStringWithUniqueChars {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap();
        int left=0,maxlen=0;
        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right)))
                left=Math.max(left,map.get(s.charAt(right))+1);
            map.put(s.charAt(right),right);
            maxlen=Math.max(maxlen,right-left+1);;


        }
        return maxlen;

        // Write your code here.
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("geeksforgeeks"));
    }
}
