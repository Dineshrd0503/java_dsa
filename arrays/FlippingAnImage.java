package arrays;

/**
 * Problem: Flipping an Image
 *
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * For example, inverting [0,1,1] results in [1,0,0].
 *
 * Example 1:
 * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * Example 2:
 * Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * Constraints:
 * - n == image.length
 * - n == image[i].length
 * - 1 <= n <= 20
 * - image[i][j] is either 0 or 1.
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        // Iterate over each row
        for (int i = 0; i < n; i++) {
            // Iterate up to the middle of the row (inclusive for odd n)
            for (int j = 0; j <= (n - 1) / 2; j++) {
                // Swap and invert elements at (i, j) and (i, n-1-j)
                int temp = image[i][j];
                image[i][j] = 1 - image[i][n - 1 - j];
                image[i][n - 1 - j] = 1 - temp;
            }
        }

        return image;
    }

    // Main method to test the solution with static inputs
    public static void main(String[] args) {
        FlippingAnImage solution = new FlippingAnImage();

        // Helper method to print the matrix
        printMatrix("Test Case 1:");
        // Test Case 1: [[1,1,0],[1,0,1],[0,0,0]]
        int[][] image1 = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        printMatrix("Input:", image1);
        int[][] result1 = solution.flipAndInvertImage(image1);
        printMatrix("Output:", result1);

        printMatrix("\nTest Case 2:");
        // Test Case 2: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
        int[][] image2 = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };
        printMatrix("Input:", image2);
        int[][] result2 = solution.flipAndInvertImage(image2);
        printMatrix("Output:", result2);
    }

    // Helper method to print the matrix with a label
    private static void printMatrix(String label) {
        System.out.println(label);
    }

    private static void printMatrix(String label, int[][] matrix) {
        System.out.println(label);
        for (int[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}