package wiprointerviewforda;
import java.util.*;
public class CharFrequency {
    // Problem: Count the frequency of each character in a string using a dictionary
    // Sample Test Cases:
    // Input: str = "hello"
    // Output: {h=1, e=1, l=2, o=1}
    // Input: str = "aabb!!"
    // Output: {a=2, b=2, !=2}
    // Input: str = ""
    // Output: {}

    public static Map<Character, Integer> countFrequency(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return frequency;
    }

    public static void main(String[] args) {
        // Test Case 1
        String str1 = "hello";
        System.out.println("Test Case 1:");
        System.out.println(countFrequency(str1));

        // Test Case 2
        String str2 = "aabb!!";
        System.out.println("\nTest Case 2:");
        System.out.println(countFrequency(str2));

        // Test Case 3
        String str3 = "";
        System.out.println("\nTest Case 3:");
        System.out.println(countFrequency(str3));
    }
}