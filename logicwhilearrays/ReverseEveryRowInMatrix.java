package logicwhilearrays;

public class ReverseEveryRowInMatrix {
    public static void main(String[] args) {
        int[][] a= new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = a.length;
        int m = a[0].length;
        // Reverse each row in the matrix
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            while (left < right) {
                // Swap a[i][left] and a[i][right]
                int temp = a[i][left];
                a[i][left] = a[i][right];
                a[i][right] = temp;
                left++;
                right--;
            }
        }
        // Print the reversed matrix
        System.out.println("Reversed matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
