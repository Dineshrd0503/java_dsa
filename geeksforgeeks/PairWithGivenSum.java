package geeksforgeeks;
//You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
//        Note: pairs should have elements of distinct indexes.
//
//        Examples :
//
//Input: arr[] = [-1, 1, 5, 5, 7], target = 6
//Output: 3
//Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
//Input: arr[] = [1, 1, 1, 1], target = 2
//Output: 6
//Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
//Input: arr[] = [-1, 10, 10, 12, 15], target = 125
//Output: 0
//Explanation: There is no such pair which sums up to 4.
public class PairWithGivenSum {
    int countPairs(int arr[], int target) {
        int count=0;
        int left=0,right=arr.length-1;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum<target)
                left++;
            else if(sum>target)
                right--;
            else{
                int e1=arr[left],e2=arr[right];
                int c1=0,c2=0;
                while(left<=right&&arr[left]==e1){
                    left++;
                    c1++;
                }
                while(left<=right&&arr[right]==e2){
                    right--;
                    c2++;
                }
                if(e1==e2)
                    count+=c1*(c1-1)/2;
                else
                    count+=c1*c2;
            }
        }
        return count;
        // Complete the function
    }
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 9, 11, 15};
        int target = 10;
        PairWithGivenSum obj = new PairWithGivenSum();
        System.out.println("Count of pairs is " + obj.countPairs(arr, target));
    }
}

