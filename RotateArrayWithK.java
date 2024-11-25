import java.util.Arrays;

public class RotateArrayWithK {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // handle cases where k is greater than nums.length
        reverse(nums, 0, nums.length - 1); // reverse the entire array
        reverse(nums, 0, k - 1); // reverse the first k elements
        reverse(nums, k, nums.length - 1); // reverse the remaining elements
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArrayWithK solution = new RotateArrayWithK ();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Original array: " + Arrays.toString(nums));
        solution.rotate(nums, k);
        System.out.println("Rotated array: " + Arrays.toString(nums));
        System.out.println("whith steps "+k);
    }
}