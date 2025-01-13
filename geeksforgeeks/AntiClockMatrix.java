package geeksforgeeks;
//Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space.
//
//        Examples:
//
//Input: mat[][] = [[1, 2, 3],
//        [4, 5, 6]
//        [7, 8, 9]]
//Output: Rotated Matrix:
//        [3, 6, 9]
//        [2, 5, 8]
//        [1, 4, 7]
//Input: mat[][] = [[1, 2],
//        [3, 4]]
//Output: Rotated Matrix:
//        [2, 4]
//        [1, 3]
public class AntiClockMatrix {
    static void rotateby90(int mat[][]) {
        int n = mat.length;

        // Step 1: Transpose the matrix (swap mat[i][j] with mat[j][i] only for i < j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            int top = 0, bottom = n - 1;
            while (top < bottom) {
                int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
        // Step 1: Transpose the matrix in place


        // code here
    }
    static void printMatrix(int mat[][]) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotateby90(matrix);

        System.out.println("\nAnti-Clockwise Rotated Matrix:");
        printMatrix(matrix);
    }
}
