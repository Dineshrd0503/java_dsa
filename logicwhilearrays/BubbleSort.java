package logicwhilearrays;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a={-1,2,1,17,56};
        sortarr(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sortarr(int[] a) {
        int n=a.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
