package arrays;

public class RightRotateArrayByKSteps {
    /**
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     *
     * Example 1:
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     *
     * Example 2:
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     *
     * Constraints:
     * 1 <= nums.length <= 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     * 0 <= k <= 10^5
     *
     * Follow up:
     * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
     * Could you do it in-place with O(1) extra space?
     *
     * @param nums The input array.
     * @param k The number of steps to rotate the array to the right.
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * Reverses a portion of an array in-place.
     *
     * @param arr   The array to reverse.
     * @param start The starting index (inclusive).
     * @param end   The ending index (inclusive).
     */
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example usage 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        RightRotateArrayByKSteps solution = new RightRotateArrayByKSteps();
        solution.rotate(nums1, k1);
        System.out.print("Example 1: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected output: 5 6 7 1 2 3 4

        // Example usage 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        solution.rotate(nums2, k2);
        System.out.print("Example 2: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected output: 3 99 -1 -100
    }
}