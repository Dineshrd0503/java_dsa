package arrays;
/**
 * Problem: 1437. Check If All 1's Are at Least Length K Places Away
 * Given a binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.
 *
 * Example 1:
 * Input: nums = [1,0,0,0,1,0,0,1], k = 2
 * Output: true
 * Explanation: Each of the 1s are at least 2 places away from each other.
 *
 * Example 2:
 * Input: nums = [1,0,0,1,0,1], k = 2
 * Output: false
 * Explanation: The second 1 and third 1 are only one apart from each other.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] is 0 or 1
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

    /**
     * Checks if all occurrences of 1 within the given array are separated by at least k positions. This approach iterates
     * through the array, tracking the index of the last seen 1. If another 1 is found within k positions of the last,
     * the function immediately returns false. Otherwise, it updates the position of the last seen 1 and continues. If the
     * entire array is processed without finding two occurrences of 1 that are too close, the function returns true.
     *
     * @param nums The binary array to check.
     * @param k The minimum distance between 1s.
     * @return True if all 1s are at least k places apart, false otherwise.
     *
     * Time Complexity: O(n), where n is the length of the nums array. This is because we iterate through the array once.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public boolean kLengthApart(int[] nums, int k) {
        int lastOne = -1; // Initialize the index of the last seen 1 to -1.

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) { // If a 1 is found
                if (lastOne != -1 && i - lastOne <= k) {  // if 'lastOne' has been updated before and distance is <= K we return false
                    return false; // If the distance is not greater than k, return false.
                }
                lastOne = i; // Update the index of the last seen 1.
            }
        }

        return true; // If all 1s are at least k places apart, return true.
    }

    public static void main(String[] args) {
        CheckIfAll1sAreAtLeastLengthKPlacesAway solution = new CheckIfAll1sAreAtLeastLengthKPlacesAway();

        // Test case 1
        int[] nums1 = {1, 0, 0, 0, 1, 0, 0, 1};
        int k1 = 2;
        boolean result1 = solution.kLengthApart(nums1, k1);
        System.out.println("Test Case 1: " + result1); // Expected output: true

        // Test case 2
        int[] nums2 = {1, 0, 0, 1, 0, 1};
        int k2 = 2;
        boolean result2 = solution.kLengthApart(nums2, k2);
        System.out.println("Test Case 2: " + result2); // Expected output: false

        // Test case 3
        int[] nums3 = {0, 1, 0, 1};
        int k3 = 2;
        boolean result3 = solution.kLengthApart(nums3, k3);
        System.out.println("Test Case 3: " + result3); // Expected output: false

        // Test case 4
        int[] nums4 = {1, 1, 1, 1, 1};
        int k4 = 0;
        boolean result4 = solution.kLengthApart(nums4, k4);
        System.out.println("Test Case 4: " + result4); // Expected output: true

        // Test case 5
        int[] nums5 = {1, 0, 0, 1, 0, 1};
        int k5 = 1;
        boolean result5 = solution.kLengthApart(nums5, k5);
        System.out.println("Test Case 5: " + result5); // Expected output: false
    }
}
