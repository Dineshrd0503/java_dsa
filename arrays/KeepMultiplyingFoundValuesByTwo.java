packaghe arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: 2154. Keep Multiplying Found Values by Two
 *
 * You are given an array of integers nums. You are also given an integer original which is the first number that needs to be searched for in nums.
 *
 * You then do the following steps:
 *
 * If original is found in nums, multiply it by two (i.e., set original = 2 * original).
 * Otherwise, stop the process.
 * Repeat this process with the new number as long as you keep finding the number.
 * Return the final value of original.
 *
 * Example 1:
 * Input: nums = [5,3,6,1,12], original = 3
 * Output: 24
 * Explanation: 
 * - 3 is found in nums. 3 is multiplied by 2 to obtain 6.
 * - 6 is found in nums. 6 is multiplied by 2 to obtain 12.
 * - 12 is found in nums. 12 is multiplied by 2 to obtain 24.
 * - 24 is not found in nums. Thus, 24 is returned.
 *
 * Example 2:
 * Input: nums = [2,7,9], original = 4
 * Output: 4
 * Explanation:
 * - 4 is not found in nums. Thus, 4 is returned.
 *
 * Constraints:
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], original <= 1000
 *
    /**
     * Finds the final value of original after repeatedly multiplying it by two if it is found in nums.
     *
     * @param nums     The array of integers.
     * @param original The initial value to search for.
     * @return The final value of original.
     */
   


public class KeepMultiplyingFoundValuesByTwo {
   public int findFinalValue(int[] nums, int original) {
        int result = original;
        // Use HashSet for efficient lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        while (numSet.contains(result)) {
            result *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        KeepMultiplyingFoundValuesByTwo solution = new KeepMultiplyingFoundValuesByTwo();

        // Test case 1
        int[] nums1 = {5, 3, 6, 1, 12};
        int original1 = 3;
        int result1 = solution.findFinalValue(nums1, original1);
        System.out.println("Test Case 1: " + result1);  // Expected: 24

        // Test case 2
        int[] nums2 = {2, 7, 9};
        int original2 = 4;
        int result2 = solution.findFinalValue(nums2, original2);
        System.out.println("Test Case 2: " + result2);  // Expected: 4

        // Test case 3
        int[] nums3 = {1,2,4,8};
        int original3 = 1;
        int result3 = solution.findFinalValue(nums3,original3);
        System.out.println("Test Case 3: " + result3); //Expected 16

        // Test case 4
        int[] nums4 = {1,2,3};
        int original4 = 5;
        int result4 = solution.findFinalValue(nums4,original4);
        System.out.println("Test Case 4: " + result4); // EXpected 5
       
    }
}
