package codingninjas6monthschallenge;


//Problem statement
//Given an array 'arr' of size 'N' representing the points associated with each card, and an integer 'K' representing the number of cards to be taken. We need to return the maximum score that can be obtained.
//
//
//
//In each step, we can choose to take one card from either the beginning or the end of the row. We must take exactly ‘K’ cards. The score is calculated as the sum of the points of the cards chosen.
//
//
//
//For Example:
//Input:
//        7 4
//        9 7 5 3 2 1 8
//
//Output:
//        29
//
//Explanation:
//Line 1: Contains ‘N’=7 and ‘K’=4
//Line 2: Contains an array ‘arr’ of size 7.
//
//arr=[9,7,5,3,2,1,8]
//
//First step (K=1): we select 9 from the beginning so sum=9.
//
//Second step (K=2): we select 8 from the end so sum= 9+8.
//
//Third step (K=3): we select 7 from the beginning so sum=9+8+7.
//
//Fourth step (K=4): we select 5 from the beginning so sum=9+8+7+5= 29.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        5 3
//        8 7 5 3 2
//Sample Output 1:
//        20
//Explanation Of Sample Input 1:
//K=1: we select 8 from the beginning so sum=8.
//K=2: we select 7 from the beginning so sum= 8+7.
//K=3: we select 5 from the beginning so sum=8+7+5.
//Sample Input 2:
//        5 5
//        5 4 9 7 8
//Sample Output 2:
//        33
//Constraints:
//        1 <= N <= 10^5
//        0 <= K <= N
//1 <= arr[i] <= 10^4
//
//Time Limit: 1 sec





public class MaxPointsFromCards {
    public static int maxPoints(int []arr , int k){
        // Write your code here.
        int n=arr.length;
        int lsum=0,rsum=0,max=0;
        for(int i=0;i<k;i++)
            lsum+=arr[i];
        max=lsum;
        int rindex=n-1;
        for(int i=k-1;i>=0;i--){
            lsum-=arr[i];
            rsum+=arr[rindex];
            rindex--;
            max=Math.max(max,lsum+rsum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        int k = 3;
        int result = maxPoints(arr, k);
        System.out.println("Maximum points: " + result);
    }
}
