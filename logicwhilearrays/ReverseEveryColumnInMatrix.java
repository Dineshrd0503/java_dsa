package logicwhilearrays;

public class ReverseEveryColumnInMatrix {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = a.length;
        int m = a[0].length;
        for (int j = 0; j < m; j++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = a[left][j];
                a[left][j] = a[right][j];
                a[right][j] = temp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
