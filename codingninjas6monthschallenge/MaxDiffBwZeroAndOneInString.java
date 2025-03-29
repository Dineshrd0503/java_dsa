package codingninjas6monthschallenge;


//Problem statement
//You are given a binary string. You are supposed to find the maximum difference between the number of zeros(0's) and the number of ones(1's) in any substring of the given string.
//
//Note:
//Binary String is a string that consists of only ‘0’s and ‘1’s.
//
//A string ‘A’ is said to be a substring of string ‘B’ if ‘A’ can be obtained by deleting several characters(possibly none) from the start of ‘B’ and by deleting several characters(possibly none) from the end of ‘B’.
//
//The substring must have a length greater than or equal to 1.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1<= T <= 100
//        1 <= |S| <= 10,000
//S[i] = ‘0’ / ‘1’
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        1100010001
//        1101
//Sample Output 1:
//        5
//        1
//Explanation For Sample Input 1:
//In the first test case, the binary string is ‘1100010001’. To find out the maximum difference between the number of zeros and the number of ones in the substring of the string, We have a substring from index 2 to 8, which consists of all ‘0’s except the 5th index, which is ‘1’. So, the answer is 6 - 1 = 5.
//
//In the second test case, the binary string is ‘1101’. To find out the maximum difference between the number of zeros and the number of ones in the substring of the string, We have a substring from index 2 to 2(length = 1), which consists of one ‘0’s and zero ‘1’s, So, the answer is 1 - 0 = 0.
//Sample Input 2:
//        2
//        000000
//        0101010101
//Sample Output 2:
//        6
//        1



public class MaxDiffBwZeroAndOneInString {
    public static int maximumDifference(String str) {
        // Write your code here
        int maxDiff = Integer.MIN_VALUE; // To store the maximum difference
        int currentSum = 0; // Store current sum for Kadane's algorithm

        for (char ch : str.toCharArray()) {
            // Transform '0' to +1 and '1' to -1
            if (ch == '0') {
                currentSum += 1; // Increment for '0'
            } else {
                currentSum -= 1; // Decrement for '1'
            }

            // Update maxDiff if currentSum is greater
            maxDiff = Math.max(maxDiff, currentSum);

            // If currentSum drops below 0, reset it
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        String str = "11000010001";
        System.out.println(maximumDifference(str));
    }
}
