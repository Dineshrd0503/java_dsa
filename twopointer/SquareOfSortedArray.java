package twopointer;
public class SquareOfSortedArray {

    /**
     * 977. Squares of a Sorted Array
     *
     * Given an integer array `nums` sorted in **non-decreasing** order, return _an array of **the squares of each number** sorted in non-decreasing order_.
     *
     * **Example 1:**
     *
     * **Input:** nums = [-4,-1,0,3,10]
     * **Output:** [0,1,9,16,100]
     * **Explanation:** After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * **Example 2:**
     *
     * **Input:** nums = [-7,-3,2,3,11]
     * **Output:** [4,9,9,49,121]
     *
     * **Constraints:**
     *
     * *   `1 <= nums.length <= 104`
     * *   `-104 <= nums[i] <= 104`
     * *   `nums` is sorted in **non-decreasing** order.
     *
     * **Follow up:** Squaring each element and sorting the new array is very trivial, could you find an `O(n)` solution using a different approach?
     *
     * @param nums The input array of integers sorted in non-decreasing order.
     * @return An array of the squares of each number in `nums`, sorted in non-decreasing order.
     */
    public int[] sortedSquares(int[] nums) {
        int left=0,right=nums.length-1;
        int index=nums.length-1;
        int[] result=new int[nums.length];
        while(left<=right){
            int leftsquare=nums[left]*nums[left];
            int rightsquare=nums[right]*nums[right];
            if(leftsquare>rightsquare){
                result[index]=leftsquare;
                left++;
            }
            else{
                result[index]=rightsquare;
                right--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        SquareOfSortedArray solution = new SquareOfSortedArray();
        int[] nums1 = {-4,-1,0,3,10};
        int[] result1 = solution.sortedSquares(nums1);
        System.out.print("Input: [-4,-1,0,3,10]  Output: ");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();

        int[] nums2 = {-7,-3,2,3,11};
        int[] result2 = solution.sortedSquares(nums2);
        System.out.print("Input: [-7,-3,2,3,11]  Output: ");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();
    }
}
