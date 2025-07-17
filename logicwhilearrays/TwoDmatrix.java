package logicwhilearrays;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDmatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter rows ");
        int n=sc.nextInt();
        System.out.println("enter columns");
        int m=sc.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                a[i][j]=sc.nextInt();
        }
        System.out.println("orinting 2d matrix");
        for(int[] row:a){
                System.out.print(Arrays.toString(row)+" ");
            System.out.println();
        }
        System.out.println("print sing nested loops");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                System.out.print(a[i][j]);
            System.out.println();
        }
    }
}
