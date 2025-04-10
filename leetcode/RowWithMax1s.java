package leetcode;

//Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones, and the number of ones in that row.
//
//        In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.
//
//Return an array containing the index of the row, and the number of ones in it.
//
//
//
//        Example 1:
//
//Input: mat = [[0,1],[1,0]]
//Output: [0,1]
//Explanation: Both rows have the same number of 1's. So we return the index of the smaller row, 0, and the maximum count of ones (1). So, the answer is [0,1].
//Example 2:
//
//Input: mat = [[0,0,0],[0,1,1]]
//Output: [1,2]
//Explanation: The row indexed 1 has the maximum count of ones (2). So we return its index, 1, and the count. So, the answer is [1,2].
//Example 3:
//
//Input: mat = [[0,0],[1,1],[0,0]]
//Output: [1,2]
//Explanation: The row indexed 1 has the maximum count of ones (2). So the answer is [1,2].
//
//
//Constraints:
//
//m == mat.length
//n == mat[i].length
//1 <= m, n <= 100
//mat[i][j] is either 0 or 1.


public class RowWithMax1s {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            int count_ones = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count_ones++;
                }
            }
            if (count_ones > max) {
                max = count_ones;
                index = i;
            }
        }
        return new int[] { index, max };
    }

    public static void main(String[] args) {
        RowWithMax1s obj = new RowWithMax1s();
        int[][] mat = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
        int[] res = obj.rowAndMaximumOnes(mat);
        System.out.println("Row with maximum 1s is: " + res[0] + " with " + res[1] + " 1s");
    }

}
