package dynamicprogramming;

//You are given an array arr[] which represents houses arranged in a circle, where each house has a certain value. A thief aims to maximize the total stolen value without robbing two adjacent houses.
//Determine the maximum amount the thief can steal.
//
//Note: Since the houses are in a circle, the first and last houses are also considered adjacent.
//
//        Examples:
//
//Input: arr[] = [2, 3, 2]
//Output: 3
//Explanation: arr[0] and arr[2] can't be robbed because they are adjacent houses. Thus, 3 is the maximum value thief can rob.
//Input: arr[] = [1, 2, 3, 1]
//Output: 4
//Explanation: Maximum stolen value: arr[0] + arr[2] = 1 + 3 = 4
//Input: arr[] = [2, 2, 3, 1, 2]
//Output: 5
//Explanation: Maximum stolen value: arr[0] + arr[2] = 2 + 3 = 5 or arr[2] + arr[4] = 3 + 2 = 5
//Constraints:
//        2 ≤ arr.size() ≤ 105
//        0 ≤ arr[i] ≤ 104






public class SticklerTheif2 {
    int maxValue(int[] arr) {
        // code here
        int n=arr.length;
        if(arr==null||n==0)
            return 0;
        if(n==1) return arr[0];
        return Math.max(helper(arr,0,n-2),helper(arr,1,n-1));

    }
    private static int helper(int[] arr,int start,int end){
        if(start>end) return 0;
        int prevprev=0,prev=arr[start];
        for(int i=start+1;i<=end;i++){
            int curr=Math.max(prev,prevprev+arr[i]);
            prevprev=prev;
            prev=curr;
        }
        return prev;

    }

    public static void main(String[] args) {
        SticklerTheif2 obj=new SticklerTheif2();
        int[] arr={5,5,10,100,10,5};
        System.out.println(obj.maxValue(arr));
    }
}
