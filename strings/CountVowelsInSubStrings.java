package strings;
import java.util.*;
import java.io.*;

public class CountVowelsInSubStrings{

    /**
     * You are given a string ‘str’ of even length. Your task is to find out if we
     * divide the ‘str’ from the middle, will both the substrings contain an equal
     * number of vowels or not.
     *
     * For Example:
     * You are given, ‘str’= ‘codingninjas’, when we split this string we get,
     * ‘coding’ and ‘ninjas’ which both contain 2 vowels each. Hence the answer is
     * ‘True’.
     *
     * Input Format:
     * The first line of input contains a single integer ‘T’, representing the
     * number of test cases.
     * The first line of each test case contains a string ‘str’ representing the
     * given string.
     *
     * Output Format:
     * For each test case, print a "True” or “False" depending on if the halves of
     * the string have an equal number of vowels or not.
     * Print a separate line for each test case.
     *
     * Constraints:
     * 1 <= T <= 10
     * 1 <= |str| <= 10^6
     * ‘str’ will contain upper and lower case characters of the English alphabet.
     * |str| is even.
     * Time Limit: 1 sec.
     *
     * Note :
     * You do not need to print anything. It has already been taken care of. Just
     * implement the given function.
     *
     * Sample Input 1:
     * 2
     * codingninjas
     * helloworld
     *
     * Sample Output 2:
     * True
     * False
     *
     * Explanation:
     * For the first test case, ‘str’= ‘codingninjas’, when we split this string we
     * get, ‘coding’ and ‘ninjas’ which both contain 2 vowels each. Hence the
     * answer is ‘True’.
     * For the second test case, ‘str’= ‘helloworld’, when we split this string we
     * get ‘hello and ‘world’, which contain 2 and 1 vowels respectively. Hence the
     * answer is ‘False’.
     *
     * Sample Input 2:
     * 2
     * Aa
     * AbbaaA
     *
     * Sample Output 2:
     * True
     * False
     *
     * @param str The input string of even length.
     * @return True if the two halves contain an equal number of vowels, False
     *         otherwise.
     */
    public static Boolean splitString(String str) {
        int mid = str.length() / 2;
        String str1 = str.substring(0, mid);
        String str2 = str.substring(mid, str.length());

        int count1 = countvowels(str1);
        int count2 = countvowels(str2);

        return count1 == count2;
    }

    private static int countvowels(String str) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // Predefined test cases
        String[] testCases = {
                "codingninjas",
                "helloworld",
                "Aa",
                "AbbaaA"
        };

        // Number of test cases
        int t = testCases.length;
        System.out.println(t); // Print the number of test cases

        // Process each test case
        for (String str : testCases) {
            System.out.println(str); // Print the input string
            System.out.println(splitString(str)); // Print the result
        }
    }
}