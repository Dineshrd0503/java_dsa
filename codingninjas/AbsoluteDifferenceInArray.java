import java.util.ArrayList;

/*
Problem statement
You are given an array/list 'ARR' consisting of 'N' non - negative integers. Your task is to return the running absolute difference of the elements at even and odd index positions separately.

The index of the first element in the array is considered to be zero that is 0 - based indexing is considered for calculating the parity of the index.

Example:

Consider the array - [1, 2, 3, 4, 5, 6]
The elements at even positions will be 1, 3, 5. The running absolute difference of elements will be - 
|1 - 3| = 2 , |2 -5| = 3. Hence our answer will be 3.

The elements at odd positions will be 2, 4, 6. The running absolute difference of elements will be - 
|2 - 4| = 2 , |2 - 6| = 4. Hence our answer will be 4.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
 1 <= T <= 10
 1 <= N <= 5 * 10^4
 1 <= ARR[i] <=10^5

Time Limit: 1 sec
Sample Input 1:
2
5
5 4 3 4 2
4
3 5 3 1
Sample Output 1:
0 0
0 4
Explanation of Input 1:
For test case 1:
• The running absolute difference of elements at even positions will be : |5 - 3| = 2, |2 - 2| = 0.
• The running absolute difference of elements at odd positions will be : |4 - 4| = 0.
For test case 2:
• The running absolute difference of elements at even positions will be : |3 - 3| = 0.
• The running absolute difference of elements at odd positions will be : |5 - 1| = 4.
Sample Input 2:
1
7
10 20 30 40 50 60 70
Sample Output 2:
40 40 */



public class AbsoluteDifferenceInArray {

    public static ArrayList<Integer> absDiff(ArrayList<Integer> arr, int n) {
        int diff1 = 0, diff2 = 0;

        // Calculate the running absolute difference for even-indexed and odd-indexed elements
        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) {  // Even index
                diff1 = (i == 0) ? arr.get(i) : Math.abs(arr.get(i) - diff1);
            } else {  // Odd index
                diff2 = (i == 1) ? arr.get(i) : Math.abs(arr.get(i) - diff2);
            }
        }

        // Return the results as an ArrayList containing the two differences
        ArrayList<Integer> result = new ArrayList<>();
        result.add(diff1);  // Even index absolute difference
        result.add(diff2);  // Odd index absolute difference
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(4);
        arr.add(3);
        arr.add(4);
        arr.add(2);

        // Call the absDiff function
        ArrayList<Integer> result = absDiff(arr, arr.size());

        // Output the result
        System.out.println("Even index absolute difference: " + result.get(0));
        System.out.println("Odd index absolute difference: " + result.get(1));
    }
}
