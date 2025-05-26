package arrays;

import java.util.ArrayList;

public class SelfDividingNumbers {

        // Method to find all self-dividing numbers from lower to upper
        public static ArrayList<Integer> findAllSelfDividingNumbers(int lower, int upper) {
            ArrayList<Integer> result = new ArrayList<>();

            for (int i = lower; i <= upper; i++) {
                if (isDivisible(i)) {
                    result.add(i);
                }
            }
            return result;
        }

        // Helper method to determine if a number is self-dividing
        private static boolean isDivisible(int n) {
            int original = n; // Store the original number

            while (n > 0) {
                int digit = n % 10; // Get the last digit
                if (digit == 0 || original % digit != 0) {
                    return false; // If digit is 0 or not divisible, return false
                }
                n /= 10; // Remove the last digit
            }
            return true; // It is a self-dividing number
        }

        public static void main(String[] args) {
            // Sample input
            int numberOfTestCases = 2;
            int[][] testCases = {
                    {10, 30},
                    {15, 45}
            };

            // Process each test case
            for (int i = 0; i < numberOfTestCases; i++) {
                int lower = testCases[i][0];
                int upper = testCases[i][1];
                System.out.print("Self-dividing numbers from " + lower + " to " + upper + ": ");
                ArrayList<Integer> selfDividingNumbers = findAllSelfDividingNumbers(lower, upper);
                for (int num : selfDividingNumbers) {
                    System.out.print(num + " ");
                }
                System.out.println(); // New line after each test case
            }
        }
    }

/*
Problem statement
=================

A Ninja wants to collect all possible self-dividing numbers from a given range of numbers.

A self-dividing number is a number that is divisible by every digit it contains.

**For example:**
128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Given a ‘LOWER’ and ‘UPPER’ number bound, your task is to find all possible self-dividing numbers in the range of ‘LOWER’ to ‘UPPER’.

**Note:**
A self-dividing number is not allowed to contain the digit zero.

**Example:**
‘LOWER' = 1’  and, ‘UPPER' = 22’.
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22].

Detailed explanation (Input/output format, Notes, Images)
========================================================

**Input Format**
The first line of input contains a single integer ‘T’ denoting the number of test cases given.
Then next ‘T’ lines follow:
The first line of each test case input contains two single space-separated integers ‘LOWER’ and ‘UPPER’.

**Output Format**
For every test case, return a list of every possible self-dividing number, including the bounds (means ‘LOWER’ and ‘UPPER’ both are inclusive).

**Constraints:**
1 <= T <= 10
1 <= LOWER <= UPPER <= 1000

**Sample Input 1:**
2
10 30
15 45

**Sample Output 1:**
Self-dividing numbers from 10 to 30: 11 12 15 22 24
Self-dividing numbers from 15 to 45: 15 22 24 33 36 44

**Sample Input 2:**
2
1 22
100 150

**Sample Output 2:**
Self-dividing numbers from 1 to 22: 1 2 3 4 5 6 7 8 9 11 12 15 22
Self-dividing numbers from 100 to 150: 111 112 115 122 124 126 128 132 135 144
*/

