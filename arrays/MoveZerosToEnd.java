package arrays;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
*/

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] a={0,1,4,0,23,6,0,1,5,0};
        System.out.println("Array before moving zeros to end:");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
        moveZerosToEnd(a);
        System.out.println("Array after moving zeros to end:");
    }

    public static void moveZerosToEnd(int[] a) {
        int index=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                a[index]=a[i];
                index++;
            }
        }
        while(index<a.length){
            a[index]=0;
            index++;

        }
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
}
