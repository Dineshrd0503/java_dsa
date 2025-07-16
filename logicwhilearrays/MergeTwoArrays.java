package logicwhilearrays;

import java.util.Arrays;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,5};
        int[] b={6,7,8,9,10};
        int[] mergedArray = mergeArrays(a, b);
        System.out.println("Merged Array: "+ Arrays.toString(mergedArray));
    }
    public static int[] mergeArrays(int[] a, int[] b) {
        if (a == null || b == null) return null;
        int[] merged = new int[a.length + b.length];
        int i=0,j=0,k=0;
        while(i<a.length&&j<b.length){
            if(a[i]<b[j])
                merged[k++]=a[i++];
            else
                merged[k++]=b[j++];
        }
        while(i<a.length)
            merged[k++]=a[i++];
        while(j<b.length)
            merged[k++]=b[j++];
        return merged;
    }
}
