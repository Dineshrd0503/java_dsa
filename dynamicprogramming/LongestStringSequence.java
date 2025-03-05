package dynamicprogramming;

import java.util.HashMap;
import java.util.Arrays;

//You are given an array of words where each word consists of lowercase English letters.
//wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB. For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
//
//A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.
//
//Return the length of the longest possible word chain with words chosen from the given list of words in any order.
//
//        Examples:
//
//Input: words[] = ["ba", "b", "a", "bca", "bda", "bdca"]
//Output: 4
//Explanation: One of the longest word chains is ["a", "ba", "bda", "bdca"].
//Input: words[] = ["abc", "a", "ab"]
//Output: 3
//Explanation: The longest chain is {"a", "ab" "abc"}
//Input: words[] = ["abcd", "dbqca"]
//Output: 1
//Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
//        Constraint:
//        1 <= words.length <= 104
//        1 <= words[i].length <= 10
//words[i] only consists of lowercase English letters.


public class LongestStringSequence {
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words,(a,b)->a.length()-b.length());
        HashMap<String,Integer> dp=new HashMap<>();
        int max=1;
        for(String word:words){
            dp.put(word,1);
            for(int i=0;i<word.length();i++){
                String predecessor=word.substring(0,i)+word.substring(i+1);
                if(dp.containsKey(predecessor)){
                    dp.put(word,Math.max(dp.get(word),dp.get(predecessor)+1));
                }
            }
            max=Math.max(max,dp.get(word));
        }
        return max;

    }
    public static void main(String[] args) {
        System.out.println("Longest String Chain");
        String[] words={"a","b","ba","bca","bda","bdca"};
        System.out.println(new LongestStringSequence().longestStringChain(words));
    }

}
