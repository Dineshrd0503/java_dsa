package arrays;

import java.util.ArrayList;
import java.util.List;

public class RowWaveForm {
    // Problem Statement:
    // Given a 2D array (matrix) of integers, return a 1D array (list) that represents
    // the elements of the matrix in a wave-like manner. The wave pattern is defined as follows:
    // - For even indexed rows, traverse the row from left to right.
    // - For odd indexed rows, traverse the row from right to left.

    public static ArrayList<Integer> rowWaveForm(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(i).size(); j++) {
                if (i % 2 == 0) {
                    result.add(mat.get(i).get(j));
                } else {
                    result.add(mat.get(i).get(mat.get(i).size() - 1 - j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Sample Test Cases
        // Test Case 1:
        // Input:
        // [[1, 2, 3],
        //  [4, 5, 6],
        //  [7, 8, 9]]
        // Output: [1, 2, 3, 6, 5, 4, 7, 8, 9]

        ArrayList<ArrayList<Integer>> mat1 = new ArrayList<>();
        mat1.add(new ArrayList<>(List.of(1, 2, 3)));
        mat1.add(new ArrayList<>(List.of(4, 5, 6)));
        mat1.add(new ArrayList<>(List.of(7, 8, 9)));
        System.out.println(rowWaveForm(mat1));

        // Test Case 2:
        // Input:
        // [[10, 20],
        //  [30, 40],
        //  [50, 60]]
        // Output: [10, 20, 40, 30, 50, 60]

        ArrayList<ArrayList<Integer>> mat2 = new ArrayList<>();
        mat2.add(new ArrayList<>(List.of(10, 20)));
        mat2.add(new ArrayList<>(List.of(30, 40)));
        mat2.add(new ArrayList<>(List.of(50, 60)));
        System.out.println(rowWaveForm(mat2));
    }
}
