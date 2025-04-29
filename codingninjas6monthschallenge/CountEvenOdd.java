package codingninjas6monthschallenge;
import java.util.HashMap;
import java.util.Map;

public class CountEvenOdd {

    /**
     * This method counts how many integers appear an odd number of times
     * and how many appear an even number of times in the given array.
     * 
     * @param arr an array of integers
     * @param n the size of the array
     * @return an array of two integers where the first element is the count of odd occurrences
     *         and the second element is the count of even occurrences.
     */
    public static int[] countEvenOdd(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count occurrences of each number in the array
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int odd = 0, even = 0;

        // Determine the number of odd and even occurrences
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0)
                even++;
            else
                odd++;
        }

        return new int[]{odd, even}; // Return the counts
    }

    /**
     * Main method to test the countEvenOdd function with static inputs.
     */
    public static void main(String[] args) {
        // Static input test cases
        int[][] testCases = {
            {4, 5, 1, 2, 1}, // Example 1
            {2, 1, 2, 1},    // Example 2
            {5, 2, 9, 9, 7, 5, 1, 3} // Example 3
        };

        // Process each test case
        for (int[] arr : testCases) {
            int[] result = countEvenOdd(arr, arr.length);
            System.out.println(result[0] + " " + result[1]); // Print results in the format "odd even"
        }
    }
}

/*
Problem Statement:
You have been given an array/list of integers 'ARR' of size 'N'. 
Your task is to find two things:
1. The number of elements that are occurring an Odd number of times.
2. The number of elements that are occurring Even a number of times.

Input Format:
- The first line contains an integer 'T' which denotes the number of test cases.
- The first line of every test case contains an integer 'N' representing the number of elements in the array/list.
- The second line of each test case contains 'N' space-separated integers representing the array/list elements.

Output Format:
- For each test case, print two single space-separated integers representing the number of odd occurring elements and the number of even occurring elements respectively.

Sample Input 1:
2
5
4 5 1 2 1
4
2 1 2 1 

Sample Output 1:
3 1
0 2

Sample Input 2:
1
8
5 2 9 9 7 5 1 3

Sample Output 2:
4 2
*/
