import java.util.*;

public class DiagonalSumDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int lsum = 0, rsum = 0;
        for (int i = 0; i < arr.size(); i++) {
            lsum += arr.get(i).get(i);
            rsum += arr.get(i).get(arr.size() - i - 1);
        }
        return Math.abs(lsum - rsum);
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 2, 3));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(9, 8, 7));
        
        int result = diagonalDifference(arr);
        System.out.println("Diagonal difference: " + result);
    }
}