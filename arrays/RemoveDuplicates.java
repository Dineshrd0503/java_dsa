package arrays;
import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a={1,2,3,4,3,2,1,5};
        System.out.println("array elements are");
        for(int n:a)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("removing duplicates");
        Set<Integer> set=new HashSet<>();
        for(int n:a){
            if(!(set.contains(n)))
            set.add(n);

        }
        System.out.println("new array is "+set);
    }
}
