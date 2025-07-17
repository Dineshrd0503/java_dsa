package logicwhilearrays;

public class DiffofDiagonalsIn2Dmatrix {
    public static void main(String[] args) {
        int[][] a=new int[][]{{1,2,13},{4,5,6},{7,8,9}};
        int n=a.length;
        int lsum=0,rsum=0;
        for(int i=0;i<n;i++){
            lsum+=a[i][i];
            rsum+=a[i][n-i-1];
        }
        System.out.println(Math.abs(lsum-rsum));

    }
}
