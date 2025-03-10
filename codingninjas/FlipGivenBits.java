package codingninjas;

//Problem statement
//You have been given an integer 'NUM' (32 bits) and an array of size 'N'.
//
//Your task is to flip all the bits of 'NUM' at position 'ARR[i]' where 0<= i <= N-1.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= 'T' <= 10
//        1 <= 'NUM' <= 10^9
//        1 <= 'N' <= 10^5
//        1 <= 'ARR[i]' <= 31
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        21
//        3
//        4 2 1
//        40
//        1
//        4
//Sample Output 1:
//        30
//        32
//Explanation for Sample Input 1:
//Before flipping
//21 => 10101
//After flipping the 4th, 2nd and 1st bit from the end we get
//30 => 11110
//
//Before flipping
//40 => 101000
//After flipping the 4th bit from the end we get
//32 => 100000
//Sample Input 2:
//        1
//        5
//        3
//        6 2 5
//Sample Output 2:
//        55


public class FlipGivenBits {
        public static int flipSomeBits(int num, int[] arr, int n) {
            for (int i = 0; i < n; i++)
                num ^= (1 << arr[i]); // Flip the bit at position arr[i]
            return num;
        }

        public static void main(String[] args) {
            // Test Case 1
            int num1 = 21;
            int[] arr1 = {4, 2, 1};
            System.out.println("Output 1: " + flipSomeBits(num1, arr1, arr1.length)); // Expected Output: 30

            // Test Case 2
            int num2 = 40;
            int[] arr2 = {4};
            System.out.println("Output 2: " + flipSomeBits(num2, arr2, arr2.length)); // Expected Output: 32

            // Test Case 3
            int num3 = 5;
            int[] arr3 = {6, 2, 5};
            System.out.println("Output 3: " + flipSomeBits(num3, arr3, arr3.length)); // Expected Output: 55
        }
    }



