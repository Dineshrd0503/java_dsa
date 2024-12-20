package codingninjas;

public class BinarySearch {
    public static int search(int []nums, int target) {
        int low=0,high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;

        }
        return -1;

        // Write your code here.
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;
        System.out.println(search(nums, target)); // Output: 6
        target = 93;
        System.out.println(search(nums, target)); // Output: -1
    }
}
