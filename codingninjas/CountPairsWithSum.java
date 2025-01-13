package codingninjas;

import java.util.Arrays;
import java.util.HashMap;
//You have been given an integer array/list(arr) and a number 'Sum'. Find and return the total number of pairs in the array/list which when added, results equal to the 'Sum'.
//
//Note:
//Given array/list can contain duplicate elements.
//
//        (arr[i],arr[j]) and (arr[j],arr[i]) are considered same.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= N <= 10^5
//        -10^4 <= Sum <= 10^4
//        -10^4 <=  arr[ i ] <= 10^4
//
//Time Limit: 1 sec
//Sample Input 1:
//        9 12
//        1 3 6 2 5 4 3 2 4
//Sample Output 1:
//        0
//Explanation For Sample Input 1:
//Since there doesn't exist any pair with a sum equal to 12, so we print 0.
//Sample Input 2:
//        6 10
//        2 8 10 5 -2 5
//Sample Output 2:
//        2
public class CountPairsWithSum {
    public static long pairsWithGivenSum(int arr[], int s)
    {
        Arrays.sort(arr);
        long count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:arr){
            int complement=s-n;
            count+=map.getOrDefault(complement,0);
            map.put(n,map.getOrDefault(n, 0)+1);
        }
        return count;
        //  goes here
    }
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 1};
        int s = 6;
        System.out.println("Number of pairs with sum " + s + ": " + pairsWithGivenSum(arr, s)); // Output: 2
    }
}
