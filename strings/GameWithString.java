package strings;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.HashMap;

public class GameWithString {

    /**
     * Given a string s consisting of lowercase alphabets and an integer k, your task is to find the minimum
     * possible value of the string after removing exactly k characters.
     *
     * The value of the string is defined as the sum of the squares of the frequencies of each distinct
     * character present in the string.
     *
     * Examples :
     *
     * Input: s = "abbccc", k = 2
     * Output: 6
     * Explaination: We remove two 'c' to get the value as 1^2 + 2^2 + 1^2 = 6 or We remove one 'b' and one 'c'
     * to get the value 1^2 + 1^2 + 2^2 = 6.
     *
     * Input: s = "aaab", k = 2
     * Output: 2
     * Explaination: We remove two 'a'. Now we get the value as 1^2 + 1^2 = 2.
     *
     * Constraints:
     * 0 <= k <= s.length() <= 10^5
     *
     * @param s The input string.
     * @param k The number of characters to remove.
     * @return The minimum possible value of the string.
     */
    public static int minValue(String s, int k) {
        // code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int freq : map.values()) {
            queue.offer(freq);
        }

        while (k > 0 && !queue.isEmpty()) {
            int top = queue.poll();
            top--;

            if (top > 0) {
                queue.offer(top);
            }
            k--;
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            int frequency = queue.poll();
            sum += frequency * frequency;
        }

        return sum;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "abbccc";
        int k1 = 2;
        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println("Output: " + minValue(s1, k1)); // Expected output: 6

        String s2 = "aaab";
        int k2 = 2;
        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        System.out.println("Output: " + minValue(s2, k2)); // Expected output: 2

        String s3 = "aabcbcbcabcc";
        int k3 = 3;
        System.out.println("Input: s = \"" + s3 + "\", k = " + k3);
        System.out.println("Output: " + minValue(s3, k3));   // Expected output: 27

        String s4 = "abcde";
        int k4 = 0;
        System.out.println("Input: s = \"" + s4 + "\", k = " + k4);
        System.out.println("Output: " + minValue(s4, k4)); //Expected output 5

        String s5 = "abcde";
        int k5 = 5;
        System.out.println("Input: s = \"" + s5 + "\", k = " + k5);
        System.out.println("Output: " + minValue(s5, k5)); //Expected output 0

        String s6 = "aaaaaaaaaa";
        int k6 = 2;
        System.out.println("Input: s = \"" + s6 + "\", k = " + k6);
        System.out.println("Output: " + minValue(s6, k6)); //Expected output 64

    }
}