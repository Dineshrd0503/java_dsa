package leetcode;

//You are given an integer num. You can swap two digits at most once to get the maximum valued number.
//
//Return the maximum valued number you can get.
//
//
//
//Example 1:
//
//Input: num = 2736
//Output: 7236
//Explanation: Swap the number 2 and the number 7.
//Example 2:
//
//Input: num = 9973
//Output: 9973
//Explanation: No swap.


public class MaxValue1Swap {
    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray(); // Convert number to character array
        int n = digits.length;

        // Array to track the position of the largest digit from the current position to the right
        int[] rightMax = new int[n];
        rightMax[n - 1] = n - 1; // Initialize the last position

        // Fill the rightMax array by tracking the maximum digit from the right
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[rightMax[i + 1]]) {
                rightMax[i] = i;
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }

        // Now we check if there's a digit that can be swapped with a larger one
        for (int i = 0; i < n; i++) {
            if (digits[i] < digits[rightMax[i]]) {
                // Swap the digits[i] with digits[rightMax[i]]
                char temp = digits[i];
                digits[i] = digits[rightMax[i]];
                digits[rightMax[i]] = temp;
                break;  // Only one swap is allowed, so we break after swapping
            }
        }

        // Return the result after forming the new number
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {

        // Test case 1
        int num1 = 2736;
        System.out.println("Maximum after swap: " + maximumSwap(num1));  // Output: 7236

        // Test case 2
        int num2 = 9973;
        System.out.println("Maximum after swap: " + maximumSwap(num2));  // Output: 9973
    }
}

