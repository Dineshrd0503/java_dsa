package geeksforgeeks;
import java.util.*;
//Given a string s. The task is to return a vector of string of all unique permutations of the given string, s that may contain duplicates in lexicographically sorted order.
//
//Examples:
//
//Input: "ABC"
//Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
//Explanation: Given string ABC has permutations in 6 forms as "ABC", "ACB", "BAC", "BCA", "CAB" and "CBA".
//Input: "ABSG"
//Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
//Explanation: Given string ABSG has 24 permutations.
//        Input: "AAA"
//Output: ["AAA"]
//Explanation: No other unique permutations can be formed as all the characters are same.

public class FindPermutationsOfString
{
    public List<String> findPermutation(String s) {
        Set<String> result = new HashSet<>();
        generatePermutations(s, "", result);
        List<String> list = new ArrayList<>(result);
        list.sort(String::compareTo); // Sort to maintain lexicographical order
        return list;
    }

    private void generatePermutations(String s, String perm, Set<String> result) {
        if (s.length() == 0) {
            result.add(perm);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            // Current character
            char currChar = s.charAt(i);
            // Remaining string after excluding current character
            String newStr = s.substring(0, i) + s.substring(i + 1);
            generatePermutations(newStr, perm + currChar, result);
        }
    }

    public static void main(String[] args) {
        FindPermutationsOfString obj = new FindPermutationsOfString();
        String s = "ABC";
        List<String> result = obj.findPermutation(s);
        System.out.println(result);
    }

}
