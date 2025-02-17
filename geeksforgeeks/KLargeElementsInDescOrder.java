package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;

//Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order.
//
//Examples:
//
//Input: arr[] = [12, 5, 787, 1, 23], k = 2
//Output: [787, 23]
//Explanation: 1st largest element in the array is 787 and second largest is 23.
//Input: arr[] = [1, 23, 12, 9, 30, 2, 50], k = 3
//Output: [50, 30, 23]
//Explanation: Three Largest elements in the array are 50, 30 and 23.
//Input: arr[] = [12, 23], k = 1
//Output: [23]
//Explanation: 1st Largest element in the array is 23.
//Constraints:
//        1 ≤ k ≤ arr.size() ≤ 106
//        1 ≤ arr[i] ≤ 106



public class KLargeElementsInDescOrder {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        ArrayList<Integer> result=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=arr.length-k;i--)
            result.add(arr[i]);
        return result;

    }
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        KLargeElementsInDescOrder obj=new KLargeElementsInDescOrder();
        System.out.println(obj.kLargest(arr,k));
    }
}
