package codingninjas;

import java.util.Arrays;
//Problem statement
//For a given two strings, 'str1' and 'str2', check whether they are a permutation of each other or not.
//
//Permutations of each other
//Two strings are said to be a permutation of each other when either of the string's characters can be rearranged so that it becomes identical to the other one.
//
//Example:
//str1= "sinrtg"
//str2 = "string"
//
//The character of the first string(str1) can be rearranged to form str2 and hence we can say that the given strings are a permutation of each other.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        0 <= N <= 10^6
//Where N is the length of the input string.
//
//Time Limit: 1 second
//Sample Input 1:
//abcde
//        baedc
//Sample Output 1:
//        true
//Sample Input 2:
//abc
//        cbd
//Sample Output 2:
//        false

public class CheckPermutationOfString {
    public static boolean isPermutation(String str1, String str2) {
        char[] a=str1.toCharArray();
        char[] b=str2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
        //Your code goes here

    }
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bca";
        System.out.println(isPermutation(str1, str2));
    }

}
