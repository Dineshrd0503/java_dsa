package codingninjas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubArraySum {
    public static int getKthLargest(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> subarraySums = new ArrayList<>();

        // Generate all subarray sums
        for (int i = 0; i < arr.size(); i++) {
            int currentSum = 0;
            for (int j = i; j < arr.size(); j++) {
                currentSum += arr.get(j);
                subarraySums.add(currentSum);
            }
        }

        // Sort subarray sums in descending order
        Collections.sort(subarraySums, Collections.reverseOrder());

        // Return the k-th largest sum
        return subarraySums.get(k - 1);
    }

    public static void main(String[] args) {
        // Test cases
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(3, -2, 5));
        System.out.println(getKthLargest(arr1, 3)); // Output: 3

        ArrayList<Integer> arr2 = new ArrayList<>(List.of(4, 1));
        System.out.println(getKthLargest(arr2, 2)); // Output: 4

        ArrayList<Integer> arr3 = new ArrayList<>(List.of(5, 4, -8, 6));
        System.out.println(getKthLargest(arr3, 10)); // Output: -8

        ArrayList<Integer> arr4 = new ArrayList<>(List.of(1, 2, 3));
        System.out.println(getKthLargest(arr4, 1)); // Output: 6
    }
}
