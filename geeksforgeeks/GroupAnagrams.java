package geeksforgeeks;

import java.util.*;
//Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.
//
//        Note: The final output will be in lexicographic order.
//
//Examples:
//
//Input: arr[] = ["act", "god", "cat", "dog", "tac"]
//Output: [["act", "cat", "tac"], ["god", "dog"]]
//Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.
//Input: arr[] = ["no", "on", "is"]
//Output: [["is"], ["no", "on"]]
//Explanation: There are 2 groups of anagrams "is" makes group 1. "no", "on" make group 2.
//Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
//Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"], ["rat", "tar", "art"]]
//Explanation:
//Group 1: "abc", "bac", and "cab" are anagrams.
//Group 2: "listen", "silent", and "enlist" are anagrams.
//Group 3: "rat", "tar", and "art" are anagrams.
public class GroupAnagrams {
    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();

        // Loop through the strings
        for (String str : strs) {
            // Sort the string
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);

            // Add the string to the map
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        // Add the values of the map to the result
        for (ArrayList<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<ArrayList<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

}
