package codingninjas;

import java.util.HashSet;
import java.util.Set;

public class CheckDifference {
    public static boolean checkDiff(int[] arr, int n, int k)
    {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(arr[i]+k)||set.contains(arr[i]-k))
                return true;
            set.add(arr[i]);
        }
        return false;
    }
    public static void main(String[] args){
        int arr[]={1, 3, 5, 7, 9};
        int n=arr.length;
        int k=2;
        System.out.println(checkDiff(arr, n, k)); // true
    }
}
