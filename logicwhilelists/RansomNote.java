package logicwhilelists;

import java.util.HashMap;

public class RansomNote{

    /**
     * Checks if ransomNote can be constructed from magazine letters.
     * Each letter in magazine can only be used once.
     *
     * @param ransomNote the string representing the ransom note
     * @param magazine the string representing the magazine letters
     * @return true if ransomNote can be constructed, false otherwise
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count frequency of each character in magazine
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // For each char in ransomNote, check availability in magazine
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                // Character not available or used up
                return false;
            }
            // Use one occurrence of character
            charCount.put(c, charCount.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote solution=new RansomNote();

        // Test cases
        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println("Test case 1: " + solution.canConstruct(ransomNote1, magazine1)); // false

        String ransomNote2 = "aa";
        String magazine2 = "ab";
        System.out.println("Test case 2: " + solution.canConstruct(ransomNote2, magazine2)); // false

        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println("Test case 3: " + solution.canConstruct(ransomNote3, magazine3)); // true
    }
}
