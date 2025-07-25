package strings;

import java.util.*;
import java.io.*;

public class StringsComparison {

    /**
     * Problem Statement:
     * Rohit loves strings. But he has many strings with him, and he is confused about which one he loves more.
     * So he decided to come up with a scoring system for the strings.
     * The scoring system took two strings as input, let's call them ‘STR1’ and ‘STR2’ of length ‘N’ and length ‘M’ respectively.
     *
     * The system will return ‘1’ if ‘STR1’ is better than ‘STR2’.
     * The system will return ‘0’ if ‘STR1’ is the same as ‘STR2’.
     * The system will return ‘-1’ if ‘STR2’ is better than ‘STR1’.
     *
     * To decide which string is better he followed the below steps.
     * Let’s suppose there exists a index ‘i’ such that ‘0’ <= ‘i’ < ‘min(N,M)’ and for all ‘j<i’, ‘STR1[j]’ is equal to ‘STR2[j]’, and ‘STR1[i] != STR2[i]’.
     * Then if ‘STR1[i]>STR2[i]’, ‘STR1’ is better otherwise if ‘STR2[i]>STR1[i]’, ‘STR2’ is better,
     * And if there doesn’t exist any such ‘i’ then if ‘N>M’, ‘STR1’ is better,
     * And if ‘N<M’, ‘STR2’ is better, and if ‘N’ is equal to ‘M’, both strings are the same.
     * But Rohit has so many strings, so he doesn’t have time to go through all strings,
     * So being his friend can you help him automate this process?.
     *
     * Example:
     * Input: ‘N’ = 3, ‘M’ = 4, ‘STR1’ = xyz, ‘STR2’ = abcd
     * Output: 1
     * In this case, ‘STR1[0]>STR2[0]’ hence ‘STR1’ is better than ‘STR2’. Hence the output will be ‘1’.
     *
     * Input Format:
     * The first line will contain the integer 'T', the number of test cases.
     * Each test case consists of two lines.
     * The first line of input contains two integers, ‘N’ and ‘M’ separated by spaces.
     * Followed by two lines containing strings ‘STR1’ of length ‘N’ and ‘STR2’ of length ‘M’.
     *
     * Output format:
     * For each test case, print ‘1’ or ‘0’ or ‘-1’ depending on the relation between ‘STR1’ and ‘STR2’.
     *
     * Constraints:
     * 1 <= ‘T’ <= 10
     * 1 <= ‘N’ <= 10^5
     * 1 <= ‘M’ <= 10^5
     * ‘STR1’ and ‘STR2’ consists of lowercase letters.
     * It is guaranteed that sum of ‘N’ over all test cases is <= 10^5
     * It is guaranteed that sum of ‘M’ over all test cases is <= 10^5
     * Time Limit: 1 sec
     *
     * Sample Input 1 :
     * 2
     * 1 3
     * a
     * abc
     * 3 3
     * abz
     * abc
     *
     * Sample Output 1 :
     * -1
     * 1
     *
     * Sample Input 2 :
     * 3
     * 2 3
     * ez
     * ehz
     * 5 5
     * acefi
     * acefi
     * 3 5
     * ags
     * agtaa
     *
     * Sample Output 2 :
     * 1
     * 0
     * -1
     *
     * @param n Length of str1
     * @param m Length of str2
     * @param str1 First string
     * @param str2 Second string
     * @return 1 if str1 is better, 0 if they are the same, -1 if str2 is better
     */
    public static int stringMania(int n, int m, String str1, String str2) {
        int minlen = Math.min(n, m);

        for (int i = 0; i < minlen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (str1.charAt(i) > str2.charAt(i))
                    return 1;
                else return -1;
            }
        }

        if (n > m) return 1;
        else if (m > n) return -1;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        // Static Inputs for testing
        int t = 3; // Number of test cases
        int[] n = {1, 3, 2};
        int[] m = {3, 3, 3};
        String[] str1 = {"a", "abz", "ez"};
        String[] str2 = {"abc", "abc", "ehz"};

        for (int i = 0; i < t; i++) {
            int result = stringMania(n[i], m[i], str1[i], str2[i]);
            System.out.println(result);
        }
    }
}