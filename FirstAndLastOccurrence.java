public class FirstAndLastOccurrence {
    public static int[] findFirstAndLast(int[] nums, int target) {
        int[] result = {-1, -1}; // Initialize result with -1 for both first and last indices

        // Find the first occurrence
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i; // Set first occurrence
                break; // Exit the loop after finding the first occurrence
            }
        }

        // Find the last occurrence
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result[1] = i; // Set last occurrence
                break; // Exit the loop after finding the last occurrence
            }
        }

        return result; // Return the result containing first and last occurrence
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = findFirstAndLast(nums, target);

        System.out.println("First and Last Occurrence of " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}
