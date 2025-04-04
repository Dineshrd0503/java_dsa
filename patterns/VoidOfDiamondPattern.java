/**
 * Problem Statement:
 * You are tasked with printing a "Void of Diamond" pattern for a given input size `N`.
 * The pattern consists of a square grid of size `N x N` where:
 * - The border of the grid is filled with stars (`*`).
 * - Inside the grid, spaces (` `) form a diamond shape, leaving the remaining cells filled with stars (`*`).
 *
 * Input:
 * - An integer `N`, where `N` is the size of the square grid (1 ≤ N ≤ 500).
 *
 * Output:
 * - A square grid of size `N x N` printed in the console, following the "Void of Diamond" pattern.
 *
 * Examples:
 *
 * Input 1:
 * N = 5
 *
 * Output 1:
 * *****
 * ** **
 * *   *
 * ** **
 * *****
 *
 * Input 2:
 * N = 3
 *
 * Output 2:
 * ***
 * * *
 * ***
 *
 * Input 3:
 * N = 7
 *
 * Output 3:
 * *******
 * *** ***
 * **   **
 * *     *
 * **   **
 * *** ***
 * *******
 *
 */







package patterns;
public class VoidOfDiamondPattern {
    public static void main(String[] args) {
        System.out.println("void of diamond pattern");
        int n = 5;
        String[] pattern = printVoidOfDiamond(n);
        for (String line : pattern) {
            System.out.println(line);
        }
    }

    public static String[] printVoidOfDiamond(int N) {
	String[] pattern = new String[N];
    int mid = N / 2;

    for (int i = 0; i < N; i++) {
        StringBuilder row = new StringBuilder();
        for (int j = 0; j < N; j++) {
            if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                row.append("*");
            } else if (Math.abs(mid - i) + Math.abs(mid - j) <= mid - 1) {
                row.append(" ");
            } else {
                row.append("*");
            }
        }
        pattern[i] = row.toString();
    }
    return pattern;
		// Write your code here
	}
}
