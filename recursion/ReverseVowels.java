package recursion;
/**
 * Given a string `s`, reverse only all the vowels in the string and return it.
 *
 * The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`, and they can appear in both lower and upper cases, more than once.
 *
 * **Example 1:**
 *
 * **Input:** s = "IceCreAm"
 *
 * **Output:** "AceCreIm"
 *
 * **Explanation:**
 * The vowels in `s` are `['I', 'e', 'e', 'A']`. On reversing the vowels, s becomes `"AceCreIm"`.
 *
 * **Example 2:**
 *
 * **Input:** s = "leetcode"
 *
 * **Output:** "leotcede"
 *
 * **Constraints:**
 *
 * *   `1 <= s.length <= 3 * 105`
 * *   `s` consist of **printable ASCII** characters.
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] s1 = s.toCharArray();
        reverse(s1, 0, s1.length - 1);
        return new String(s1);
    }

    static void reverse(char[] s, int left, int right) {
        if (left >= right) return;

        while (left < right && "aeiouAEIOU".indexOf(s[left]) == -1)
            left++;

        while (left < right && "aeiouAEIOU".indexOf(s[right]) == -1)
            right--;

        if (left < right && left < s.length && right >= 0) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            reverse(s, left + 1, right - 1);
        }
    }

    public static void main(String[] args) {
      ReverseVowels solution=new ReverseVowels();
        String s1 = "IceCreAm";
        System.out.println("Reverse of " + s1 + " is " + solution.reverseVowels(s1));

        String s2 = "leetcode";
        System.out.println("Reverse of " + s2 + " is " + solution.reverseVowels(s2));

        String s3 ="hello";

        System.out.println("Reverse of "+ s3 + " is " + solution.reverseVowels(s3));
    }
}
