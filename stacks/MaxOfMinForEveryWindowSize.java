package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, where the window size ranges from 1 to arr.size().
//
//More formally, for each window size k, determine the smallest element in all windows of size k, and then find the largest value among these minimums where 1<=k<=arr.size().
//
//Examples :
//
//Input: arr[] = [10, 20, 30, 50, 10, 70, 30]
//Output: [70, 30, 20, 10, 10, 10, 10]
//Explanation:
//        1. First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are [10], [20], [30], [50], [10], [70] and [30]. Maximum of these minimums is 70.
//        2. Second element in output indicates maximum of minimums of all windows of size 2. Minimums of windows of size 2 are [10], [20], [30], [10], [10], and [30]. Maximum of these minimums is 30.
//        3. Third element in output indicates maximum of minimums of all windows of size 3. Minimums of windows of size 3 are [10], [20], [10], [10] and [10]. Maximum of these minimums is 20.
//Similarly other elements of output are computed.
//        Input: arr[] = [10, 20, 30]
//Output: [30, 20, 10]
//Explanation: First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are [10] , [20] , [30]. Maximum of these minimums are 30 and similarly other outputs can be computed
//Constraints:
//        1 <= arr.size() <= 105
//        1 <= arr[i] <= 106




public class MaxOfMinForEveryWindowSize {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n=arr.length;
        int[] prevsmaller=new int[n];
        int[] nextsmaller=new int[n];
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i])
                stack.pop();
            prevsmaller[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i])
                stack.pop();
            nextsmaller[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);

        }
        Arrays.fill(res,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            int windowsize=nextsmaller[i]-prevsmaller[i]-1;
            res[windowsize-1]=Math.max(res[windowsize-1],arr[i]);
        }
        for(int i=n-2;i>=0;i--){
            res[i]=Math.max(res[i],res[i+1]);

        }
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++)
            result.add(res[i]);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Max of Min for every window size");
        int[] arr={10, 20, 30, 50, 10, 70, 30};
        MaxOfMinForEveryWindowSize obj=new MaxOfMinForEveryWindowSize();
        System.out.println(obj.maxOfMins(arr));
    }

}
