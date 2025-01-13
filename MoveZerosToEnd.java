public class MoveZerosToEnd {
    public static void moveZeroes(int[] nums) {
        // Pointer to track the position for non-zero elements
        int index = 0;

        // Traverse through the array and move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];  // Move non-zero element to 'index'
                index++;  // Move index to the next position
            }
        }

        // After all non-zero elements are moved, fill the remaining positions with zeros
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        // Print the modified array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
