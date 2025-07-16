package logicwhilearrays;

public class RunningSumOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2,3,4};
        int n = arr.length;;

        // Calculate the running sum
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
