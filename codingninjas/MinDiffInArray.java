package codingninjas;

import java.util.Arrays;

//Given an array of integers, print the minimum of the absolute difference of all possible pairs of elements.
//
//        Example :
//N = 5
//ARR = [ 3, -6, 7, -7, 0 ]
//Out of all pairs, (-7,-6) have a difference of ‘1’, and no other pair has less difference. So ‘ANS’ is ‘1’.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 10
//        2 <= N  <= 10^5
//        -10^8 <= ARR[i] <= 10^8
//Sum of N <= 10^5
//
//Time Limit: 1 sec
//Sample Input 1 :
//        2
//        4
//        1 8 3 10
//        2
//        5 5
//Sample Output 1 :
//        2
//        0
//Explanation Of Sample Input 1 :
//For test case 1,
//Out of all pairs (1,3) and (8,10) have the minimum difference ‘2’ so the answer is ‘2’.
//For test case 2,
//There is only one possible pair (5,5) so the answer is ‘0’.
//Sample Input 2 :
//        2
//        3
//        8 1 8
//        2
//        -3 3
//Sample Output 2 :
//        0
//        6
public class MinDiffInArray {
    static int minDiff(int n, int[] arr) {

        // Write your code here.
        Arrays.sort(arr);
        int mindiff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int diff=Math.abs(arr[i]-arr[i-1]);
            if(diff<mindiff)
                mindiff=diff;
        }
        return mindiff;

    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 4, 5, 7, 9};
        System.out.println(minDiff(n, arr));
    }

}
