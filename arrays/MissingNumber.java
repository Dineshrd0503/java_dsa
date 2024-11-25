package arrays;

public class MissingNumber {
        public static void main(String[] args) {
            int[] arr = {1, 2,4,5};
            int missingNumber = missingnumber(arr, arr.length);
            System.out.println("Missing number: " + missingNumber);
        }
        public static int missingnumber(int[] nums, int n) {
            // Calculate the expected sum of first n natural numbers
            int expectedSum = n * (n + 1) / 2;

            // Calculate the actual sum of the array
            int actualSum = 0;
            for (int num : nums) {
                actualSum += num;
            }

            // The missing number is the difference between the expected sum and the actual sum
            return expectedSum - actualSum;
        }

    }
