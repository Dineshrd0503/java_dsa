package codingninjas7dayschallenge;

import java.util.ArrayList;

public class FindKthRowInPascaltriangle {

    // Function to generate the Kth row of Pascal's Triangle
    public static ArrayList<Long> kthRow(int k) {
        ArrayList<Long> row = new ArrayList<>();
        long val = 1;
        row.add(val);  // The first element of each row is always 1

        for (int j = 1; j < k; j++) {
            // Compute next element using formula: val = val * (k - j) / j
            val = val * (k - j) / j;
            row.add(val);
        }

        return row;
    }

    public static void main(String[] args) {
        // Static input values
        int[] testCases = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int K : testCases) {
            ArrayList<Long> row = kthRow(K);
            for (Long num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
