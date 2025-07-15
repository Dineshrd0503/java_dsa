package logicwhilearrays;

import java.util.Arrays;

public class ReplaceEveryElementWithSumOfPreviousElements {
    public static void main(String[] args) {
        int[] a={1, 2, 3, 4, 5};
        int sum=0,n=a.length;
        int[] b=new int[n];
        b[0]=a[0];
        for(int i=1;i<n;i++){
            sum+=a[i-1];
            b[i]=sum;
        }
        System.out.println(Arrays.toString(b));
    }
}
