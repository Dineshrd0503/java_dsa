package greedyalgorithms;
import java.util.HashSet;


//Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
//
//Return the minimum number of substrings in such a partition.
//
//Note that each character should belong to exactly one substring in a partition.
//
//
//
//        Example 1:
//
//Input: s = "abacaba"
//Output: 4
//Explanation:
//Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
//It can be shown that 4 is the minimum number of substrings needed.
//        Example 2:
//
//Input: s = "ssssss"
//Output: 6
//Explanation:
//The only valid partition is ("s","s","s","s","s","s").
//
//
//Constraints:
//
//        1 <= s.length <= 105
//s consists of only English lowercase letters.

public class OptimalPartitonOfAString {
    public int partitionString(String s) {
        HashSet<Character> seen = new HashSet<>();
        int partitions = 0; // Start with one partition

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If character is already in the current substring, start a new partition
            if (seen.contains(c)) {
                partitions++; // Increment partition count
                seen.clear(); // Clear the set for a new partition
            }
            // Add current character to the set
            seen.add(c);
        }

        return partitions+1;

    }
    public static void main(String[] args) {
        OptimalPartitonOfAString obj=new OptimalPartitonOfAString();
        System.out.println(obj.partitionString("abac"));
    }

}
