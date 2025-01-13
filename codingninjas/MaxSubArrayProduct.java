package codingninjas;

public class MaxSubArrayProduct {
    public static int maxProduct(int[] arr) {
        int prefix=1,suffix=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(prefix==0)
                prefix=1;
            if(suffix==0)
                suffix=1;
            prefix*=arr[i];
            suffix*=arr[arr.length-i-1];
            max=Math.max(max,Math.max(prefix,suffix));
        }
        return max;
        // code here
    }
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxProduct = maxProduct(arr);
        System.out.println("Maximum subarray product: " + maxProduct);
    }
}
