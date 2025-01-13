package codingninjas;
import java.util.HashMap;
import java.util.Map;
//Problem statement
//You are given an array ‘ARR’ having ‘N’ integers. You are also given an integer ‘K’. The task is to count the number of subarrays that have ‘K’ distinct values.
//
//
//
//Subarray: A consecutive sequence of one or more values taken from an array.
//
//
//
//For Example :
//        ‘N’ = 4, ‘K’ = 2
//        ‘ARR’ = [1, 1, 2, 3]
//
//There are ‘3’ subarrays with ‘2’ distinct elements, which are as follows: [1, 2], [2, 3], [1, 1, 2].
//Thus, you should return ‘3’ as the answer.
//        Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        5 2
//        2 1 3 2 4
//Sample Output 1 :
//        9
//Explanation of Sample Input 1 :
//There are ‘4’ subarrays with exactly ‘2’ distinct elements, which are as follows: [2, 1], [1, 3], [3, 2], [2, 4].
//
//Thus, you should return ‘4’ as the answer.
//Sample Input 2 :
//        5 4
//        1 2 3 4 5
//Sample Output 2 :
//        2
//Constraints :
//        1 <= K <= N <= 10^5
//        1 <= Value in each element of ‘ARR’ <= 10^9
//
//Time limit: 1 second
public class SubArrayWithKDisValues {
    public static int kDistinctSubarrays(int[] arr, int n, int k) {

        int count=0;
        for(int start=0;start<n;start++){
            Map<Integer,Integer> map=new HashMap<>();
            int discount=0;
            for(int end=start;end<n;end++){
                if(map.getOrDefault(arr[end],0)==0)
                    discount++;
                map.put(arr[end],map.getOrDefault(arr[end],0)+1);
                if(discount==k)
                    count++;
                if(discount>k)
                    break;

            }

        }

        return count;
        // Write your code here.
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 2, 3};
        int n = arr.length;
        int k = 2;
        System.out.println(kDistinctSubarrays(arr, n, k));
    }

}
