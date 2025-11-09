package dynamicprogramming;

/*
Problem Statement:
Ways To Tile A Floor (GeeksforGeeks)
------------------------------------
Given a floor of size 2 x n and tiles of size 2 x 1,
count the number of ways to tile the floor using the tiles.

Each tile can be placed either vertically (covering 2 x 1) or horizontally (covering 1 x 2).
Return the number of ways to tile the floor.

Constraints:
1 <= n <= 45

Sample Test Cases:
------------------
Input: n = 3
Output: 3
Explanation:
Ways are -
1. Place three vertical tiles
2. Place one horizontal tile followed by two vertical tiles
3. Place two vertical tiles followed by one horizontal tile

Input: n = 4
Output: 5
Explanation:
Ways are -
1. 4 vertical
2. 2 vertical + 1 horizontal + 1 horizontal
3. 2 horizontal + 2 vertical
4. 1 horizontal + 1 horizontal + 2 vertical
5. 2 horizontal + 2 horizontal
*/

import java.util.Scanner;

public class WaysToTileFloor {

    // Function to compute number of ways to tile 2 x n floor
    public static int numberOfWays(int n) {
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way for n=0 (no tiles)
        dp[1] = 1; // 1 way for n=1 (only vertical tile)

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] testCases = {3, 4};

        for (int n : testCases) {
            System.out.println("Ways to tile 2 x " + n + " floor: " + numberOfWays(n));
        }
    }
}
