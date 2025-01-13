package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThirdLargeEleArr {
        public static int findThirdLargest(ArrayList<Integer> arr) {
            if (arr.size() < 3) {
                // Return -1 or handle cases where there aren't enough elements
                return -1;
            }

            // Find the first largest element
            int max1 = Collections.max(arr);

            // Remove all occurrences of the first largest element from the array
            arr.removeIf(n -> n == max1);

            if (arr.size() < 2) {
                // If fewer than two elements remain, third largest doesn't exist
                return -1;
            }

            // Find the second largest element
            int max2 = Collections.max(arr);

            // Remove all occurrences of the second largest element from the array
            arr.removeIf(n -> n == max2);

            if (arr.isEmpty()) {
                // If no elements remain, third largest doesn't exist
                return -1;
            }

            // Find the third largest element
            int max3 = Collections.max(arr);
            return max3;
        }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5));
        int thirdLargest = findThirdLargest(arr);
        System.out.println("Third largest element: " + thirdLargest); // Output: 4
    }
}
