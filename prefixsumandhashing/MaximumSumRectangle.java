package prefixsumandhashing;
import java.util.Arrays;

public class  MaximumSumRectangle {
    /**
     * Given a 2D matrix mat[][] with dimensions n×m. Find the maximum possible
     * sum of any submatrix within the given matrix.
     *
     * Examples:
     *
     * Input: mat[][] = [[1, 2, -1, -4, -20], [-8, -3, 4, 2, 1], [3, 8, 10, 1, 3],
     * [-4, -1, 1, 7, -6]]
     * Output: 29
     * Explanation: The matrix is as follows and the green rectangle denotes the
     * maximum sum rectangle which is equal to 29.
     *
     * Input: mat[][] = [[-1, -2], [-3, -4]]
     * Output: -1
     * Explanation: Taking only the first cell is the optimal choice.
     *
     * Constraints:
     * 1 ≤ n, m ≤ 300
     * -1000 ≤ mat[i][j] ≤ 1000
     *
     * Expected Time Complexity: O(n * m^2)
     * Expected Auxiliary Space: O(n)
     *
     * @param mat The 2D matrix.
     * @return The maximum possible sum of any submatrix.
     */
    public int maxRectSum(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        int[] temp = new int[n];

        for (int left = 0; left < m; left++) {
            Arrays.fill(temp, 0);

            for (int right = left; right < m; right++) {
                for (int i = 0; i < n; i++)
                    temp[i] += mat[i][right];

                int currMax = temp[0], currSum = temp[0];
                for (int i = 1; i < n; i++) {
                    currSum = Math.max(temp[i], temp[i] + currSum);
                    currMax = Math.max(currMax, currSum);
                }

                maxSum = Math.max(maxSum, currMax);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumRectangle sol=new MaximumSumRectangle();

        // Example usage 1
        int[][] mat1 = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        System.out.println("Max sum rectangle for mat1: " + sol.maxRectSum(mat1)); // Expected output: 29

        // Example usage 2
        int[][] mat2 = {
                {-1, -2},
                {-3, -4}
        };
        System.out.println("Max sum rectangle for mat2: " + sol.maxRectSum(mat2)); // Expected output: -1

        // Example usage 3
        int[][] mat3 = {{10}};
        System.out.println("Max sum rectangle for mat3: " + sol.maxRectSum(mat3)); // Expected output: 10

         // Example usage 4
         int[][] mat4 = {{-10}};
         System.out.println("Max sum rectangle for mat4: " + sol.maxRectSum(mat4)); // Expected output: -10
    }
}
