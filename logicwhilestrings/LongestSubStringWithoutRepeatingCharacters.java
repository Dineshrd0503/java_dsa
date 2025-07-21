package logicwhilestrings;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String a="abcabcbb";
        int left=0;
        int maxLength = 0;
        HashMap<Character,Integer> map=new HashMap<>();
       for(int right=0; right<a.length(); right++) {

         char currchar=a.charAt(right);
         if(map.containsKey(currchar))
             left=Math.max(left, map.get(currchar) + 1);
            map.put(currchar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println("Length of longest substring without repeating characters: " + maxLength);
    }
}
