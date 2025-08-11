package arrays;

/*
Problem Statement:
------------------
A square matrix A is said to be "idempotent" if:

    A × A = A

That is, when the matrix is multiplied by itself, the result is the same as the original matrix.

Write a Java method that takes a square matrix as an
ArrayList of ArrayLists of Integers
and checks if it is idempotent.

Input:
- A square matrix (n × n) of integers stored in ArrayList<ArrayList<Integer>>.

Output:
- true  -> if the given matrix is idempotent
- false -> otherwise

Example:
--------
Matrix:
[ [1, 0],
  [0, 0] ]
A × A:
[ [1, 0],
  [0, 0] ]
Since A × A = A, the matrix is idempotent → Output: true
*/

import java.util.ArrayList;

public class IdempotentMatrixChecker {

    public static boolean matrixGame(ArrayList<ArrayList<Integer>> arr) {
        int n = arr.size();

        // Check if matrix is not square
        if (n == 0 || arr.get(0).size() != n) {
            return false;
        }

        // Store result of A × A
        int[][] result = new int[n][n];

        // Matrix multiplication: result[i][j] = sum(A[i][k] * A[k][j])
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0; // Reset for every cell
                for (int k = 0; k < n; k++) {
                    sum += arr.get(i).get(k) * arr.get(k).get(j);
                }
                result[i][j] = sum;
            }
        }

        // Compare result with original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] != arr.get(i).get(j)) {
                    return false; // Not idempotent
                }
            }
        }
        return true; // Idempotent
    }

    // Sample test case
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<Integer>() {{ add(1); add(0); }});
        matrix.add(new ArrayList<Integer>() {{ add(0); add(0); }});

        boolean result = matrixGame(matrix);
        System.out.println("Is Idempotent? " + result); // Expected: true
    }
}

