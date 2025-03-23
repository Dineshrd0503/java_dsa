package dynamicprogramming;

//Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two consecutive houses and aims to maximize his total loot.
//Given an array, arr[] where arr[i] represents the amount of money in the i-th house.
//Determine the maximum amount he can loot.
//
//        Examples:
//
//Input: arr[] = [6, 5, 5, 7, 4]
//Output: 15
//Explanation: Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6 + 5 + 4 = 15.
//Input: arr[] = [1, 5, 3]
//Output: 5
//Explanation: Loot only 2nd house and get maximum amount of 5.
//Input: arr[] = [4, 4, 4, 4]
//Output: 8
//Explanation: The optimal choice is to loot every alternate house. Looting the 1st and 3rd houses, or the 2nd and 4th, both give a maximum total of 4 + 4 = 8.
//Constraints:
//        1 ≤ arr.size() ≤ 105
//        1 ≤ arr[i] ≤ 104
//
//Company



public class SticklerTheif1 {
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        if(n==0) return 0;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        int prev2=0;
        int prev1=arr[0];
        for(int i=1;i<n;i++)
        {
            int curr=Math.max(prev2+arr[i],prev1);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;


    }
    public static void main(String[] args) {
        System.out.println("stickler theif");
        SticklerTheif1 obj=new SticklerTheif1();
        int arr[]={5,5,10,100,10,5};
        System.out.println(obj.findMaxSum(arr));
    }
}
