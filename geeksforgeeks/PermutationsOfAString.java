package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashSet;

//Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.
//
//        Examples:
//
//Input: s = "ABC"
//Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
//Explanation: Given string ABC has 6 unique permutations.
//Input: s = "ABSG"
//Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
//Explanation: Given string ABSG has 24 unique permutations.
//Input: s = "AAA"
//Output: ["AAA"]
//Explanation: No other unique permutations can be formed as all the characters are same.
//        Constraints:
//        1 <= s.size() <= 9
//s contains only Uppercase english alphabets




public class PermutationsOfAString {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> result=new ArrayList();
        permutations(s,"",result);
        result=new ArrayList<>(new HashSet<>(result));
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
        PermutationsOfAString obj=new PermutationsOfAString();
        String s="abc";
        ArrayList<String> res=obj.findPermutation(s);
        for(String str:res)
            System.out.println(str);
    }
}
