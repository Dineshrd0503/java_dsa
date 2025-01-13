package codingninjas;
//Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].
//
//Examples :
//
//Input: arr[] = [2, 3, 4, 7, 11], k = 5
//Output: 9
//Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
//Input: arr[] = [1, 2, 3], k = 2
//Output: 5
//Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
//Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
//Output: 2
//Explanation: Missing arre 1, 2, 4, 6… and 2nd missing number is 2.
public class KthMissingValue {
    public static int kthMissing(int[] arr, int k) {
        // code here
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k)
                low=mid+1;
            else
                high=mid-1;
        }
        return low+k;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 8, 10};
        int k = 3;
        System.out.println(kthMissing(arr, k)); // Output: 5
    }

}
