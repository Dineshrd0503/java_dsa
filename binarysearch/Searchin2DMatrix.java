package binarysearch;
public class Searchin2DMatrix {
    /**
     * You are given an m x n integer matrix matrix with the following two properties:
     *
     * Each row is sorted in non-decreasing order.
     * The first integer of each row is greater than the last integer of the previous row.
     *
     * Given an integer target, return true if target is in matrix or false otherwise.
     *
     * You must write a solution in O(log(m * n)) time complexity.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * Output: true
     *
     * Example 2:
     *
     *
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * Output: false
     *
     *
     * Constraints:
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        int right=n*m-1;
        int left=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            int row=mid/m,col=mid%m;
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]<target)
                left=mid+1;
            else 
                right=mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        Searchin2DMatrix solution = new Searchin2DMatrix();

        // Example 1
        int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target1 = 3;
        System.out.println("Example 1: " + solution.searchMatrix(matrix1, target1)); // Output: true

        // Example 2
        int[][] matrix2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target2 = 13;
        System.out.println("Example 2: " + solution.searchMatrix(matrix2, target2)); // Output: false

        // Test case 3: Target is the first element
        int[][] matrix3 = {{1, 3}};
        int target3 = 1;
        System.out.println("Test case 3: " + solution.searchMatrix(matrix3, target3)); // Output: true

        // Test case 4: Target is the last element
        int[][] matrix4 = {{1, 3, 5}};
        int target4 = 5;
        System.out.println("Test case 4: " + solution.searchMatrix(matrix4, target4)); // Output: true

        // Test case 5: Target is smaller than smallest element
        int[][] matrix5 = {{2, 4}};
        int target5 = 1;
        System.out.println("Test case 5: " + solution.searchMatrix(matrix5, target5)); // Output: false

        // Test case 6: Target is greater than largest element
        int[][] matrix6 = {{1, 3}};
        int target6 = 4;
        System.out.println("Test case 6: " + solution.searchMatrix(matrix6, target6)); // Output: false

        // Test case 7: Single element matrix and the target is the element
          int[][] matrix7 = {{5}};
          int target7 = 5;
          System.out.println("Test case 7: " + solution.searchMatrix(matrix7,target7)); //output true

          // Test case 8: Single element matrix and the target is not the element
          int[][] matrix8 = {{5}};
          int target8 = 6;
          System.out.println("Test case 8: " + solution.searchMatrix(matrix8,target8)); //output false
    }
}
