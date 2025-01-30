package geeksforgeeks;

import java.util.ArrayList;

import java.util.Arrays;


//The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.
//
//Given an integer n, find all distinct solutions to the n-queens puzzle.
//You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
//For eg. below figure represents a chessboard [3 1 4 2].
//
//
//
//Examples:
//
//Input: n = 1
//Output: [1]
//Explaination: Only one queen can be placed in the single cell available.
//        Input: n = 4
//Output: [[2 4 1 3 ] [3 1 4 2 ]]
//Explaination: There are 2 possible solutions for n = 4.
//Input: n = 2
//Output: []
//Explaination: There are no possible solutions for n = 2.
//Constraints:
//        1 ≤ n ≤ 10
public class NQueens {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> result=new ArrayList();
        int[] board=new int[n];
        Arrays.fill(board,-1);
        solvenqueens(board,0,result);
        return result;
    }
    private static void solvenqueens(int[] board,int row,ArrayList<ArrayList<Integer>> result){
        if(row==board.length){
            ArrayList<Integer> solution=new ArrayList();
            for(int i:board)
                solution.add(i+1);
            result.add(solution);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isvalid(board,row,col)){
                board[row]=col;
                solvenqueens(board,row+1,result);
                board[row]=-1;
            }
        }
    }
    private static boolean isvalid(int[] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i]==col||board[i]-i==col-row||board[i]+i==col+row)
                return false;
        }
        return true;

    }
    public static void main(String[] args) {
        NQueens obj=new NQueens();
        System.out.println(obj.nQueen(4));
    }
}
