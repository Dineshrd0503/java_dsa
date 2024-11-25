package arrays;

public class MaxConsecutive1 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        int maxConsecutiveOnes = maxones(arr);
        System.out.println("Maximum consecutive ones: " + maxConsecutiveOnes);
    }
    public static int maxones(int[] nums) {
        int count=0,max=0;
        for(int n:nums){
            if(n==1){
                count+=1;
                max=Math.max(count,max);
            }
            else
                count=0;
        }
        return max;

    }
}
