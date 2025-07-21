package strings;

/**
 * Problem: Given a string s, return a new string with no three consecutive identical characters.
 * Example: Input: "aaabaaaa"  => Output: "aabaa"
 * The method ensures there are never three adjacent, identical letters in the resulting string.
 */

public class MakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // Skip if adding s.charAt(i) would create three consecutive identical characters
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == s.charAt(i) && s.charAt(i) == sb.charAt(sb.length() - 2)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Test cases
    public static void main(String[] args) {
        MakeFancyString sol = new MakeFancyString();
        System.out.println(sol.makeFancyString("aab"));         // Output: "aab"
        System.out.println(sol.makeFancyString("aaabaaaa"));    // Output: "aabaa"
        System.out.println(sol.makeFancyString("aabbcc"));      // Output: "aabbcc"
        System.out.println(sol.makeFancyString("xxxyyyyzz"));   // Output: "xxyyzz"
        System.out.println(sol.makeFancyString(""));            // Output: ""
        System.out.println(sol.makeFancyString("aaa"));         // Output: "aa"
        System.out.println(sol.makeFancyString("abc"));         // Output: "abc"
    }
}

