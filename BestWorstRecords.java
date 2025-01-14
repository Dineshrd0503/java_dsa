import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BestWorstRecords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of scores
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scores.add(scanner.nextInt()); // scores
        }

        List<Integer> results = breakingRecords(scores);
        System.out.println(results.get(0) + " " + results.get(1));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> results = new ArrayList<>();
        int min = scores.get(0), max = scores.get(0);
        int maxcount = 0, mincount = 0;
        for (int n : scores) {
            if (n > max) {
                max = n;
                maxcount += 1;
            } else if (n < min) {
                min = n;
                mincount += 1;
            }
        }
        results.add(maxcount);
        results.add(mincount);
        return results;
    }
}
