public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;               // Initialize left pointer
        int right = nums.length;    // Initialize right pointer

        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid index

            if (nums[mid] < target) {
                left = mid + 1;      // Move left pointer to mid + 1
            } else {
                right = mid;         // Move right pointer to mid
            }
        }

        // After the loop, left points to the insertion position
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 12;
        int result = searchInsert(nums, target);

        System.out.println("Target " + target + " should be inserted at index: " + result);
    }
}
