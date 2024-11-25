package codingninjas;

import java.util.*;

public class Check2And5{
    static ArrayList<Long> list=new ArrayList<>();
    public static ArrayList<Long> createSequence(long n){
        list.clear();
        for(long i=1;i<=n;i++){
            if(cal(i))
                list.add(i);
        }
        Collections.sort(list);
        return list;
        // Write your code here.
    }
    public static boolean cal(long i){
        while(i>0){
            long a=i%10;
            if(a!=2&&a!=5)
                return false;
            i=i/10;

        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Long> result1 = createSequence(10);
        System.out.println(result1); // Output: [2, 5]

        ArrayList<Long> result2 = createSequence(100);
        System.out.println(result2); // Output: [2, 5, 22, 25, 52, 55]
    }
}