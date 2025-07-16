package arrays;

/*
 * Problem Statement:
 * The Indian Navy conducts a fitness test with 3 trainees over 3 rounds in seawater.
 * The remaining oxygen level is recorded in a 3x3 2D ArrayList 'oxygen'. The fittest
 * trainee(s) are selected based on the average oxygen level over the rounds, with
 * levels outside [1, 100] treated as 0. If the maximum average is below 70, all are
 * unfit. Otherwise, trainees with the highest average are selected. Return an
 * ArrayList of Strings indicating "TraineeX" or "Unfit" for each trainee.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= oxygen[i][j] <= 100 (adjusted to 0 if out of range)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class FittestTrainee {
    public static ArrayList<String> fittestTrainee(ArrayList<ArrayList<Integer>> oxygen)
    {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (oxygen == null || oxygen.size() != 3 || oxygen.get(0).size() != 3) return result;

        double[] avg = new double[3];

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                int level = oxygen.get(i).get(j);
                sum += (level >= 1 && level <= 100) ? level : 0; // Fixed semicolon
            }
            avg[i] = Math.round(sum / 3.0);
        }
        double maxavg = Arrays.stream(avg).max().getAsDouble();
        for (int i = 0; i < 3; i++) {
            if (maxavg < 70)
                result.add("Unfit");
            else if (avg[i] == maxavg)
                result.add("Trainee" + (i + 1));
            else
                result.add("Unfit");
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Case 1
        ArrayList<ArrayList<Integer>> oxygen1 = new ArrayList<>();
        oxygen1.add(new ArrayList<>(Arrays.asList(10, 50, 30)));
        oxygen1.add(new ArrayList<>(Arrays.asList(30, 80, 90)));
        oxygen1.add(new ArrayList<>(Arrays.asList(60, 90, 80)));
        ArrayList<String> result1 = fittestTrainee(oxygen1);
        System.out.println("Test Case 1:");
        for (String s : result1) System.out.println(s);

        // Test Case 2
        ArrayList<ArrayList<Integer>> oxygen2 = new ArrayList<>();
        oxygen2.add(new ArrayList<>(Arrays.asList(90, 90, 90)));
        oxygen2.add(new ArrayList<>(Arrays.asList(70, 70, 70)));
        oxygen2.add(new ArrayList<>(Arrays.asList(0, 101, 98)));
        ArrayList<String> result2 = fittestTrainee(oxygen2);
        System.out.println("Test Case 2:");
        for (String s : result2) System.out.println(s);
    }
}
