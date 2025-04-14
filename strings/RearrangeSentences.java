package strings;

/**
 * Problem Statement:
 * Given an array of sentences where each sentence starts with an alphanumeric identifier,
 * sort them such that:
 * 1. All letter-sentences (sentences with alphabetic words after the identifier) come before number-sentences
 * 2. Letter-sentences are sorted lexicographically by their content (ignoring identifiers)
 * 3. Number-sentences retain their original order
 *
 * Sample Input 1:
 * ["d1 2 3", "love8 coding world", "a1 coding ninjas"]
 *
 * Sample Output 1:
 * ["a1 coding ninjas", "love8 coding world", "d1 2 3"]
 *
 * Sample Input 2:
 * ["rating1 2143 1706", "g1 raone", "avengers1 assemble"]
 *
 * Sample Output 2:
 * ["avengers1 assemble", "g1 raone", "rating1 2143 1706"]
 */

import java.util.*;

public class RearrangeSentences {

    public static List<String> reOrderSentences(String[] sentences) {
        List<String> letters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        // Separate letter-sentences and number-sentences
        for (String s : sentences) {
            String[] parts = s.split(" ", 2); // Split into identifier and rest
            boolean isNumberSentence = parts.length > 1 &&
                    Character.isDigit(parts[1].charAt(0));
            (isNumberSentence ? numbers : letters).add(s);
        }

        // Sort letter-sentences by content then identifier
        letters.sort((a, b) -> {
            String aContent = a.substring(a.indexOf(' ') + 1);
            String bContent = b.substring(b.indexOf(' ') + 1);
            int contentCompare = aContent.compareTo(bContent);
            return contentCompare != 0 ? contentCompare : a.compareTo(b);
        });

        // Combine results
        List<String> result = new ArrayList<>(letters);
        result.addAll(numbers);
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] input1 = {"d1 2 3", "love8 coding world", "a1 coding ninjas"};
        System.out.println(reOrderSentences(input1));
        // Expected: [a1 coding ninjas, love8 coding world, d1 2 3]

        // Test Case 2
        String[] input2 = {"rating1 2143 1706", "g1 raone", "avengers1 assemble"};
        System.out.println(reOrderSentences(input2));
        // Expected: [avengers1 assemble, g1 raone, rating1 2143 1706]

        // Test Case 3 (From problem statement)
        String[] input3 = {"wait8 opportunity is coming", "coding24 7 365",
                "coding1 2 3 4 5", "goodluck2 you my friend"};
        System.out.println(reOrderSentences(input3));
        // Expected: [wait8 opportunity is coming, goodluck2 you my friend,
        //            coding24 7 365, coding1 2 3 4 5]

        // Test Case 4 (Edge case: empty input)
        String[] input4 = {};
        System.out.println(reOrderSentences(input4));  // Expected: []

        // Test Case 5 (Edge case: all number-sentences)
        String[] input5 = {"a1 1", "b2 2 3", "c3 4"};
        System.out.println(reOrderSentences(input5));  // Expected: [a1 1, b2 2 3, c3 4]
    }
}

