package codingninjas;
import java.util.HashSet;

//Problem statement
//You are given a sequence of only digits in the form of a string 'DIGIT_PATTERN', your task is to find the first repeating digit. If no digit is repeating you should return -1.
//
//Example:
//
//Given string of digits is 123456325. Now starting from the left, the first digit which is repeating is 3 as till 2nd 3 every digit is encountered 1st time and thus our answer for this input will be 3.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= |DIGIT_PATTERN| <= 10^5
//        0 <= DIGIT_PATTERN[ i ] <= 9
//
//
//Where ‘DIGIT_PATTERN[i]' denotes the digit at ‘i’th index in the string ‘DIGIT_PATTERN’.
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        1234
//        12342
//Sample Output 1:
//        -1
//        2
//Explanation For Sample Input 1:
//In the first test case, no digit is repeating in the string.
//
//In the second test case, digit 2 is repeating first in the string.
//Sample Input 2:
//        2
//        456746725
//        98768742
//Sample Output 2:
//        4
//        8
//Explanation For Sample Input 2:
//In the first test case, digit 4 is repeating first in the string. Digits 6,7,5 are also repeating but the digit 4 is repeating first among all.
//
//In the second test case, digit 8 is repeating first in the string.

public class FirstRepeatingNumber {
    public static int findFirstRepeatingDigit(String s) {
        // Write your code here.
        HashSet<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            if(set.contains(c))
                return c-'0';
            set.add(c);
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("finding first repeating digit");
        String s="1234567890";
        System.out.println(findFirstRepeatingDigit(s));
    }

}
