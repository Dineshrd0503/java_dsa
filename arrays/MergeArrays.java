package arrays;
import java.util.*;
public class MergeArrays {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        System.out.println("Original arrays:");
        System.out.println("Array A: " );
        printArray(a);
        System.out.println("Array B: " );
        printArray(b);



        System.out.println("\nMerged array:"+mergeArrays(a, b));

    }

    public static List<Integer> mergeArrays(int[] a, int[] b) {
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int n:a)
            set.add(n);
        for(int n:b)
            set.add(n);
        for(int n:set)
            list.add(n);
        return list;

    }
    public static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
