package geeksforgeeks;
//Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
//        Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].
//
//Examples :
//
//Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
//Output: true
//Explanation: 9 is present in the matrix, so the output is true.
//Input: mat[][] = [[19, 22, 27, 38, 55, 67]], x = 56
//Output: false
//Explanation: 56 is not present in the matrix, so the output is false.
//Input: mat[][] = [[1, 2, 9],[65, 69, 75]], x = 91
//Output: false
//Explanation: 91 is not present in the matrix.
public class RowSortedMatrixSearch {
    public boolean searchRowMatrix(int[][] mat, int target) {
        for(int i=0;i<mat.length;i++){
            if(search(mat[i],target))
                return true;
        }
        return false;
    }
    private static boolean search(int[] mat,int target) {
        int low = 0;
        int high = mat.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mat[mid] == target)
                return true;
            else if (mat[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;

        }
        return false;

    }

    public static void main(String[] args) {
        int[][] mat = { {10, 20, 30, 40}, {15, 25, 35, 45}, {25, 35, 35, 45}, {40, 45, 45, 45} };
        RowSortedMatrixSearch search = new RowSortedMatrixSearch();
        System.out.println(search.searchRowMatrix(mat, 25)); // true
        System.out.println(search.searchRowMatrix(mat, 50)); // false
    }


}
