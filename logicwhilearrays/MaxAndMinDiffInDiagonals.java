package logicwhilearrays;

public class MaxAndMinDiffInDiagonals {
    public static void main(String[] args) {
        int[][] a=new int[][]{{11,2,3},{4,15,6},{7,8,9}};
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            int a1=a[i][i];
            if(a1>max) max=a1;
            if(a1<min) min=a1;


        }
        for(int i=0;i<a.length;i++){
            int a1=a[i][a.length-i-1];
            if(a1>max) max=a1;
            if(a1<min) min=a1;


        }
        System.out.println("max is "+max+", "+"min is "+min);
        System.out.println("diff is "+Math.abs(min-max));
    }
}
