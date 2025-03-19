package patterns;


//Problem statement
//Ninja has a number ‘N’. He wants to print the pattern in such a way that the outer rectangle is of the number ‘N’ and the number goes on decreasing as we move inside the rectangles.
//
//For example, if ‘N’ = 4, then pattern will be:
//
//        4 4 4 4 4 4 4
//        4 3 3 3 3 3 4
//        4 3 2 2 2 3 4
//        4 3 2 1 2 3 4
//        4 3 2 2 2 3 4
//        4 3 3 3 3 3 4
//        4 4 4 4 4 4 4
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 5
//        1 <= N <= 100
//
//Time limit: 1 sec.
//Sample Input 1:
//        2
//        2
//        1
//Sample Output 1:
//        2 2 2
//        2 1 2
//        2 2 2
//        1
//Explanation Of Sample Input 1:
//Test case 1:
//
//For the first test case of sample output 1, as the number is 2, so the outermost rectangle is of number 2. The moment we get inside the rectangle, we reduce the number by 1 and make another rectangle.
//
//Test case 2:
//
//For the second test case of sample output 1, as the number is 1, so the outermost rectangle is of number 1.
//Sample Input 2:
//        1
//        4
//Sample Output 2:
//        4 4 4 4 4 4 4
//        4 3 3 3 3 3 4
//        4 3 2 2 2 3 4
//        4 3 2 1 2 3 4
//        4 3 2 2 2 3 4
//        4 3 3 3 3 3 4
//        4 4 4 4 4 4 4
//Explanation Of Sample Input 2:
//Test case 1:
//
//For the first test case of sample output 2, as the number is 4, so the outermost rectangle is of number 24. The moment we get inside the rectangle, we reduce the number by 1 and make another rectangle. This process goes on till we reach 1.



public class RectangualrNumberPattern {
    public static int[][] rectangularNumbers(int n) {
        // Write your code here.
        int size = 2 * n - 1;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int minDistance = Math.min(Math.min(i, j), Math.min(size - 1 - i, size - 1 - j));
                result[i][j] = n - minDistance;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] pattern = rectangularNumbers(n);
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
                System.out.print(pattern[i][j] + " ");
            }
            System.out.println();
        }
    }
}
