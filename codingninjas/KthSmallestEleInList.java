package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


//You are given an array/list ‘ARR’ consisting of ‘N’ non - negative integers and an integer ‘K’. Your task is to return the K-th smallest element of the array.
//
//For example :-
//
//Given an array/list ‘ARR' = [ 3, 2, 4, 5, 6 ] and 'K' = 3. The 3rd smallest element is "4" because the order of numbers is [ 2, 3, 4, 5, 6 ].
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        2
//        5 2
//        4 5 3 7 6
//        6 3
//        5 2 1 4 3 6
//Sample output 1:
//        4
//        3
//Explanation For Sample Input 1:
//In the first test case, ‘ARR' = [ 4, 5, 3, 7, 6 ] and ‘K' = 2. Then 2nd smallest element is ‘4’ because the order of numbers is [ 3, 4, 5, 6, 7].
//In the second test case, ‘ARR’ = [ 5, 2, 1, 4, 3, 6 ] and ‘K’ = 3. Then 3rd smallest element is ‘3’ because the order of numbers is [ 1, 2, 3, 4, 5, 6 ].
//Sample Input 2:
//        2
//        3 2
//        -1 -2 6
//        4 4
//        4 5 2 1
//Sample output 2:
//        -1
//        5
//Explanation For Sample Input 2:
//In the first test case, ‘ARR' = [ -1, -2, 6 ] and ‘K' = 2. Then the 2nd smallest element is ‘-1’ because the order of numbers is [ -2, -1, 6].
//
//In the second test case, ‘ARR’ = [ 4, 5, 2, 1] and ‘K’ = 4. Then the 4th smallest element is ‘5’ because the order of numbers is [ 1, 2, 4, 5 ].


public class KthSmallestEleInList {
    public static int kthSmallest(ArrayList<Integer> v, int n, int k) {
        // Write your code here.
        Collections.sort(v);
        return v.get(k-1);

    }
    public static void main(String[] args) {
        System.out.println("Kth smallest element in the list");
        ArrayList<Integer> v = new ArrayList<>(Arrays.asList(12, 3, 5, 7, 19));
        int k = 2;
        System.out.println("Kth smallest element is: " + kthSmallest(v, v.size(), k));
    }
}
