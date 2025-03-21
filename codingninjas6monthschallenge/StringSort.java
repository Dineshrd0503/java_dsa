package codingninjas6monthschallenge;
import java.util.Arrays;

//Problem statement
//You are given a string ‘S’ consisting of lowercase English alphabets from ‘a’ to ‘z’. You have to print the string in sorted order.
//
//        Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 10
//        1 <= S.length <= 10^5
//        ‘a’ <= S[i] <= ‘z’
//
//Time Limit: 1 sec
//Sample Input 1 :
//        2
//kbfhh
//        jjkiia
//Sample Output 1 :
//bfhhk
//        aiijjk
//Explanation Of Sample Input 1 :
//For test case 1 we have,
//
//The sorted string in lexicographical order is: bfhhk
//
//For test case 2 we have,
//
//The sorted string in lexicographical order is: aiijjk
//Sample Input 2 :
//        2
//dbahff
//        ccbbj
//Sample Output 2 :
//abdffh
//        bbccj

public class StringSort {
    public static String stringSort(String s) {
        // Write your code here.
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public static void main(String[] args) {
        System.out.println("Sorting the string");
        String str="abc";
        System.out.println(stringSort(str));
    }
}
