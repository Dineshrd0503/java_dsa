package strings;


/**
 * Problem Statement:
 * You are given a string 'S' containing 'N' lowercase English characters.
 * In one operation, you can perform the left or right shift on the string 'S'.
 * Determine if you can make the first and last characters equal by performing the operation any number of times.
 * Return '1' if you can. Otherwise, return '0'.
 *
 * The left shift operation on the string 'S' includes updating all the 'S[i]' equal to 'S[i + 1]'
 * for each 'i' from '0' to 'i - 2' and 'S[N - 1]' to 'S[0]' simultaneously.
 * Similarly, the right shift operation on the string 'S' includes updating all the 'S[i]' equal to 'S[i - 1]'
 * for each 'i' from '1' to 'N - 1' and 'S[0]' to 'S[N - 1]' simultaneously.
 * (Note that we are using '0'-based indexing.)
 *
 * Constraints:
 * - 2 <= 'N' <= 10^5
 * - 'a' <= S[i] <= 'z'
 * - Time limit: 1 sec
 *
 * Example:
 * N = 3, S = "abb"
 * In the first operation, we will perform the right shift on 'S', so the resultant string is "bab".
 * As the first and last characters are equal, the answer for this case is '1'.
 *
 * Sample Test Cases:
 * Test Case 1:
 * Input: N = 3, S = "aba"
 * Output: 1
 * Explanation: The first and last characters are already equal ('a' == 'a'), so the answer is 1.
 *
 * Test Case 2:
 * Input: N = 4, S = "abab"
 * Output: 0
 * Explanation: No matter how many shifts we perform, the first and last characters cannot be made equal.
 * The string alternates between "abab" and "baba", and first/last are always different ('a' vs 'b').
 *
 * Test Case 3:
 * Input: N = 6, S = "abcaac"
 * Output: 1
 * Explanation: Adjacent characters S[3] = 'a' and S[4] = 'a' are equal. After 4 left shifts,
 * the string becomes "ac....", where first and last are both 'a'.
 *
 * Test Case 4:
 * Input: N = 6, S = "dcdcdc"
 * Output: 0
 * Explanation: No adjacent characters are equal, so first and last cannot be made equal.
 */
public class StringShiftEqualizer {

    /**
     * Determines if the first and last characters of a string can be made equal
     * by performing left or right shift operations.
     *
     * @param n The length of the string.
     * @param s The input string containing lowercase English characters.
     * @return 1 if the first and last characters can be made equal, 0 otherwise.
     */
    public static int canYouMakeEqual(int n, String s) {
        // Check if first and last characters are already equal (k=0 case)
        if (s.charAt(0) == s.charAt(n - 1)) {
            return 1;
        }

        // Check each adjacent pair S[i] and S[i-1]
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return 1;
            }
        }

        // If no adjacent characters are equal, return 0
        return 0;
    }

    /**
     * Main method to test the canYouMakeEqual method with static inputs (sample test cases).
     */
    public static void main(String[] args) {
        // Test Case 1: N = 3, S = "aba"
        int n1 = 3;
        String s1 = "aba";
        System.out.println("Test Case 1: N = " + n1 + ", S = \"" + s1 + "\"");
        System.out.println("Output: " + canYouMakeEqual(n1, s1)); // Expected: 1

        // Test Case 2: N = 4, S = "abab"
        int n2 = 4;
        String s2 = "abab";
        System.out.println("\nTest Case 2: N = " + n2 + ", S = \"" + s2 + "\"");
        System.out.println("Output: " + canYouMakeEqual(n2, s2)); // Expected: 0

        // Test Case 3: N = 6, S = "abcaac"
        int n3 = 6;
        String s3 = "abcaac";
        System.out.println("\nTest Case 3: N = " + n3 + ", S = \"" + s3 + "\"");
        System.out.println("Output: " + canYouMakeEqual(n3, s3)); // Expected: 1

        // Test Case 4: N = 6, S = "dcdcdc"
        int n4 = 6;
        String s4 = "dcdcdc";
        System.out.println("\nTest Case 4: N = " + n4 + ", S = \"" + s4 + "\"");
        System.out.println("Output: " + canYouMakeEqual(n4, s4)); // Expected: 0
    }
}
