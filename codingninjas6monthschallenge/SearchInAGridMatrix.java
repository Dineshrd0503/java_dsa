package codingninjas6monthschallenge;

import java.util.ArrayList;

public class SearchInAGridMatrix {
        public static boolean searchGrid(ArrayList<ArrayList<Integer>> mat, int n, int m, int target) {
            // Write your code here
            // Return true or false
            int start = 0;
            int end = (n * m) - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2; // Correct mid calculation
                int row = mid / m; // Calculate row index
                int col = mid % m; // Calculate column index

                if (mat.get(row).get(col) == target) {
                    return true;
                } else if (mat.get(row).get(col) < target) {
                    start = mid + 1; // Adjust start if target is greater
                } else {
                    end = mid - 1; // Adjust end if target is smaller
                }
            }
            return false;
        }

        public static void main(String[] args) {
            // Example Usage:
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            matrix.add(new ArrayList<Integer>() {
                {
                    add(1);
                    add(3);
                    add(5);
                }
            });
            matrix.add(new ArrayList<Integer>() {
                {
                    add(7);
                    add(9);
                    add(11);
                }
            });
            int target = 3;
            boolean found = searchGrid(matrix, 2, 3, target);
            System.out.println("Target " + target + " found: " + found);

            target = 10;
            found = searchGrid(matrix, 2, 3, target);
            System.out.println("Target " + target + " found: " + found);
        }
    }


