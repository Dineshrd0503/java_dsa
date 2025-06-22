package strings;


import java.util.*;
import java.io.*;

public class MirrorStrings {

    /**
     * Problem Statement:
     * You are given a string S containing only uppercase English characters.
     * Find whether S is the same as its reflection in the mirror.
     *
     * For Example, S = “AMAMA” is the same as its reflection in the mirror.
     *
     * Input Format:
     * The first line of input contains an integer T, denoting the number of test cases.
     * The first line of each test case contains a string 'S'.
     *
     * Output Format:
     * For each test case, print a single line containing “YES” or “NO”
     * depending on whether the string 'S' is the same as its reflection in the mirror or not.
     * The output of each test case is printed in a separate line.
     *
     * Note:
     * You do not need to print anything, it has already been taken care of.
     * Just implement the function.
     * The return type of the function is boolean, which returns true
     * if the string is the same as its reflection in the mirror, otherwise returns false.
     *
     * Constraints
     * 1 <= T <=10
     * 1 <= Length(S) <= 10 ^ 5
     * Where ‘T’ is the number of test cases, ‘S’ is the string given in input.
     * Time limit: 1sec.
     *
     * Sample Input 1:
     * 1
     * ITATI
     *
     * Sample Output 1:
     * YES
     *
     * Explanation of sample input 1:
     * String “ITATI” is the same as its reflection in the mirror.
     *
     * Sample Input 2:
     * 2
     * MMMM
     * MZM
     *
     * Sample Output 2:
     * YES
     * NO
     */
    public static Boolean isReflectionEqual(String s) {
        // Write your code here.
        HashSet<Character> set = new HashSet<>(Arrays.asList('A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y'));

        int left = 0, right = s.length() - 1;

        while (left <= right) {
            if (!set.contains(s.charAt(left)) || !set.contains(s.charAt(right)))
                return false;
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Static Input for Test Cases
        String[] testCases = {
                "1",       // Number of test cases
                "ITATI",   // Test case 1
                "2",       // Number of test cases
                "MMMM",    // Test case 1
                "MZM"      // Test case 2
        };

        int testCaseIndex = 0;
        int t = Integer.parseInt(testCases[testCaseIndex++]);

        while (t > 0) {
            String s = testCases[testCaseIndex++];
            boolean result = isReflectionEqual(s);
            System.out.println(result ? "YES" : "NO");
            t--;
        }

        t = Integer.parseInt(testCases[testCaseIndex++]);

        while (t > 0) {
            String s = testCases[testCaseIndex++];
            boolean result = isReflectionEqual(s);
            System.out.println(result ? "YES" : "NO");
            t--;
        }
    }
}
