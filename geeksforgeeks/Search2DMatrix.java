package geeksforgeeks;
//Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
//Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.
//
//Examples:
//
//Input: mat[][] = [[1, 5, 9], [14, 20, 21], [30, 34, 43]], x = 14
//Output: true
//Explanation: 14 is present in the matrix, so output is true.
//Input: mat[][] = [[1, 5, 9, 11], [14, 20, 21, 26], [30, 34, 43, 50]], x = 42
//Output: false
//Explanation: 42 is not present in the matrix.
//Input: mat[][] = [[87, 96, 99], [101, 103, 111]], x = 101
//Output: true
//Explanation: 101 is present in the matrix.
public class Search2DMatrix {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int low=0;
        int m=mat.length;
        int n=mat[0].length;
        int high=(m*n)-1;
        int row=0,col=n-1;
        while(row<m&&col>=0){
            if(mat[row][col]==x)
                return true;
            else if(mat[row][col]>x)
                col--;
            else
                row++;
        }
        return false;

    }
    public static void main(String[] args) {
        Search2DMatrix s = new Search2DMatrix();
        int[][] matrix = { {1, 4, 7, 11, 15},
                          {2, 5, 8, 12, 19},
                          {3, 6, 9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30} };
        System.out.println(s.searchMatrix(matrix, 5)); // true
        System.out.println(s.searchMatrix(matrix, 20)); // false
    }
}
