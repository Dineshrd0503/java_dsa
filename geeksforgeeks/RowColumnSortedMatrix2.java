package geeksforgeeks;

public class RowColumnSortedMatrix2 {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }

        int n = mat.length;      // number of rows
        int m = mat[0].length;   // number of columns
        int row = 0;             // start from the first row
        int col = m - 1;         // start from the last column

        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true; // found the element
            } else if (mat[row][col] > x) {
                col--; // move left
            } else {
                row++; // move down
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = { {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {25, 35, 35, 45},
                        {30, 40, 50, 60}};
        int x = 35;
        System.out.println(matSearch(mat, x)); // Output: true
    }


}
