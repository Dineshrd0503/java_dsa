package codingninjas;
import java.util.*;
//Given an array ARR of N integers and an integer S. The task is to find whether there exists a subarray(positive length) of the given array such that the sum of elements of the subarray equals to S or not. If any subarray is found, return the start and end index (0 based index) of the subarray. Otherwise, consider both the START and END indexes as -1.
//
//Note:
//
//If two or more such subarrays exist, return any subarray.
//For Example: If the given array is [1,2,3,4] and the value of S is equal to 7. Then there are two possible subarrays having sums equal to S are [1,2,3] and [3,4].
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N <= 10^5
//        -10^14 <= S <= 10^14
//        -10^9 <= ARR[i] <= 10^9
//
//Time Limit: 1 sec
//Sample Input 1 :
//        2
//        4 5
//        1 3 2 4
//        8 9
//        1 2 3 4 0 4 5 0
//Sample Output 1 :
//Correct
//        Correct
//Explanation Of the Sample Input 1 :
//In the second test case, the elements of the array which make the sum as required are [(2,3,4), (4,5), (2,3,4,0), (4,5,0)] that are continuous. So subarray [2, 3, 4] is returned which is one of the possible subarrays which is why the required output obtained is 'Correct'.
//Sample Input 2 :
//        2
//        4 4
//        1 2 3 4
//        5 0
//        1 2 3 4 5
//Sample Output 2 :
//Correct
//-1 -1
//Explanation Of the Sample Input 2 :
//In the first test case, the possible subarrays are [ [1, 2] , [3] ] . So subarray [3] is returned which is one of the possible subarrays which is why the required output obtained is 'Correct'.
//
//In the second test case, the elements of the array which make the sum as required are not formed by taking any elements as it is even less than the smallest element of the array. Therefore the output here is -1 -1.

public class SubArrayWithGivenSum {
    public static int[] subarraySum(int[] arr, long target) {
        Map<Long,Integer> map=new HashMap<>();
        long currsum=0;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(currsum==target)
                return new int[]{0,i};
            if(map.containsKey(currsum-target))
                return new int[]{map.get(currsum-target)+1,i};
            map.put(currsum,i);
        }
        return new int[]{-1,-1};
        // Write you code here.
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 7, 5};
        long target = 12;
        int[] res = subarraySum(arr, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
