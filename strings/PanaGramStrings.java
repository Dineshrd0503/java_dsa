package strings;
import java.util.HashSet;

//Check if the given string S is a Panagram or not. A pangram is a sentence containing every letter in the English Alphabet.
//
//Example 1:
//
//Input: S = "Pack mY box witH fIve dozen
//liquor jugs"
//Output: 1
//Explanation: Given string contains all
//English Alphabets.
//Example 2:
//
//Input: S = "geeksFORgeeks"
//Output: 0
//Explanation: Given string does not contain
//all English Alphabets.
//Your Task:
//You don't need to read input or print anything. Your task is to complete the function isPanagram() which takes the string as inputs and returns 1 if the given string is panagram, otherwise 0.
//
//Expected Time Complexity: O(N)
//Expected Auxiliary Space: O(constant)
//
//Constraints:
//        1 ≤ |S| ≤ 105

public class PanaGramStrings {

    static int isPanagram(String s) {
        // code here
        HashSet<Character> set=new HashSet();
        s=s.toLowerCase();
        for(char c:s.toCharArray()){
            if(Character.isLetter(c))
                set.add(c);
        }
        return set.size()==26?1:0;
    }

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(isPanagram(str)); // Output: true
    }


}
