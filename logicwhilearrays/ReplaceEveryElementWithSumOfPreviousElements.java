package logicwhilearrays;

import java.util.Arrays;
/*
Given an integer array, replace every element with the sum of all previous elements (excluding itself). The first element remains unchanged.

Sample Input:
a = {1, 2, 3, 4, 5}
Sample Output:
[1, 1, 3, 6, 10]
 */

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
