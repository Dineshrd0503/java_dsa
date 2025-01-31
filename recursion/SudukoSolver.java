package recursion;
//
//Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.
//
//A sudoku solution must satisfy all of the following rules:
//
//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.
//
//Examples:
//
//Input: mat[][] =
//
//Output:
//
//Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
//Input: mat[][] =
//
//Output:
//
//Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
//Constraints:
//        mat.size() = 9
//mat[i].size() = 9
//        0 ≤ mat[i][j] ≤ 9




public class SudukoSolver {
    static void solveSudoku(int[][] mat) {
        // code here
        solutionsuduko(mat,0,0);

    }
    static boolean solutionsuduko(int[][] mat,int row,int col){
        if(col==9){
            col=0;
            row++;
        }
        if(row==9) return true;
        if(mat[row][col]!=0)
            return solutionsuduko(mat,row,col+1);
        for(int num=1;num<=9;num++){
            if(isvalid(mat,row,col,num)){
                mat[row][col]=num;
                if(solutionsuduko(mat,row,col+1))
                    return true;
                else
                    mat[row][col]=0;
            }
        }
        return false;
    }
    private static boolean isvalid(int[][] mat,int row,int col,int num){
        for(int i=0;i<9;i++){
            if(mat[i][col]==num)
                return false;
            if(mat[row][i]==num)
                return false;
            if(mat[3*(row/3)+i/3][3*(col/3)+i%3]==num)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("suduko solver");
        int[][] mat={{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 0, 0, 0, 6, 8},
                {0, 0, 0, 8, 0, 6, 0, 0, 3},
                {9, 0, 0, 3, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solveSudoku(mat);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++)
                System.out.print(mat[i][j]+" ");
            System.out.println();
        }
    }
}
