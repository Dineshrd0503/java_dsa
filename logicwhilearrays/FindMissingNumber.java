package logicwhilearrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] a={1, 2, 3, 4, 6};
        System.out.println(findMissingNumber(a));
    }
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int totalSum = n * (n + 1) / 2;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

        }
        return totalSum - sum; // The missing number is the difference between the total sum and the sum of the array
    }

}
