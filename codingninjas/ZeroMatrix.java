package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
//You are given a matrix 'MATRIX' of dimension 'N' x 'M'. Your task is to make all the elements of row 'i' and column 'j' equal to 0 if any element in the ith row or jth column of the matrix is 0.
//
//Note:
//
//        1) The number of rows should be at least 1.
//
//        2) The number of columns should be at least 1.
//Sample Input 1:
//        2 3
//        2 4 3
//        1 0 0
//        Sample Output 1:
//        2 0 0
//        0 0 0
//        Sample Input 2:
//        1 1
//        5
//        Sample Output 2:
//        5



        public class ZeroMatrix {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        // Write your code here
        boolean[] row=new boolean[n];
        boolean[] col=new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]||col[j])
                    matrix.get(i).set(j,0);
            }
        }
        return matrix;
    }
            public static void main(String[] args) {
                // Test input 1
                ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<>(
                        Arrays.asList(
                                new ArrayList<>(Arrays.asList(2, 4, 3)),
                                new ArrayList<>(Arrays.asList(1, 0, 0))
                        )
                );
                System.out.println("Input Matrix: " + matrix1);
                System.out.println("Zeroed Matrix: " + zeroMatrix(matrix1, 2, 3));

                // Test input 2
                ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<>(
                        Arrays.asList(
                                new ArrayList<>(Arrays.asList(5))
                        )
                );
                System.out.println("\nInput Matrix: " + matrix2);
                System.out.println("Zeroed Matrix: " + zeroMatrix(matrix2, 1, 1));
            }
}
