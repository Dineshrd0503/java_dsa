package geeksforgeeks;
//Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.
//
//Note: A palindrome string is a sequence of characters that reads the same forward and backward.
//
//        Examples:
//
//Input: s = "abc"
//Output: 2
//Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
//Input: s = "aacecaaaa"
//Output: 2
//Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
public class MinCharsForPalindrome {
    public static int minChar(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String newstr = s + "$" + rev;
        int len = lps(newstr);
        return s.length() - len;
        // Write your code here
    }

    private static int lps(String s) {
        int size = s.length();
        int[] lps = new int[size];
        int len = 0, i = 1;
        while (i < size) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    len = 0;
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "AACECAAAA";
        System.out.println(minChar(s));
    }
}
