package logicwhilearrays;

public class CountSetBitsIn2DMatrix {
    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 5, 3,4}, {7, 2, 9,6}, {17, 32, 4,11},{10,3,5,8}};
       countSetBits(a);



    }
    public static void countSetBits(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int[][] a=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                a[i][j]=matrix[i][j]%2;

            }
        }
        for (int i = 0; i < a.length; i++) {
            int count=0;
            for (int j = 0; j < a[i].length; j++) {

                System.out.print(a[i][j] + " ");
                if(a[i][j]==1) count++;
            }
            System.out.println("no.of ones in row "+i+" is "+count);
            System.out.println();
        }
    }
}
