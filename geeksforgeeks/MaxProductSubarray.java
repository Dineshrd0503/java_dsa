package geeksforgeeks;
//Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].
//
//Note: It is guaranteed that the output fits in a 32-bit integer.
//
//Examples
//
//Input: arr[] = [-2, 6, -3, -10, 0, 2]
//Output: 180
//Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180.
//Input: arr[] = [-1, -3, -10, 0, 6]
//Output: 30
//Explanation: The subarray with maximum product is {-3, -10} with product = (-3) * (-10) = 30.
//Input: arr[] = [2, 3, 4]
//Output: 24
//Explanation: For an array with all positive elements, the result is product of all elements.

public class MaxProductSubarray {
    public static int maxProduct(int[] arr) {
        int maxproduct=Integer.MIN_VALUE;
        int prefix=1,suffix=1;
        for(int i=0;i<arr.length;i++){
            if(prefix==0)
                prefix=1;
            if(suffix==0)
                suffix=1;
            prefix*=arr[i];
            suffix*=arr[arr.length-i-1];
            maxproduct=Math.max(maxproduct,Math.max(prefix,suffix));

        }
        // code here
        return maxproduct;

    }
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum product subarray is: " + maxProduct(arr));
    }
}
