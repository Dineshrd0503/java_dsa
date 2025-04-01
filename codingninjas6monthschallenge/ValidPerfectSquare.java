package codingninjas6monthschallenge;
/*
Problem Statement:
You have been given an integer ‘N’. You are supposed to find if the given integer ‘N’ is a perfect square or not.
A perfect square is an integer that is the square of an integer.

Detailed Explanation (Input/Output Format, Notes, Images):
Constraints:
1 <= T <= 50
1 <= N <= 10^18

Time Limit: 1 sec

Sample Input 1:
2
4
7    

Sample Output 1:
Yes
No

Explanation of Sample Output 1:
In test case 1, since (2 * 2 == 4) so print “Yes”.
In test case 2, 7 is not a perfect square so print “No”.

Sample Input 2:
2
15
121

Sample Output 2:
No
Yes

Explanation of Sample Output 2:
In test case 1, 15 is not a perfect square so print “No”.
In test case 2, since (11 * 11 == 121) so print “Yes”.
*/

// Class to validate if a given integer is a perfect square
public class ValidPerfectSquare {

    /**
     * This method checks if a given number n is a perfect square.
     *
     * @param n The number to check
     * @return true if n is a perfect square, false otherwise
     */
    public static boolean isPerfectSquare(long n) {
        // A negative number cannot be a perfect square
        if (n < 0) {
            return false;
        }

        long left = 0; // Start of the search range
        long right = n; // End of the search range

        // Binary search to find the square root
        while (left <= right) {
            long mid = left + (right - left) / 2; // Calculate mid-point
            long square = mid * mid; // Square of mid-point

            // Check if we found the perfect square
            if (square == n) {
                return true; // Perfect square found
            } else if (square < n) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }

        return false; // No perfect square found
    }

    public static void main(String[] args) {
        // Number of test cases
        int T = 2; // Example value for testing purposes
        
        // Example test cases array
        long[] testCases = {4, 7}; // Replace with actual input reading as needed

        for (long n : testCases) {
            boolean result = isPerfectSquare(n);
            System.out.println(result ? "Yes" : "No"); // Print "Yes" or "No"
        }
    }
}
