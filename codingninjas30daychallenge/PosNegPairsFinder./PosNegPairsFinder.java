import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



// Problem statement
// Given an array of distinct integers, find all the pairs having positive value and negative value of a number that exists in the array. Return the pairs in any order.

// Note:
// The pair consists of equal absolute values, one being positive and another negative.

// Return an empty array, if no such pair exists.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 50
// 1 <= N <= 10^4
// -10^5 <= A[i] <= 10^5

// Time Limit: 1 second
// Sample Input 1:
// 2
// 2
// -2 2
// 2
// 1 2
// Sample Output 1:
// -2 2
// Explanation For Sample Output 1:
// Test case 1:
// In the first test case, we can see that the absolute values of -2 and 2 are the same. But their signs are different(positive and negative). So that’s our answer. 

// Test case 2:
// There is no number present in the array with both positive and negative values. 
// Sample Input 2:
// 2
// 6
// 1 -3 2 3 6 -1
// 8
// 4 8 9 -4 1 -1 -8 -9
// Sample Output 2:
// -1 1 -3 3
// -1 1 -4 4 -8 8 -9 9

public class PosNegPairsFinder {

    public static ArrayList<ArrayList<Integer>> pairs(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>(arr); // Add all elements to a set

        for (int a : arr) {
            if (a > 0 && set.contains(-a)) { // Check for positive-negative pair
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(-a); // Add negative value
                pair.add(a);  // Add positive value
                result.add(pair);
                set.remove(a);  // Remove both values to avoid duplicates
                set.remove(-a);
            }
        }

        return result; // Return the list of pairs
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(-1);
        arr.add(2);
        arr.add(-2);
        arr.add(3);

        ArrayList<ArrayList<Integer>> result = pairs(arr, arr.size());

        // Print the result
        for (ArrayList<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
