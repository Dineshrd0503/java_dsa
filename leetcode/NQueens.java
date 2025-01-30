package leetcode;

import java.util.ArrayList;
import java.util.List;


//Companies
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//
//
//
//Example 1:
//
//
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
//Example 2:
//
//Input: n = 1
//Output: [["Q"]]
//
//
//Constraints:
//
//        1 <= n <= 9

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueensUtil(board, 0, result);
        return result;
    }

    private void solveNQueensUtil(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensUtil(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

}

