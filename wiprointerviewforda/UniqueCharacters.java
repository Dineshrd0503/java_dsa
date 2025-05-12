package wiprointerviewforda;
import java.util.*;

public class UniqueCharacters {
    // Problem: Check if a string has all unique characters
    // Sample Test Cases:
    // Input: str = "abcde"
    // Output: true
    // Input: str = "hello"
    // Output: false
    // Input: str = ""
    // Output: true

    public static boolean hasUniqueChars(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        String str1 = "abcde";
        System.out.println("Test Case 1:");
        System.out.println(hasUniqueChars(str1));

        // Test Case 2
        String str2 = "hello";
        System.out.println("\nTest Case 2:");
        System.out.println(hasUniqueChars(str2));

        // Test Case 3
        String str3 = "";
        System.out.println("\nTest Case 3:");
        System.out.println(hasUniqueChars(str3));
    }
}