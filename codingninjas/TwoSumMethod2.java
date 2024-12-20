package codingninjas;

import java.util.Arrays;

public class TwoSumMethod2 {
    public static boolean twoSum(int arr[], int target) {
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==target)
                return true;
            else if(arr[i]+arr[j]<target)
                i++;
            else
                j--;
        }
        return false;
        // code here
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 15};
        int target = 17;
        System.out.println(twoSum(arr, target));  // should return true
    }
}
