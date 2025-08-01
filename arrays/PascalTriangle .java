import java.util.ArrayList;
import java.util.List;
package arrays;
/*
Problem Statement:
Given an integer `numRows`, return the first numRows of **Pascal's triangle**.

In **Pascal's triangle**, each number is the sum of the two numbers directly above it as shown:

![](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

**Example 1:**

**Input:** numRows = 5
**Output:** \[\[1\],\[1,1\],\[1,2,1\],\[1,3,3,1\],\[1,4,6,4,1\]\]

**Example 2:**

**Input:** numRows = 1
**Output:** \[\[1\]\]

**Constraints:**

*   `1 <= numRows <= 30`
*/

public class PascalTriangle {
    /**
     * Generates Pascal's Triangle up to the given number of rows.
     *
     * @param numRows The number of rows to generate in Pascal's Triangle.
     * @return A list of lists representing Pascal's Triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Iterate through each row of the triangle
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // Iterate through each element in the current row
            for (int j = 0; j <= i; j++) {
                // The first and last elements of each row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Otherwise, the element is the sum of the two elements directly above it
                    // in the previous row.
                    List<Integer> previousRow = triangle.get(i - 1);
                    int value = previousRow.get(j - 1) + previousRow.get(j);
                    row.add(value);
                }
            }

            // Add the current row to the triangle
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle solution=new PascalTriangle();

        // Test case 1
        int numRows1 = 5;
        List<List<Integer>> result1 = solution.generate(numRows1);
        System.out.println("Pascal's Triangle for numRows = " + numRows1 + ": " + result1);

        // Test case 2
        int numRows2 = 1;
        List<List<Integer>> result2 = solution.generate(numRows2);
        System.out.println("Pascal's Triangle for numRows = " + numRows2 + ": " + result2);

        // Test case 3
        int numRows3 = 9;
        List<List<Integer>> result3 = solution.generate(numRows3);
        System.out.println("Pascal's Triangle for numRows = " + numRows3 + ": " + result3);
    }
}
