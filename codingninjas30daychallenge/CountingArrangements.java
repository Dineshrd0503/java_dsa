package codingninjas30daychallenge;

//Problem statement
//You are given a number 'N'. Your goal is to find the number of permutations of the list 'A' = [1, 2, ......, N], satisfying either of the following conditions:
//
//A[i] is divisible by i or i is divisible by A[i], for every 'i' from 1 to 'N'.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        0 <= N <= 15
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        1
//        2
//Sample Output 1:
//        1
//        2
//Explanation for Sample Input 1:
//In test case 1:
//The only permutation is A=[1]
//A[1] = 1 is divisible by i = 1
//
//The permutation is satisfying the conditions therefore answer is 1
//
//In test case 2:
//The 1st permutation is A=[1,2]:
//A[1] = 1 is divisible by i = 1
//A[2] = 2 is divisible by i = 2
//The 2nd permutation is A=[2,1]:
//A[1] = 2 is divisible by i = 1
//i = 2 is divisible by A[2] = 1
//
//Both permutations are satisfying either of the conditions therefore answer is 2
//Sample Input 2:
//        2
//        3
//        4
//Sample Output 2:
//        3
//        8




public class CountingArrangements {
    public static int countArrangement(int n) {
        // Write your code here.

        return countValidArrangements(n, 1, new boolean[n + 1]);
    }

    private static int countValidArrangements(int n, int position, boolean[] used) {
        // Base case: if we've filled all positions
        if (position > n) {
            return 1; // Found a valid arrangement
        }

        int count = 0;

        // Try placing each number from 1 to n in the current position
        for (int num = 1; num <= n; num++) {
            if (!used[num] && (num % position == 0 || position % num == 0)) {
                used[num] = true; // Mark this number as used
                count += countValidArrangements(n, position + 1, used); // Recur for next position
                used[num] = false; // Backtrack: unmark this number
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(countArrangement(n));
    }
}
