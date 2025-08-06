package strings;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Problem Statement:
 * Given a string s in Roman number format, your task is to convert it to an integer.
 * Various symbols and their values are given below.
 * Note: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 *
 * Examples:
 * Input: s = "IX"
 * Output: 9
 * Explanation: IX is a Roman symbol which represents 10 – 1 = 9.
 *
 * Input: s = "XL"
 * Output: 40
 * Explanation: XL is a Roman symbol which represents 50 – 10 = 40.
 *
 * Input: s = "MCMIV"
 * Output: 1904
 * Explanation: M is 1000, CM is 1000 – 100 = 900, and IV is 4. So we have total as 1000 + 900 + 4 = 1904.
 *
 * Constraints:
 * 1 ≤ roman number ≤ 3999
 * s[i] belongs to [I, V, X, L, C, D, M]
 *
 * Expected Complexities:
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
public class RomanNumberToInteger {

    public int romanToDecimal(String s) {
        // Create a map to store the values of Roman numerals
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Iterate through the Roman numeral string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));

            // If the current value is less than the previous value, subtract it
            // Otherwise, add it to the result
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            // Update the previous value
            prevValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] romanNumerals = {"IX", "XL", "MCMIV", "XIV", "LVIII", "MMXXIII"};

       RomanNumberToInteger solution = new RomanNumberToInteger();

        for (String romanNumeral : romanNumerals) {
            int decimalValue = solution.romanToDecimal(romanNumeral);
            System.out.println("The integer value of " + romanNumeral + " is: " + decimalValue);
        }
    }
}
