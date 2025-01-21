//Problem statement
//Given two unsorted arrays of non-negative integers, 'arr1' and 'arr2' of size 'N' and 'M', respectively. Your task is to find the pair of elements (one from each array), such that their absolute (non-negative) difference is the smallest, and return the difference.
//
//Example :
//N = 3, arr1 = [10, 20, 30]
//M = 2, arr2 = [17, 15]
//The smallest difference pair is (20, 17) with an absolute difference of 3. So, the answer is 3.
//Note :
//Both the arrays are unsorted, and all array elements are non-negative integers.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= T <= 10
//        1 <= N, M <= 1000
//        0 <= arr1[i], arr2[i] <=10^6
//
//Time Limit: 1 second
//Sample input 1 :
//        2
//        3 3
//        12 7 5
//        4 4 6
//        3 2
//        10 20 30
//        17 15
//Sample output 1 :
//        1
//        3
//Explanation For Sample Input 1 :
//Test Case 1 :
//The smallest difference pairs are (7, 6) and (5, 6) with an absolute difference of 1, so the answer is 1.
//
//Test Case 2 :
//The smallest difference pair is (20, 17) with an absolute difference of 3, so the answer is 3.
//Sample input 2 :
//        2
//        4 4
//        1 5 12 3
//        16 9 10 20
//        2 4
//        20 10
//        10 13 19 16
//Sample output 2 :
//        2
//        0




import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    
    // Method to find the smallest difference pair
    public static int smallestDifferencePair(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
        // Sort both arrays
        Collections.sort(arr1);
        Collections.sort(arr2);

        int i = 0, j = 0;
        int result = Integer.MAX_VALUE; // Initialize to max value

        // Two pointer technique to find the smallest difference
        while (i < n && j < m) {
            int diff = Math.abs(arr1.get(i) - arr2.get(j));
            result = Math.min(diff, result); // Update smallest difference
            
            // Move the pointer of the smaller value
            if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return result; // Return the smallest difference found
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        int T = scanner.nextInt();
        while (T-- > 0) {
            // Read sizes of both arrays
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            // Create ArrayLists for both arrays
            ArrayList<Integer> arr1 = new ArrayList<>(N);
            ArrayList<Integer> arr2 = new ArrayList<>(M);

            // Read elements of first array
            for (int i = 0; i < N; i++) {
                arr1.add(scanner.nextInt());
            }

            // Read elements of second array
            for (int i = 0; i < M; i++) {
                arr2.add(scanner.nextInt());
            }

            // Call the function and print the result
            int smallestDiff = smallestDifferencePair(arr1, N, arr2, M);
            System.out.println(smallestDiff);
        }

        scanner.close(); // Close scanner
    }
}
