package geeksforgeeks;
//Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.
//
//        Examples:
//
//Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
//Output: false
//Explanation: 62 is not present in the matrix, so output is false.
//Input: mat[][] = [[18, 21, 27],[38, 55, 67]], x = 55
//Output: true
//Explanation: 55 is present in the matrix.
//        Input: mat[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]], x = 3
//Output: true
//Explanation: 3 is present in the matrix.
public class RowColumnSortedSearch {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        for(int[] rows:mat){
            for(int n:rows){
                if(n==x)
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 35, 35, 45},
                {30, 40, 50, 60}};
        int x = 35;
        System.out.println(matSearch(mat, x)); // Output: true
    }
}
