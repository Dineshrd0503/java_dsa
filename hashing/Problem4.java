package hashing;
import java.util.*;
//Given an array of n integers, find the second most frequent element in it. If there are multiple elements that appear a maximum number of times, find the smallest of them. If second most frequent element does not exist return -1.
//Example 1
//Input: arr = [1, 2, 2, 3, 3, 3]
//Output: 2
//Explanation: The number 2 appears the second most (2 times) and number 3 appears the most(3 times).

public class Problem4 {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,1,2,2,2,3,3);
        System.out.println("elements are");
        for(int n:list)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("finding 2nd most repeated element");
        int secele=findsecfreq(list);
        System.out.println("Second most repeated element is: "+secele);
    }
    public static int findsecfreq(List<Integer> list){
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:list)
            map.put(n,map.getOrDefault(n,0)+1);
        int maxfreq=0,secmaxfreq=0;
        int secele=-1,firstele=-1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            int freq=entry.getValue();
            int ele=entry.getKey();
            if(freq>maxfreq){
                secmaxfreq=maxfreq;
                secele=firstele;
                maxfreq=freq;
                firstele=ele;
            }
            else if(freq<maxfreq&&freq>secmaxfreq){
                secmaxfreq=freq;
                secele=ele;
            }
            else if(freq==secmaxfreq&&ele<secele)
                secele=ele;
        }
        return secele!=-1?secele:-1;
    }

}
