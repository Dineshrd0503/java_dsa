package hashing;
import java.util.*;
//Given an array of n integers, find the second most frequent element in it.
//
//        Example:
//Input: arr[ 1, 2, 2, 3, 3, 3]
//Output: 2

public class Problem2 {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(2,5,1,7,3,2,1,1);
        System.out.println("displaying list");
        for(int n:list)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("finding second most repeated element");
        int secrep=secondrepeated(list);
        System.out.println("Second most repeated element is: "+secrep);
    }
    public static int secondrepeated(List<Integer> list){
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:list)
            map.put(n,map.getOrDefault(n,0)+1);
        int maxcount=0;
        int secondmaxcount=0;
        int firele=-1;
        int secele=-1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int count= entry.getValue();
            int ele= entry.getKey();
            if(count>maxcount){
                secondmaxcount=maxcount;
                secele=firele;
                maxcount=count;
                firele=ele;
            }
            else if(count>secondmaxcount && count<maxcount){
                secondmaxcount=count;
                secele=ele;
            }
        }
        return secele;
    }
}
