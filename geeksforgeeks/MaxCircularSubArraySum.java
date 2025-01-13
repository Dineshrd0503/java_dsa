package geeksforgeeks;
//Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.
//
//        Examples:
//
//Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
//Output: 22
//Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
//Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
//Output: 23
//Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
//Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1]
//Output: 52
//Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.
public class MaxCircularSubArraySum {
    public static int circularSubarraySum(int arr[]) {

        // Your code here
        int totalsum=0,currentmax=0;
        int currentmin=0;
        int maxsum=Integer.MIN_VALUE,minsum=Integer.MAX_VALUE;
        for(int n:arr){
            currentmax+=n;
            maxsum=Math.max(maxsum,currentmax);
            if(currentmax<0)
                currentmax=0;
            currentmin+=n;
            minsum=Math.min(minsum,currentmin);
            if(currentmin>0)
                currentmin=0;
            totalsum+=n;

        }
        if(maxsum<0)
            return maxsum;
        int maxcircularsum=totalsum-minsum;
        return Math.max(maxcircularsum,maxsum);

    }

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum circular subarray sum is " + circularSubarraySum(arr));
    }

}
