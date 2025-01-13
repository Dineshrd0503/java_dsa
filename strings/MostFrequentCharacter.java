package strings;
import java.util.*;
//Given a string s of lowercase alphabets. The task is to find the maximum occurring character in the string s. If more than one character occurs the maximum number of times then print the lexicographically smaller character.
//
//        Examples:
//
//Input: s = "testsample"
//Output: 'e'
//Explanation: e is the character which is having the highest frequency.
//Input: s = "output"
//Output: 't'
//Explanation:  t and u are the characters with the same frequency, but t is lexicographically smaller.
public class MostFrequentCharacter {
    public static char getMaxOccuringChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        int maxfreq=Integer.MIN_VALUE;
        char result='a';
        for(char c:map.keySet()){
            int currfreq=map.get(c);
            if(currfreq>maxfreq||currfreq==maxfreq&&c<result){
                maxfreq=currfreq;
                result=c;
            }
        }
        return result;
        // Your code here
    }
    public static void main(String[] args) {
        String str = "programming";
        System.out.println("Most frequent character: " + getMaxOccuringChar(str));
    }
}
