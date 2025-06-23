package arrays;


/*
 * Problem: Minimize Sum by Splitting Array into Two Numbers
 * Given an array of single-digit integers, form two numbers by alternating digits
 * in ascending order to minimize their sum, and return the sum as a string with
 * no leading zeros.
 *
 * Input:
 * - T: Number of test cases (hardcoded as 3)
 * - For each test case:
 *   - arr: Array of single-digit integers (0 <= arr[i] <= 9)
 *
 * Output:
 * - For each test case, a string representing the sum of the two numbers formed
 *
 * Example:
 * Test Case 1: arr = [6, 8, 4, 5, 2, 3]
 * Output: 604" (Numbers: 246, 358 -> 246 + 358 = 604)
 * Test Case 2: arr = [5, 3, 0, 7, 4]
 * Output: "482" (Numbers: 035, 47 -> 35 + 447 = 482)
 * Test Case 3: arr = [1]
 * Output: "1" (Number: 1 -> 1 + 0 = 1)
 *
 * Constraints:
 * - 1 <= T <= 10^5
 * - 1 <= arr.length <= 10^5
 * - 0 <= arr[i] <= 9
 * - Time Limit: 1 sec
 */
public class MinimumSum {
    /*
     * Forms two numbers by alternating digits and returns their sum as a string.
     * @param arr Input array of single-digit integers
     * @return String representing the minimum sum
     */
    public String minSum(int[] arr) {
        // Count frequency of each digit
        int[] counts = new int[10];
        for (int digit : arr) {
            counts[digit]++;
        }

        // Form two numbers by alternating digits in ascending order
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        int i = 0, count = 0;
        while (i < 10) {
            if (counts[i] > 0) {
                if (count % 2 == 0) {
                    num1.append(i);
                } else {
                    num2.append(i);
                }
                counts[i]--;
                count++;
            } else {
                i++;
            }
        }

        // Add the two numbers
        return addStrings(num1.toString(), num2.toString());
    }

    /*
     * Adds two numbers represented as strings and returns the sum as a string.
     * @param a First number as string
     * @param b Second number as string
     * @return Sum as string with no leading zeros
     */
    private String addStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        // Add digits from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        // Reverse and remove leading zeros
        result = result.reverse();
        int k = 0;
        while (k < result.length() - 1 && result.charAt(k) == '0') {
            k++;
        }
        return result.substring(k);
    }

    /*
     * Main method with static inputs for test cases.
     */
    public static void main(String[] args) {
        MinimumSum solution = new MinimumSum();

        // Define static test cases
        int[][] testArrays = {
                {6, 8, 4, 5, 2, 3}, // Test Case 1
                {5, 3, 0, 7, 4},    // Test Case 2
                {1}                  // Test Case 3
        };

        // Process each test case
        for (int t = 0; t < testArrays.length; t++) {
            String result = solution.minSum(testArrays[t]);
            System.out.println("Test Case " + (t + 1) + ": " + result);
        }
    }
}