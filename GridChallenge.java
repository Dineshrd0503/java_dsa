import java.util.*;
//Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.
//
//        Example
//
//The grid is illustrated below.
//
//a b c
//a d e
//e f g
//The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order, so the answer would be YES. Only elements within the same row can be rearranged. They cannot be moved to a different row.
//
//Function Description
//
//Complete the gridChallenge function in the editor below.
//
//gridChallenge has the following parameter(s):
//
//string grid[n]: an array of strings
//Returns
//
//string: either YES or NO
public class GridChallenge {
    public static String gridChallenge(List<String> grid) {
        // Step 1: Sort each row alphabetically
        for (int i = 0; i < grid.size(); i++) {
            char[] row = grid.get(i).toCharArray();
            Arrays.sort(row);
            grid.set(i, new String(row));
        }

        // Step 2: Check if each column is sorted
        for (int col = 0; col < grid.get(0).length(); col++) {
            for (int row = 1; row < grid.size(); row++) {
                if (grid.get(row).charAt(col) < grid.get(row - 1).charAt(col)) {
                    return "NO";  // Column is not sorted
                }
            }
        }

        return "YES";  // All columns are sorted
    }

    public static void main(String[] args) {
        List<String> grid = Arrays.asList("abc", "ade", "efg");
        System.out.println(gridChallenge(grid));  // Output: YES

        List<String> grid2 = Arrays.asList("ebc", "fda", "zgh");
        System.out.println(gridChallenge(grid2));  // Output: NO
    }
}
