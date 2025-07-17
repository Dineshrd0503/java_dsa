package logicwhilearrays;

public class SumOfCornerElementsIn2DArray {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = 0;
        int n = a.length;

        // Adding the corner elements
        sum += a[0][0]; // Top-left
        sum += a[0][n - 1]; // Top-right
        sum += a[n - 1][0]; // Bottom-left
        sum += a[n - 1][n - 1]; // Bottom-right

        System.out.println("Sum of corner elements: " + sum);
    }
}
