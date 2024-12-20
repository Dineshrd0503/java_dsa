package strings;
//Problem statement
//There are two strings 'S' and 'T', each having 'N' lowercase English characters. Initially, both strings are equal.
//
//
//
//You don't want the string 'T' equal to 'S'. For this, you can reshuffle the characters of the string 'T'.
//
//
//
//Determine if you can make the string 'T' different from 'S' after reshuffling the characters of the string 'T'.
//
//
//
//Return '1' if you can make the string 'T' different from 'S'. Otherwise, return '0'.
//Sample input 1:
//        2
//        3
//aaa
//4
//abcd
//Sample output 1:
//        0
//        1
//Explanation of sample input 1:
//For test case 1:
//It can be proved that you can not shuffle the characters of the string 'T' such that it will be different from 'S'.
//So, the answer for this case is '0'.
//
//For test case 2:
//Initially, the string 'T' is equal to 'abcd'.
//You can shuffle the characters such that 'T' equals 'dcab'. So 'T' is not equal to 'S'.
//So, the answer for this case is '1'.
//Sample input 2:
//        2
//        6
//abcabc
//1
//a
//Sample output 2:
//        1
//        0



//Example:
//N = 7
//S = 'aab'
//Initially, the string 'T' is equal to 'aab'.
//You can shuffle the characters such that 'T' equals 'aba'. So 'T' is not equal to 'S'.
//So, the answer for this case is '1'.
public class MakeStringsDifferent {
    static int canYouMakeDifference(int n, String s) {
        if(s.length()==1||s.length()==0)
            return 0;
        for(int i=1;i<=s.length()-1;i++){
            if(s.charAt(i)!=s.charAt(0))
                return 1;
        }
        return 0;
        // Write your code here.
    }

    public static void main(String[] args) {
        int n = 3;
        String s = "abc";
        System.out.println(canYouMakeDifference(n, s));
    }
}
