import java.util.*;
public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {5, 2, 8, 1, 9};
        System.out.println("beofre sortinh ");
        for(int n:arr)
        System.out.print(n + " ");
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
          
            arr[j+1] = key;
    }
    System.out.println("after sorting ");
    for(int n:arr)
    System.out.print(n + " ");

    }
    
}
