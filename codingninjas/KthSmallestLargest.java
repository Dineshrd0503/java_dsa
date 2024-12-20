package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//You are given an array ‘Arr’ consisting of ‘N’ distinct integers and a positive integer ‘K’. Find out Kth smallest and Kth largest element of the array. It is guaranteed that K is not greater than the size of the array.
//
//Example:
//
//Let ‘N’ = 4,  ‘Arr’ be [1, 2, 5, 4] and ‘K’ = 3.
//then the elements of this array in ascending order is [1, 2, 4, 5].  Clearly, the 3rd smallest and largest element of this array is 4 and 2 respectively.

public class KthSmallestLargest {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        Collections.sort(arr);
        int smallest=arr.get(k-1);
        int largest=arr.get(n-k);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(smallest);
        list.add(largest);
        return list;
        //Write your code here
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 5, 3, 6, 4));
        int n = 5;
        int k = 2;
        System.out.println(kthSmallLarge(arr, n, k));
    }
}
