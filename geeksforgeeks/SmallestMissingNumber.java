package geeksforgeeks;

import java.util.Arrays;
//You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
//
//        Note: Positive number starts from 1. The array can have negative integers too.
//
//        Examples:
//
//Input: arr[] = [2, -3, 4, 1, 1, 7]
//Output: 3
//Explanation: Smallest positive missing number is 3.
//Input: arr[] = [5, 3, 2, 5, 1]
//Output: 4
//Explanation: Smallest positive missing number is 4.
//Input: arr[] = [-8, 0, -1, -4, -3]
//Output: 1
//Explanation: Smallest positive missing number is 1.

public class SmallestMissingNumber {
    public static int missingNumber(int[] arr) {
        Arrays.sort(arr);
        int res=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==res)
                res++;
            else if(arr[i]>res)
                break;

        }
        return res;
        // Your code here
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 6, 7, 8};
        System.out.println("Smallest missing number is: " + missingNumber(arr));
    }
}