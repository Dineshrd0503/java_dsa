package geeksforgeeks;

import java.util.Arrays;


//You are given two 0-indexed integer arrays, cost and time, of size n representing the costs and the time taken to paint n different walls respectively. There are two painters available:
//
//A paid painter that paints the ith wall in time[i] units of time and takes cost[i] units of money.
//A free painter that paints any wall in 1 unit of time at a cost of 0. But the free painter can only be used if the paid painter is already occupied.
//Return the minimum amount of money required to paint the n walls.
//
//
//
//Example 1:
//
//Input: cost = [1,2,3,2], time = [1,2,3,2]
//Output: 3
//Explanation: The walls at index 0 and 1 will be painted by the paid painter, and it will take 3 units of time; meanwhile, the free painter will paint the walls at index 2 and 3, free of cost in 2 units of time. Thus, the total cost is 1 + 2 = 3.
//Example 2:
//
//Input: cost = [2,3,4,2], time = [1,1,1,1]
//Output: 4
//Explanation: The walls at index 0 and 3 will be painted by the paid painter, and it will take 2 units of time; meanwhile, the free painter will paint the walls at index 1 and 2, free of cost in 2 units of time. Thus, the total cost is 2 + 2 = 4.
//
//
//Constraints:
//
//        1 <= cost.length <= 500
//cost.length == time.length
//1 <= cost[i] <= 106
//        1 <= time[i] <= 500


public class PaintersPartitonProblem {
    public int minTime(int[] arr, int k) {
        // code here
        int low=Arrays.stream(arr).max().getAsInt();
        int high= Arrays.stream(arr).sum();
        while(low<=high){
            int mid=(low+high)/2;
            int painters=findpainters(arr,mid);
            if(painters>k)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }
    private static int findpainters(int[] arr,int maxwork){
        int painters=1;
        int sum=0;
        for(int board:arr){
            if(board+sum<=maxwork)
                sum+=board;
            else{
                painters++;
                sum=board;
            }
        }
        return painters;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40};
        PaintersPartitonProblem obj=new PaintersPartitonProblem();
        System.out.println(obj.minTime(arr,2));
    }
}
