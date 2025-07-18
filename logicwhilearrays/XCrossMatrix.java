package logicwhilearrays;

public class XCrossMatrix {
    public static boolean isXCrossMatrix(int[][] mat) {
        // Handle edge cases: null or non-square matrix
        if (mat == null || mat.length == 0 || mat.length != mat[0].length) {
            return false;
        }

        int n = mat.length;

        // Check main diagonal and anti-diagonal
        for (int i = 0; i < n; i++) {
            // Check main diagonal (MAT[i][i])
            if (mat[i][i] != 1&&mat[i][n - 1 - i] != 1) {
                return false;
            }
            // Check anti-diagonal (MAT[i][n-1-i])

        }

        // Check all other elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && j != n - 1 - i) {
                    if (mat[i][j] != 0)
                        return false;

                }
            }
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Case 1: Valid X cross matrix
        int[][] mat1 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };
        System.out.println("Test Case 1: " + isXCrossMatrix(mat1)); // Expected: true

        // Test Case 2: Invalid (main diagonal has 0)
        int[][] mat2 = {
                {0, 0, 0, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };
        System.out.println("Test Case 2: " + isXCrossMatrix(mat2)); // Expected: false

        // Test Case 3: Invalid (non-diagonal has 1)
        int[][] mat3 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 1}
        };
        System.out.println("Test Case 3: " + isXCrossMatrix(mat3)); // Expected: false

        // Test Case 4: 1x1 matrix
        int[][] mat4 = {{1}};
        System.out.println("Test Case 4: " + isXCrossMatrix(mat4)); // Expected: true

        // Test Case 5: 2x2 matrix
        int[][] mat5 = {
                {1, 1},
                {1, 1}
        };
        System.out.println("Test Case 5: " + isXCrossMatrix(mat5)); // Expected: false
    }
}