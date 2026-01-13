package strings;

import java.util.*;
import java.io.*;

public class StringMaina {

    /**
     * Compares two strings based on the given rules
     * @param n Length of str1
     * @param m Length of str2
     * @param str1 First string
     * @param str2 Second string
     * @return 1 if str1 > str2, 0 if equal, -1 if str1 < str2
     */
    public static int stringMania(int n, int m, String str1, String str2) {
        // Compare characters until min length
        int minLen = Math.min(n, m);

        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                // Return 1 if str1[i] > str2[i], else -1
                return str1.charAt(i) > str2.charAt(i) ? 1 : -1;
            }
        }

        // If all characters up to min length are equal, compare lengths
        if (n > m) {
            return 1;      // str1 is longer (better)
        } else if (n < m) {
            return -1;     // str2 is longer (better)
        }

        return 0;          // Both strings are equal
    }

    public static void main(String[] args) {
        System.out.println("=== String Mania Problem ===\n");

        // Test Case 1: First character differs
        String str1_1 = "xyz";
        String str2_1 = "abcd";
        int result1 = stringMania(3, 4, str1_1, str2_1);
        System.out.println("Test 1:");
        System.out.println("STR1 = \"" + str1_1 + "\" (length " + str1_1.length() + ")");
        System.out.println("STR2 = \"" + str2_1 + "\" (length " + str2_1.length() + ")");
        System.out.println("Result: " + result1);
        System.out.println("Explanation: 'x' > 'a', so STR1 is better\n");

        // Test Case 2: All common characters equal, str2 longer
        String str1_2 = "a";
        String str2_2 = "abc";
        int result2 = stringMania(1, 3, str1_2, str2_2);
        System.out.println("Test 2:");
        System.out.println("STR1 = \"" + str1_2 + "\" (length " + str1_2.length() + ")");
        System.out.println("STR2 = \"" + str2_2 + "\" (length " + str2_2.length() + ")");
        System.out.println("Result: " + result2);
        System.out.println("Explanation: Common chars equal, but STR2 is longer, so STR2 is better\n");

        // Test Case 3: Middle character differs
        String str1_3 = "abz";
        String str2_3 = "abc";
        int result3 = stringMania(3, 3, str1_3, str2_3);
        System.out.println("Test 3:");
        System.out.println("STR1 = \"" + str1_3 + "\" (length " + str1_3.length() + ")");
        System.out.println("STR2 = \"" + str2_3 + "\" (length " + str2_3.length() + ")");
        System.out.println("Result: " + result3);
        System.out.println("Explanation: 'z' > 'c' at index 2, so STR1 is better\n");

        // Test Case 4: Both strings identical
        String str1_4 = "acefi";
        String str2_4 = "acefi";
        int result4 = stringMania(5, 5, str1_4, str2_4);
        System.out.println("Test 4:");
        System.out.println("STR1 = \"" + str1_4 + "\" (length " + str1_4.length() + ")");
        System.out.println("STR2 = \"" + str2_4 + "\" (length " + str2_4.length() + ")");
        System.out.println("Result: " + result4);
        System.out.println("Explanation: Both strings are identical, so result is 0\n");

        // Test Case 5: str1 longer
        String str1_5 = "ez";
        String str2_5 = "ehz";
        int result5 = stringMania(2, 3, str1_5, str2_5);
        System.out.println("Test 5:");
        System.out.println("STR1 = \"" + str1_5 + "\" (length " + str1_5.length() + ")");
        System.out.println("STR2 = \"" + str2_5 + "\" (length " + str2_5.length() + ")");
        System.out.println("Result: " + result5);
        System.out.println("Explanation: 'z' > 'h' at index 1, so STR1 is better\n");

        // Test Case 6: str1 shorter, first char same
        String str1_6 = "ags";
        String str2_6 = "agtaa";
        int result6 = stringMania(3, 5, str1_6, str2_6);
        System.out.println("Test 6:");
        System.out.println("STR1 = \"" + str1_6 + "\" (length " + str1_6.length() + ")");
        System.out.println("STR2 = \"" + str2_6 + "\" (length " + str2_6.length() + ")");
        System.out.println("Result: " + result6);
        System.out.println("Explanation: 's' < 't' at index 2, so STR2 is better\n");

        System.out.println("=== All Test Cases Completed ===");
    }
}

