package codingninjas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


//Problem statement
//You are given a string 'STR' consisting of lowercase English letters. Your task is to return all permutations of the given string in lexicographically increasing order.
//
//String A is lexicographically less than string B, if either A is a prefix of B (and A ≠ B), or there exists such i (1 <= i <= min(|A|, |B|)), that A[i] < B[i], and for any j (1 <= j < i) A[i] = B[i]. Here |A| denotes the length of the string A.
//
//For example :
//
//If the string is “bca”, then its permutations in lexicographically increasing order are { “abc”, “acb”, “bac”, “bca”, “cab”, “cba” }.
//Note:
//Given string contains unique characters.
//        Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 5
//        1 <= |STR| <= 9
//
//Where |STR| is the length of the string.
//
//Time Limit: 1 sec
//Sample Input 1:
//        3
//abc
//        bc
//c
//Sample Output 1:
//abc acb bac bca cab cba
//bc cb
//c
//Explanation for Sample Input 1:
//In the 1st test case, there are 6 permutations of the given string.
//In the 2nd test case, there are 2 permutations of the given string.
//In the 3rd test case, there is only 1 permutation of the given string.
//Sample Input 2:
//        1
//xyz
//Sample Output 2:
//xyz xzy yxz yzx zxy zyx


public class PermutationsOfAString {
    public static ArrayList<String> generatePermutations(String str) {
        // Write your code here
        ArrayList<String> result=new ArrayList();
        permutations(str,"",result);
        result=new ArrayList<>(new HashSet<>(result));
        Collections.sort(result);
        return result;
    }
    private static void permutations(String s,String prem,ArrayList<String> result){
        if(s.length()==0){
            result.add(prem);
            return;
        }
        for(int i=0;i<s.length();i++){
            char currchar=s.charAt(i);
            String newstr=s.substring(0,i)+s.substring(i+1);
            permutations(newstr,prem+currchar,result);
        }
    }
    public static void main(String[] args) {
        System.out.println("permutations of a string");
        String s="abc";
        ArrayList<String> result=generatePermutations(s);
        for(String str:result)
            System.out.println(str);
    }
}
