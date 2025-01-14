import java.util.Arrays;

public class ErrorBlocksPos{
    public static int getNumberOfBlocks(int[] heights) {
        // Edge case: If there's only one element, no block is misplaced
        if (heights.length == 1) {
            return 0;
        }

        // Create a copy of the original array to sort
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);

        // Count the number of elements that are misplaced
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                count++;
            }
        }

        // Return the count of misplaced elements
        return count;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] heights1 = {1, 5, 2, 4};
        System.out.println(getNumberOfBlocks(heights1)); // Output: 3

        // Test case 2
        int[] heights2 = {2, 3, 5, 4};
        System.out.println(getNumberOfBlocks(heights2)); // Output: 2

        // Test case 3
        int[] heights3 = {1, 2};
        System.out.println(getNumberOfBlocks(heights3)); // Output: 0

        // Test case 4
        int[] heights4 = {5, 1, 3, 2, 4};
        System.out.println(getNumberOfBlocks(heights4)); // Output: 4
    }
}
