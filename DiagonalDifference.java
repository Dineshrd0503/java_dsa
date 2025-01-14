import java.util.*;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum1 = 0; // left-to-right diagonal
        int sum2 = 0; // right-to-left diagonal

        for (int i = 0; i < arr.size(); i++) {
            sum1 += arr.get(i).get(i); // left-to-right diagonal
            sum2 += arr.get(i).get(arr.size() - 1 - i); // right-to-left diagonal
        }
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 2, 3));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(9, 8, 9));

        int result = diagonalDifference(arr);
        System.out.println("The absolute difference between the sums of the diagonals is: " + result);
    }
}