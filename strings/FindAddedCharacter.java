
package strings;

/**
 * Problem Statement:
 * You are given a string 'S'. Now one more additional character is introduced in this string, which turns 'S' into new string 'T'.
 * You have to find out this newly added character.
 * 
 * Note:
 * 1. All the characters in string 'S' and 'T' consist of uppercase English alphabets.
 * 2. Length of string 'T' is always 1 more than the length of string 'S'.
 * 
 * Constraints:
 * - 1 <= TEST <= 100 (number of test cases)
 * - 1 <= |S|, |T| <= 10^4 (length of strings)
 * - Time Limit: 1 sec
 * 
 * Sample Input 1:
 * 2
 * APPLE
 * APPHLE
 * CODE
 * CODER
 * Sample Output 1:
 * H
 * R
 * Explanation for Sample Output 1:
 * - Test Case 1: The only character present in “APPHLE” but not in “APPLE” is ‘H’.
 * - Test Case 2: The only character present in “CODER” but not in “CODE” is ‘R’.
 * 
 * Sample Input 2:
 * 2
 * MANGO
 * MANNGO
 * NINJA
 * NIINJA
 * Sample Output 2:
 * N
 * I
 * Explanation for Sample Output 2:
 * - Test Case 1: “MANGO” has 1 ‘N’, “MANNGO” has 2 ‘N’s, so the added character is ‘N’.
 * - Test Case 2: “NINJA” has 1 ‘I’, “NIINJA” has 2 ‘I’s, so the added character is ‘I’.
 */
public class FindAddedCharacter {
   public static char findAddedCharacter(String s, String t) {
		// Write your code here.
       int xor=0;
       int i=0;
       while(i<s.length()){
           xor^=s.charAt(i);
           xor^=t.charAt(i);
           i++;
       }
       xor^=t.charAt(i);
     return (char)xor;

        }
    
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "APPLE";
        String t1 = "APPHLE";
        System.out.print("Test Case 1: ");
        findAddedCharacter(s1, t1); // Expected: H
        
        // Test Case 2
        String s2 = "CODE";
        String t2 = "CODER";
        System.out.print("Test Case 2: ");
        findAddedCharacter(s2, t2); // Expected: R
        
        // Test Case 3
        String s3 = "MANGO";
        String t3 = "MANNGO";
        System.out.print("Test Case 3: ");
        findAddedCharacter(s3, t3); // Expected: N
        
        // Test Case 4
        String s4 = "NINJA";
        String t4 = "NIINJA";
        System.out.print("Test Case 4: ");
        findAddedCharacter(s4, t4); // Expected: I
    }
}
