import java.util.*;
public class ArraysDemo {
    public static void main(String[] args){
        List<Integer> a2=Arrays.asList(56,78,93,455,1);
        int result = Collections.binarySearch(a2, 93);
        System.out.println("index of 93: "+result);
        int[] a1={65,12,45,89,92};
        Arrays.sort(a1);
        int r1=Arrays.binarySearch(a1,65);
        System.out.println("index of 65: "+r1);
        int sum1=a2.stream().reduce(0,(a,b)->a+b);

    }

    
}
