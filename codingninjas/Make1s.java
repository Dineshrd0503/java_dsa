package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;

//Problem statement
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

public class Make1s {

    // Method to modify the matrix
    public static void setMatrixOnes(ArrayList<ArrayList<Integer>> MAT, int n, int m) {
        boolean[] rowsToUpdate = new boolean[n];
        boolean[] colsToUpdate = new boolean[m];

        // Identify the rows and columns that need updating
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (MAT.get(i).get(j) == 1) {
                    rowsToUpdate[i] = true;
                    colsToUpdate[j] = true;
                }
            }
        }

        // Update the matrix based on rowsToUpdate and colsToUpdate
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rowsToUpdate[i] || colsToUpdate[j]) {
                    MAT.get(i).set(j, 1);
                }
            }
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Initialize the matrix
        ArrayList<ArrayList<Integer>> MAT = new ArrayList<>();
        MAT.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        MAT.add(new ArrayList<>(Arrays.asList(0, 0, 1)));

        // Print the original matrix
        System.out.println("Original Matrix:");
        printMatrix(MAT);

        // Modify the matrix
        setMatrixOnes(MAT, MAT.size(), MAT.get(0).size());

        // Print the modified matrix
        System.out.println("Modified Matrix:");
        printMatrix(MAT);
    }

    // Utility function to print the matrix
    public static void printMatrix(ArrayList<ArrayList<Integer>> MAT) {
        for (ArrayList<Integer> row : MAT) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
