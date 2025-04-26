package codingninjas2monthchallenge;

public class CountOfPlates {

    /*
     Problem Statement:
     You are given 3 Integers ‘n’, ‘R’ & ‘r’ where ‘n’ is the number of plates,
     ‘R’ is the radius of the table, and ‘r’ is the radius of the ‘n’ plates.
     The task is to find out whether the given table has enough space to accommodate the
     given number of plates of radius ‘r’. Consider the table and plates to be round and
     no plate can be placed above any other.

     Each plate must be completely inside the table and must touch the edge of the table.
     Of course, the plates must not intersect, but they can touch each other.

     You have to return true if the table can accommodate the given number of plates else return false.

     Input Format:
     The first line contains an integer 'T' which denotes the number of test cases or queries to be run.
     Then the test cases follow.
     The first line of each test case contains 3 space-separated integers ‘n’, ‘R’ & ‘r’

     Output format:
     For each test case, print Yes if the table can accommodate the given number of plates else print No.
     Print the output of each test case in a new line.

     Constraints:
     1 <= T <= 10^5
     1 <= n <= 10^6
     1 <= r <= 10^9
     1 <= R <= 10^9
     1 <= r <= R

     Sample Input 1:
     3
     4 10 4
     5 10 4
     1 10 10

     Sample Output 1:
     Yes
     No
     Yes

     Explanation For Sample Input 1:
     Test Case 1: n = 4 , R = 10 , r = 4
     Test case 2 : n = 5, R = 10, r = 4
     Test case 3 : n = 1, R = 10, r = 10

     Sample Input 2:
     2
     2 10 5
     10 10 10

     Sample Output 2:
     Yes
     No
    */

    public static boolean countPlatesOnTable(int n, int R, int r) {
        // Handle the special case where R == r
        if (n == 1) {
            return r <= R;
        }
        if (r > R / 2.0) {
            return false;
        }
        double angle = Math.PI / n;
        return Math.sin(angle) >= (double) r / (R - r); // Check if we can fit n plates
    }

    public static void main(String[] args) {
        // Static test case values
        int[][] testCases = {
                {4, 10, 4},
                {5, 10, 4},
                {1, 10, 10},
                {2, 10, 5},
                {10, 10, 10},
        };

        // Process each test case
        for (int[] testCase : testCases) {
            int n = testCase[0];  // Number of plates
            int R = testCase[1];  // Radius of the table
            int r = testCase[2];  // Radius of the plates
            System.out.println(countPlatesOnTable(n, R, r) ? "Yes" : "No");
        }
    }
}
