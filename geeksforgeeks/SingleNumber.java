package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

//Given an array arr[] of positive integers where every element appears even times except for one. Find that number occurring an odd number of times.
//
//        Examples:
//
//Input: arr[] = [1, 1, 2, 2, 2]
//Output: 2
//Explanation: In the given array all element appear two times except 2 which appears thrice.
//        Input: arr[] = [8, 8, 7, 7, 6, 6, 1]
//Output: 1
//Explanation: In the given array all element appear two times except 1 which appears once.

public class SingleNumber {

    // Method to get the element that occurs an odd number of times
    public static int getSingle(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return -1; // if no such element exists
    }

    public static void main(String[] args) {
        // Sample array
        int[] arr = {2, 3, 5, 4, 5, 3, 4, 2, 5};

        // Finding the single occurrence element
        int result = getSingle(arr);

        // Printing the result
        if (result != -1) {
            System.out.println("The element that appears an odd number of times is: " + result);
        } else {
            System.out.println("No element appears an odd number of times.");
        }
    }
}
