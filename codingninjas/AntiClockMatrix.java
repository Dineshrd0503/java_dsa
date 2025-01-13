package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
//You are given a square matrix of non-negative integers 'MATRIX'. Your task is to rotate that array by 90 degrees in an anti-clockwise direction using constant extra space.
//
//For example:
//
//For given 2D array :
//
//        [    [ 1,  2,  3 ],
//        [ 4,  5,  6 ],
//        [ 7,  8,  9 ]  ]
//
//After 90 degree rotation in anti clockwise direction, it will become:
//
//        [   [ 3,  6,  9 ],
//        [ 2,  5,  8 ],
//        [ 1,  4,  7 ]   ]
public class AntiClockMatrix {
    public static ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> matrix){
        // Write your code here.
        for(int i=0;i<matrix.size();i++){
            for(int j=i+1;j<matrix.size();j++){
                int temp=matrix.get(i).get(j);
                matrix.get(i).set(j,matrix.get(j).get(i));
                matrix.get(j).set(i,temp);

            }
        }
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.size()/2;j++){
                int temp=matrix.get(j).get(i);
                matrix.get(j).set(i,matrix.get(matrix.size()-1-j).get(i));
                matrix.get(matrix.size()-1-j).set(i,temp);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        ArrayList<ArrayList<Integer>> rotatedMatrix = rotateMatrix(matrix);

        for (ArrayList<Integer> row : rotatedMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }


}
