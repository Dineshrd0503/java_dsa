import java.util.*;

public class NoOfMaximums {
    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = Collections.max(candles);
        int count = 0;
        for (int n : candles) {
            if (n >= max)
                count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> candles = Arrays.asList(3, 2, 1, 3);
        int result = birthdayCakeCandles(candles);
        System.out.println("Number of tallest candles: " + result);
    }
}
