package logicwhilearrays;

import java.util.Arrays;
import java.util.Scanner;

public class MirrorArrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("enter elements of array");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int left=0,right=a.length-1;
        System.out.println(isMirrorArray(a));


    }
    public static boolean isMirrorArray(int[] a){

       int left=0,right=a.length-1;
       while(left<right){
           int temp=a[left];
           if(a[left]!=a[right]) return false;
           a[right]=a[left];
           a[left]=temp;
           left++;
           right--;
       }
        return true;
    }
}
