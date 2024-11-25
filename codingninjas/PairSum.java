package codingninjas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PairSum {

    public static List<int[]> findPairs(int[] arr, int targetSum) {
        List<int[]> pairs = new ArrayList<>();

        // Loop through each element and find pairs that sum to targetSum
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    // Add the pair of numbers as an array to the list
                    pairs.add(new int[]{arr[i], arr[j]});
                }
            }
        }

        return pairs; // Return the list of pairs
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading the input
        int N = sc.nextInt(); // Number of elements in the array
        int targetSum = sc.nextInt(); // Target sum to find

        // Create the array
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt(); // Fill the array with input values
        }

        // Call the method to find pairs that sum up to targetSum
        List<int[]> result = findPairs(arr, targetSum);

        // Print each pair
        for (int[] pair : result) {
            System.out.println(pair[0] + " " + pair[1]);
        }

        sc.close();
    }
}

