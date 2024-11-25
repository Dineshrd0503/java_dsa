package codingninjas;

public class MissingNumber {

    // Function to find the missing number in the array
    public static int findMissingNumber(int[] arr, int n) {
        // Calculate the sum of the first n natural numbers
        int expectedSum = n * (n + 1) / 2;

        // Calculate the actual sum of elements in the array
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // The missing number is the difference between the expected sum and actual sum
        return expectedSum - actualSum;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};  // Example array with a missing number
        int n = arr[arr.length-1];  // Array should contain numbers from 1 to 6

        // Call the function to find the missing number
        int missingNumber = findMissingNumber(arr, n);

        // Output the missing number
        System.out.println("The missing number is: " + missingNumber);
    }
}
