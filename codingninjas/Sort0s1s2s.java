package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0};
        sortarray(arr);
        List<Integer> arr1= Arrays.asList(2,0,1,2,0,0,1,2);
        sortArray(arr1,arr1.size());
        for (int num : arr) {
            System.out.print(num + " ");
        }
        for (int num : arr1) {
            System.out.print(num + " ");
        }

    }

    public static void sortarray(int[] a) {
        int low=0,mid=0,high=a.length-1;
        while(mid<=high){
            if(a[mid]==0){
                int temp=a[mid];
                a[mid]=a[low];
                a[low]=temp;
                low++;
                mid++;
            }
            else if(a[mid]==1){
                mid++;
            }
            else{
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }

    }
    public static void sortArray(List<Integer> arr, int n) {
        int zcount=0,ocount=0,tcount=0;
        for(int i=0;i<n;i++){
            if(arr.get(i)==0)
                zcount++;
            else if(arr.get(i)==1)
                ocount++;
            else
                tcount++;
        }
        for(int i=0;i<zcount;i++)
            arr.set(i,0);
        for(int i=zcount;i<zcount+ocount;i++)
            arr.set(i,1);
        for(int i=zcount+ocount;i<n;i++)
            arr.set(i,2);
        // Write your code here.
    }
}
