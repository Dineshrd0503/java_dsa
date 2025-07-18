package logicwhilearrays;

public class SumOfCornerColumnElements {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9},{1,2,3},{4,5,6}};
        int n = a.length;
        int m = a[0].length;
        int sum = 0;


        for (int i = 0; i < n; i+=2) {

                sum += a[i][0]; // First column
                sum += a[i][m - 1]; // Last column

        }



        System.out.println("Sum of corner column elements: " + sum);
    }
}
