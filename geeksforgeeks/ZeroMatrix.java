package geeksforgeeks;
//You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in constant space complexity.
//
//        Examples:
//
//Input: mat[][] = [[1, 1, 1],
//        [1, 0, 1],
//        [1, 1, 1]]
//Output: [[1, 0, 1],
//        [0, 0, 0],
//        [1, 0, 1]]
public class ZeroMatrix {
    public static void setMatrixZeroes(int[][] mat) {
        int row[]=new int[mat.length];
        int col[]=new int[mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(row[i]==1||col[j]==1){
                    mat[i][j]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = { {1, 1, 1}, {1, 0, 1}, {1, 1, 1} };
        System.out.println("Original matrix:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        setMatrixZeroes(mat);
        System.out.println("\nZero matrix after setting zeros to the rows and columns with zeros:");
    }



}
