package codingninjas;
import java.util.*;
//Sample Input 1:
//        2
//        5
//        2 3 9 2 2
//        4
//        8 5 1 9
//Sample Output 1:
//        2
//        -1
//Explanation of Sample Output 1:
//In test case 1, frequencies of occurrences of different elements are:
//
//        2 → 3 times
//3 → 1 time
//9 → 1 time
//
//As 2 occurs more than floor(5/2) (i.e. floor(2.5) = 2) times, it is the majority element.
//
//In test case 2, frequencies of occurrences of different elements are:
//
//        8 → 1 time
//5 → 1 time
//1 → 1 time
//9 → 1 time
//
//As no element occurs more than floor(4/2) = 2 times. Thus No majority element is present.


public class MajorityElement {
    public static void main(String[] args) {
        System.out.println("finding the majprity element in array");
        int[] a={9,9,9,1,3,5,6};
        int ele=findMajority(a,a.length);
        System.out.println("majority elment is "+ele);

    }
    public static int findMajority(int[] a, int n) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n1:a)
            map.put(n1,map.getOrDefault(n1,0)+1);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>a.length/2)
                return entry.getKey();
        }
        return -1;
        // Write your code here.
    }
}
