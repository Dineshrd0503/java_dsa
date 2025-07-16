package logicwhilearrays;

import java.util.Arrays;

public class FindPivotSum {
    public static void main(String[] args) {
        int[] a={3,0,1};
        int n = a.length;
        System.out.println("pivot index is "+findPivotIndex(a, n));
    }
    public static int findPivotIndex(int[] a, int n) {
        if (n == 0) return -1; // Handle empty array case
        int totalSum = Arrays.stream(a).sum(); // Calculate total sum of the array
        int leftSum = 0; // Initialize left sum
        for(int i=0;i<n;i++){

            if (leftSum == totalSum - leftSum - a[i])
                return i; // Return the pivot index
            leftSum += a[i]; // Update left sum
        }
        return -1;
    }
}
