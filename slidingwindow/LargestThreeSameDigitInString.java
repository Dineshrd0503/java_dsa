package slidingwindow;

/**
 * Problem Statement:
 * You are given a string num representing a large integer. An integer is good if it meets the following conditions:
 * - It is a substring of num with length 3.
 * - It consists of only one unique digit.
 * Return the maximum good integer as a string or an empty string "" if no such integer exists.
 *
 * Constraints:
 * 3 <= num.length <= 1000
 * num only consists of digits.
 */
public class LargestThreeSameDigitInString{
    /**
     * Finds the largest 3-same-digit number in a string.
     *
     * @param num The input string representing a large integer.
     * @return The largest "good" integer (substring of length 3 with same digits), or "" if none exists.
     */
    public String largestGoodInteger(String num) {
        String result = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            String sub = num.substring(i, i + 3);

                if (result.isEmpty() || sub.compareTo(result) > 0) {
                    result = sub;

            }
        }
        return result;
    }

    /**
     * Checks if a string is "good" (length 3, all digits the same).
     *
     * @params The input string.
     * @return True if the string is "good", false otherwise.
     */


    // Another Slidding Window approach


    public static void main(String[] args) {
        LargestThreeSameDigitInString solution = new LargestThreeSameDigitInString();

        // Test cases
        // Expected Output: "777"
        System.out.println(solution.largestGoodInteger("6777133339"));

        // Expected Output: "000"
        System.out.println(solution.largestGoodInteger("2300019"));

        // Expected Output: ""
        System.out.println(solution.largestGoodInteger("42352338"));

        // Expected Output: "999"
        System.out.println(solution.largestGoodInteger("999999"));

        // Expected Output: "888"
        System.out.println(solution.largestGoodInteger("12388856"));

        // Expected Output: "777"

    }
}