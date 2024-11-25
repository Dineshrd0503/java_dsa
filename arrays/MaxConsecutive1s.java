package arrays;

public class MaxConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        int maxConsecutiveOnes = maxones(arr.length,arr);
        System.out.println("Maximum consecutive ones: " + maxConsecutiveOnes);
    }
    public static int maxones(int n, int[] arr) {
        int count=0,max=0;
        for(int n1:arr){
            if(n1==1){
                count+=1;
                max=Math.max(count,max);
            }
            else
                count=0;
        }
        return max;
        // Write your code here.
    }
}
