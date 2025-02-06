import java.util.ArrayList;
import java.util.Scanner;

/Problem statement
//You have been given a non-empty grid ‘MAT’ consisting of only 0s and 1s. Your task is to modify it in such a way that if a cell has value 1 (MAT[i][j] == 1), then all the cells of the i-th row and j-th column should be changed to 1.
//
//For Example
//If the given grid is this:
//        [0, 0, 0]
//        [0, 0, 1]
//
//Then the modified grid will be
//[0, 0, 1],
//        [1, 1, 1]
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints
//1 <= T <= 100
//        1 <= N <= 50
//        1 <= M <= 50
//        0 <= MAT[i][j] <= 1
//
//Time limit: 1 sec
//Sample Input 1
//        2
//        2 2
//        1 0
//        0 0
//        1 2
//        0 1
//Sample Output 1:
//        1 1
//        1 0
//        1 1
//Explanation of the Sample Input 1
//Test Case 1: For the given grid, the element in the first row and column is 1, thus all the elements in the first row and first column are set to 1.
//
//Test Case 2: For the given grid, there is only one row and the element in this row is 1, thus all elements in the grid are set to 1.
//Sample Input 2
//        2
//        3 4
//        1 0 0 1
//        0 0 1 0
//        0 0 0 0
//        2 3
//        0 0 0
//        0 0 1
//Sample Output 2
//        1 1 1 1
//        1 1 1 1
//        1 0 1 1
//        0 0 1
//        1 1 1


public class SetMatrixOnes {

    public static void setMatrixOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Create boolean arrays to hold row and column information
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        // First traverse the matrix to find which rows and columns need to be set to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat.get(i).get(j) == 1) {
                    rows[i] = true; // Mark this row
                    cols[j] = true; // Mark this column
                }
            }
        }

        // Now set the cells in the matrix based on the marked rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || cols[j]) {
                    mat.get(i).set(j, 1); // Use set to change the value
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of test cases
        int T = scanner.nextInt();
        while (T-- > 0) {
            // Read dimensions of the matrix
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            
            // Create the matrix
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < M; j++) {
                    row.add(scanner.nextInt());
                }
                matrix.add(row);
            }

            // Call the function to modify the matrix
            setMatrixOnes(matrix, N, M);

            // Print the modified matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(matrix.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
}
