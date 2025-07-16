package logicwhilearrays;

import java.util.Stack;

public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] a={8, 1, 2, 2, 3};
        int[] result = smallerNumbersThanCurrent(a);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }

    }

    private static int[] smallerNumbersThanCurrent(int[] a) {
        int n = a.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(a[j]<a[i]){
                    count++;
                }
            }
            a[i]=count; // Store the count of smaller numbers in the same index
        }
        return a; // Return the modified array
    }

}
