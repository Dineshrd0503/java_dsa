package arrays;
import java.util.*;
public class SingleElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 5};
        int singleElement = occursonce(arr,arr.length);
        System.out.println("Single element: " + singleElement);
    }
    public static int occursonce(int[] a, int n) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n1:a)
            map.put(n1,map.getOrDefault(n1,0)+1);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return -1;
        // Write your code here.
    }
}
