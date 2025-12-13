package strings;

/*
 * LEETCODE PROBLEM #3606: COUPON CODE VALIDATOR
 *
 * PROBLEM STATEMENT:
 * You are given three arrays of length n that describe the properties of n coupons:
 * - code[i]: a string representing the coupon identifier
 * - businessLine[i]: a string denoting the business category of the coupon
 * - isActive[i]: a boolean indicating whether the coupon is currently active
 *
 * A coupon is considered VALID if ALL conditions hold:
 * 1. code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9)
 *    and underscores (_)
 * 2. businessLine[i] is one of: "electronics", "grocery", "pharmacy", "restaurant"
 * 3. isActive[i] is true
 *
 * Return an array of the CODES of all valid coupons, sorted:
 * - First by businessLine in order: "electronics", "grocery", "pharmacy", "restaurant"
 * - Then by code in lexicographical (ascending) order within each category
 *
 * EXAMPLE 1:
 * Input:  code = ["SAVE20","","PHARMA5","SAVE@20"],
 *         businessLine = ["restaurant","grocery","pharmacy","restaurant"],
 *         isActive = [true,true,true,true]
 * Output: ["PHARMA5","SAVE20"]
 * Explanation:
 * - "SAVE20": valid (alphanumeric, restaurant, active)
 * - "": invalid (empty code)
 * - "PHARMA5": valid (alphanumeric, pharmacy, active)
 * - "SAVE@20": invalid (contains special character @)
 * Result sorted: pharmacy comes before restaurant, so ["PHARMA5","SAVE20"]
 *
 * EXAMPLE 2:
 * Input:  code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"],
 *         businessLine = ["grocery","electronics","invalid"],
 *         isActive = [false,true,true]
 * Output: ["ELECTRONICS_50"]
 * Explanation:
 * - "GROCERY15": invalid (not active)
 * - "ELECTRONICS_50": valid (alphanumeric with underscore, electronics, active)
 * - "DISCOUNT10": invalid (businessLine is "invalid")
 *
 * CONSTRAINTS:
 * - n == code.length == businessLine.length == isActive.length
 * - 1 <= n <= 100
 * - 0 <= code[i].length, businessLine[i].length <= 100
 * - code[i] and businessLine[i] consist of printable ASCII characters
 * - isActive[i] is either true or false
 *
 * COMPLEXITY:
 * - Time Complexity: O(n log n) due to sorting
 * - Space Complexity: O(n) for storing valid coupons
 */

import java.util.*;

class Solution {

    /**
     * Validates coupons based on three conditions and returns valid codes
     * sorted by business line priority and then lexicographically
     */
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        // Map to store priority of each business line
        // Priority order: electronics(0) < grocery(1) < pharmacy(2) < restaurant(3)
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        // List to store valid coupons as pairs (businessLine, code)
        List<String[]> validCoupons = new ArrayList<>();

        // Iterate through all coupons and apply validation conditions
        for (int i = 0; i < code.length; i++) {
            // Condition 3: Must be active
            if (!isActive[i]) continue;

            // Condition 1a: Code must be non-empty
            if (code[i].isEmpty()) continue;

            // Condition 1b: Code must consist only of alphanumeric characters and underscores
            // Regex pattern: ^ and $ anchor to string start/end
            // [a-zA-Z0-9_]+ matches one or more valid characters
            if (!code[i].matches("^[a-zA-Z0-9_]+$")) continue;

            // Condition 2: BusinessLine must be one of the four valid categories
            if (!priority.containsKey(businessLine[i])) continue;

            // All conditions satisfied - add this coupon to valid list
            validCoupons.add(new String[]{businessLine[i], code[i]});
        }

        // Sort by business line priority first, then by code lexicographically
        // Using a custom comparator
        validCoupons.sort((a, b) -> {
            // Get priority values for both coupons
            int priorityA = priority.get(a[0]);
            int priorityB = priority.get(b[0]);

            // If priorities are different, sort by priority
            if (priorityA != priorityB) {
                return priorityA - priorityB;
            }

            // If priorities are same, sort codes lexicographically
            return a[1].compareTo(b[1]);
        });

