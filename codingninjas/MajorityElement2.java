package codingninjas;

import java.util.*;

//Problem statement
//Given an array ‘A’ of ‘N’ integers, find the majority elements of the array.
//
//A majority element in an array ‘A’ of size ‘N’ is an element that appears more than floor(N / 3) times.
//
//Note: The floor function returns the number rounded down to the nearest integer.
//
//Note: Return the array of majority elements in sorted order.
//
//        Example:
//Input: ‘N’ = 9 ‘A’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]
//
//Output: 1
//
//Explanation: The frequency of ‘1’ is 5, which is greater than floor(N / 3), hence ‘1’ is the majority element.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N <= 1e3
//        -1e9 <= A[i] <= 1e9
//
//Time Limit: 1-sec
//Sample Input 1:
//        6
//        1 1 1 2 2 2
//Sample Output 1:
//        1 2
//Explanation Of Sample Input 1:
//Input: ‘N’ = 6, ‘A’ = [1, 1, 1, 2, 2, 2]
//
//Output: [1, 2]
//
//Explanation: The frequency of ‘1’ and ‘2’ is 3, which is greater than floor(N / 3), hence ‘1’ & ‘2’ are the majority elements.
//Sample Input 2:
//        1
//        4
//Sample Output 2:
//        4

public class MajorityElement2 {
    public static List< Integer > majorityElement(int []v) {
        List<Integer> result=new ArrayList<>();
        int value=v.length/3;
        Map<Integer,Integer> map=new HashMap();
        for(int n:v)
            map.put(n,map.getOrDefault(n,0)+1);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>value)
                result.add(entry.getKey());

        }
        Collections.sort(result);
        return result;
        // Write your code here
    }
    public static void main(String[] args) {
        int[] a={3, 3, 4, 2, 4, 4, 2, 4, 4};
        List<Integer> list=majorityElement(a);
        for(int n:list)
            System.out.println(n);
    }

}
