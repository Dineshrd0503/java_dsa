package logicwhilearrays;

import java.util.Arrays;

public class SumOfSmallAndLargestEleIn2DArray {
    public static void main(String[] args) {
        int[][] a=new int[][]{{34,5,678},{3,4,1},{12,56,33}};
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]>max)
                    max=a[i][j];
                if(a[i][j]<min)
                    min=a[i][j];


            }
        }
        for(int[] row:a)
            System.out.println(Arrays.toString(row));
        System.out.println("alrgest is "+max+" smallest is "+min);
    }
}
