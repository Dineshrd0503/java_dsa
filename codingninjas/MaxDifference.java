package codingninjas;

import java.util.Arrays;

//You are given an array 'ARR' of the 'N' element. Your task is to find the maximum difference between any of the two elements from 'ARR'.
//
//If the maximum difference is even print “EVEN” without quotes. If the maximum difference is odd print “ODD” without quotes.
//
//For example:
//
//Given 'ARR' = [1, 10, 5, 2, 8, 1 ] , answer is "ODD".
//Here the maximum difference is between 10 and 1, 10 - 1 = 9

public class MaxDifference {
    public static String maximumDifference(int n, int[] arr) {
        int max= Arrays.stream(arr).max().getAsInt();
        int min=Arrays.stream(arr).min().getAsInt();
        int diff=max-min;
        return diff%2==0?"EVEN":"ODD";
        // Write your code here.
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 7, 5, 3, 9};
        System.out.println(maximumDifference(n, arr));
    }

}
