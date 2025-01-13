package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Given an array of n integers,  find the most frequent element in it i.e., the element that occurs the maximum number of times.
//
//        Example:
//Input: arr[1, 2, 2, 3, 3, 3]
//Output: 3

public class Problem1 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,3,3,5,6,3,1);
        System.out.println("diplaying list");
        for(int n:list)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("finfing most rrepated element");
        int mostRepeated = repeated(list);
        System.out.println("Most repeated element is: "+mostRepeated);
    }
    public static int repeated(List<Integer> list){
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:list)
            map.put(n,map.getOrDefault(n,0)+1);
        int ele=list.get(0);
        int maxcount=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>maxcount){
                maxcount=entry.getValue();
                ele=entry.getKey();
            }
        }
        return ele;





    }
}

