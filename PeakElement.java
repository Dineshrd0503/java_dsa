public class PeakElement {
    public static  int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        // Check if the first element is the peak
        if (nums[0] > nums[1]) {
            return 0;
        }

        // Check if the last element is the peak
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        // Check for peaks in the middle of the array
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        // If no peak is found, return the last element
        return nums.length - 1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 1};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}
