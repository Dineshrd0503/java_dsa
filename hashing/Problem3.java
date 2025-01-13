package hashing;
import java.util.*;
//Given an array of n integers, find the sum of the frequencies of the highest occurring number and lowest occurring number.
//
//Example :
//Input: arr = [1, 2, 2, 3, 3, 3]
//Output: 4

public class Problem3 {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(6,3,6,3,6,1);
        System.out.println("elements are");
        for(int n:list)
            System.out.print(n+" ");
        System.out.println();
        findfrequencies(list);
    }
    public static void findfrequencies(List<Integer> list){
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:list)
            map.put(n,map.getOrDefault(n,0)+1);
        System.out.println("frequencies are");
       int high=Integer.MIN_VALUE,low=Integer.MAX_VALUE;
       for(Map.Entry<Integer,Integer> entry:map.entrySet()){
           if(entry.getValue()>high)
               high = entry.getValue();
           if(entry.getValue()<low)
               low=entry.getValue();
       }
        System.out.println("high and low frequnencies are");
        System.out.println(high+" "+low);
        System.out.println("sum is "+(high+low));
    }
}
