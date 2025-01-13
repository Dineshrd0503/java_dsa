import java.util.*;

public class FlippingMatrix {
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;  // Size of the top-left quadrant
        int maxSum = 0;

        // Traverse the top-left quadrant
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // For each element in the top-left quadrant, find the maximum value by considering flips
                int topLeft = matrix.get(i).get(j);
                int topRight = matrix.get(i).get(2 * n - j - 1);
                int bottomLeft = matrix.get(2 * n - i - 1).get(j);
                int bottomRight = matrix.get(2 * n - i - 1).get(2 * n - j - 1);

                // Add the maximum of the 4 possible values
                maxSum += Math.max(Math.max(topLeft, topRight), Math.max(bottomLeft, bottomRight));
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(112, 42, 83, 119),
                Arrays.asList(56, 125, 56, 49),
                Arrays.asList(15, 78, 101, 43),
                Arrays.asList(62, 98, 114, 108)
        );

        System.out.println(flippingMatrix(matrix));  // Expected Output: 414
    }
}
