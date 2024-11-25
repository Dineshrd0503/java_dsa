import java.util.*;

public class FreqOfEachFile {
    public static void frequencyCount(int arr[], int N, int P) {
        // Step 1: Initialize a HashMap to count the frequencies of elements
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 2: Count frequencies of elements between 1 and P
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 1 && arr[i] <= P) {
                freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            }
        }

        // Step 3: Modify the original array to hold the frequencies
        for (int i = 0; i < N; i++) {
            if (i + 1 <= P) {
                // Get frequency of element i+1 from the map
                arr[i] = freqMap.getOrDefault(i + 1, 0);
            } else {
                arr[i] = 0; // Elements greater than P should be set to 0
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int p = 5;
        int[] arr = {2, 3, 2, 3, 5};

        frequencyCount(arr, n, p);

        // Output the modified array
        System.out.println(Arrays.toString(arr));
    }
}
