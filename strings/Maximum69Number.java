package strings;

/**
 * Problem Statement:
 * You are given a positive integer `num` consisting only of digits `6` and `9`.
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 * Example 1:
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 *
 * Example 2:
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 *
 * Example 3:
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 */

public class Maximum69Number {
    /**
     * Given a positive integer `num` consisting only of digits `6` and `9`,
     * return the maximum number you can get by changing at most one digit.
     *
     * @param num the input integer
     * @return the maximum number you can get by changing at most one digit
     */
    public static int maximum69Number(int num) {
        // 1. Convert the integer to a string.
        String s = String.valueOf(num);

        // 2. Convert the string to a character array.
        char[] arr = s.toCharArray();

        // 3. Iterate over the character array.
        for (int i = 0; i < arr.length; i++) {
            // 4. If the current character is '6', change it to '9' and break the loop.
            if (arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }

        // 5. Convert the character array back to a string and then to an integer.
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        // Test cases
        int num1 = 9669;
        int num2 = 9996;
        int num3 = 9999;

        // Print the results
        System.out.println("Input: " + num1 + ", Output: " + maximum69Number(num1)); // Output: 9969
        System.out.println("Input: " + num2 + ", Output: " + maximum69Number(num2)); // Output: 9999
        System.out.println("Input: " + num3 + ", Output: " + maximum69Number(num3)); // Output: 9999
    }
}