        // Extract and return only the codes from valid coupons
        List<String> result = new ArrayList<>();
        for (String[] coupon : validCoupons) {
            result.add(coupon[1]); // Add code (index 1) to result
        }

        return result;
    }
}

/**
 * Main class for testing the solution locally
 */
public class CouponCodeValidatorTest {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic validation with empty string and special character
        System.out.println("===== Test Case 1: Mixed Valid and Invalid =====");
        String[] code1 = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine1 = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive1 = {true, true, true, true};

        System.out.println("Input:");
        System.out.println("  code: " + Arrays.toString(code1));
        System.out.println("  businessLine: " + Arrays.toString(businessLine1));
        System.out.println("  isActive: " + Arrays.toString(isActive1));

        List<String> result1 = solution.validateCoupons(code1, businessLine1, isActive1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: [PHARMA5, SAVE20]");
        System.out.println();

        // Test Case 2: Test inactive coupon and invalid business line
        System.out.println("===== Test Case 2: Inactive Coupons and Invalid BusinessLine =====");
        String[] code2 = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine2 = {"grocery", "electronics", "invalid"};
        boolean[] isActive2 = {false, true, true};

        System.out.println("Input:");
        System.out.println("  code: " + Arrays.toString(code2));
        System.out.println("  businessLine: " + Arrays.toString(businessLine2));
        System.out.println("  isActive: " + Arrays.toString(isActive2));

        List<String> result2 = solution.validateCoupons(code2, businessLine2, isActive2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: [ELECTRONICS_50]");
        System.out.println();

        // Test Case 3: Test sorting within same business line
        System.out.println("===== Test Case 3: Sorting Within Same BusinessLine =====");
        String[] code3 = {"ZCODE", "ACODE", "MCODE"};
        String[] businessLine3 = {"electronics", "electronics", "electronics"};
        boolean[] isActive3 = {true, true, true};

        System.out.println("Input:");
        System.out.println("  code: " + Arrays.toString(code3));
        System.out.println("  businessLine: " + Arrays.toString(businessLine3));
        System.out.println("  isActive: " + Arrays.toString(isActive3));

        List<String> result3 = solution.validateCoupons(code3, businessLine3, isActive3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: [ACODE, MCODE, ZCODE] (lexicographical order)");
        System.out.println();

        // Test Case 4: Test priority ordering across business lines
        System.out.println("===== Test Case 4: Priority Ordering Across BusinessLines =====");
        String[] code4 = {"REST_CODE", "PHARM_CODE", "ELEC_CODE", "GROC_CODE"};
        String[] businessLine4 = {"restaurant", "pharmacy", "electronics", "grocery"};
        boolean[] isActive4 = {true, true, true, true};

        System.out.println("Input:");
        System.out.println("  code: " + Arrays.toString(code4));
        System.out.println("  businessLine: " + Arrays.toString(businessLine4));
        System.out.println("  isActive: " + Arrays.toString(isActive4));

        List<String> result4 = solution.validateCoupons(code4, businessLine4, isActive4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: [ELEC_CODE, GROC_CODE, PHARM_CODE, REST_CODE]");
        System.out.println("(Ordered by priority: electronics < grocery < pharmacy < restaurant)");
        System.out.println();

        // Test Case 5: Test with underscores and numbers
        System.out.println("===== Test Case 5: Special Cases with Underscores and Numbers =====");
        String[] code5 = {"CODE_123", "123_CODE", "_CODE", "CODE_"};
        String[] businessLine5 = {"electronics", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive5 = {true, true, true, true};

        System.out.println("Input:");
        System.out.println("  code: " + Arrays.toString(code5));
        System.out.println("  businessLine: " + Arrays.toString(businessLine5));
        System.out.println("  isActive: " + Arrays.toString(isActive5));

        List<String> result5 = solution.validateCoupons(code5, businessLine5, isActive5);
        System.out.println("Output: " + result5);
        System.out.println("Expected: [CODE_123, 123_CODE, _CODE, CODE_]");
        System.out.println("(All are valid - alphanumeric with underscores)");
    }
}

