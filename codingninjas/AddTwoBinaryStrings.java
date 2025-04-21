package codingninjas;

/**
 * Problem statement:
 *
 * You have been given two binary strings ‘A’ and ‘B’. Your task is to find the sum of both strings
 * in the form of a binary string.
 *
 * Binary strings are the representation of integers in the binary form. For example, the binary
 * strings of 9 and 16 are “1001” and “10000” respectively.
 *
 * Input Format:
 * The first line contains a single integer ‘T’ representing the number of test cases.
 * The second line contains two space-separated integers ‘N’ and ‘M’ which are the length of strings
 * ‘A’ and ‘B’ respectively.
 * The third line of each test case will contain two space-separated binary strings ‘A’ and ‘B’ as described above.
 *
 * Output Format:
 * For each test case, print the sum of the given binary strings in a binary form.
 * Output for every test case will be printed in a separate line.
 *
 * Constraints:
 * 1 <= T <= 5
 * 1 <= N, M <= 5000
 * ‘A’ and ‘B’ consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 * Time limit: 1 sec
 *
 * Sample Input 1:
 * 2
 * 2 2
 * 10 01
 * 3 2
 * 111 10
 *
 * Sample Output 1:
 * 11
 * 1001
 *
 * Explanation of sample input 1:
 * In the first test case, the first string is “10” which is 2 in the decimal format,
 * and the second string is “01” which is 1 in the decimal format. So, 2 + 1 = 3,
 * which is represented as “11” in binary form.
 *
 * In the second test case, the first string is “111” which is 7 in the decimal format,
 * and the second string is “10” which is 2 in the decimal format. So, 7 + 2 = 9,
 * which is represented as “1001” in binary form.
 */

public class AddTwoBinaryStrings {

    public static String addBinaryString(String a, String b, int n, int m) {
        // StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Start from the end of both strings
        int i = n - 1, j = m - 1, carry = 0;

        // Loop until both strings are processed
        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0; // Get the bit from A or 0 if out of bounds
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0; // Get the bit from B or 0 if out of bounds

            // Calculate the sum of both bits and carry
            int sum = bitA + bitB + carry;
            result.append(sum % 2); // Append the resulting bit (0 or 1)
            carry = sum / 2; // Update carry for next iteration

            // Move to the next bits
            i--;
            j--;
        }

        // The result is constructed in reverse order, so we need to reverse it back
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        // Sample test cases
        String A1 = "10", B1 = "01"; // Test case 1
        String A2 = "111", B2 = "10"; // Test case 2

        // Print the results of adding binary strings
        System.out.println(addBinaryString(A1, B1, A1.length(), B1.length())); // Output: "11"
        System.out.println(addBinaryString(A2, B2, A2.length(), B2.length())); // Output: "1001"
    }
}
