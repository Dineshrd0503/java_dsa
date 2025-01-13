package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchIn2DMatrix {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        for(ArrayList<Integer> rows:mat){
            for(int n:rows){
                if(n==target)
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(Arrays.asList(1, 3, 5, 7)));
        mat.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        mat.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
        int target = 3;
        System.out.println(searchMatrix(mat, target)); // should return true
    }
}
