package arrays;

/**
 * Problem Statement:
 * There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles
 * from the market with one full water bottle. The operation of drinking a full water bottle turns it into an empty bottle.
 * Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
 *
 * Examples:
 * Input: numBottles = 9, numExchange = 3
 * Output: 13
 * Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 9 + 3 + 1 = 13.
 *
 * Input: numBottles = 15, numExchange = 4
 * Output: 19
 * Explanation: You can exchange 4 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 15 + 3 + 1 = 19.
 *
 * Constraints:
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 */
public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Initialize variables
        int drunk = 0; // Total bottles drunk
        int full = numBottles; // Current full bottles
        int empty = 0; // Current empty bottles

        // Continue while there are full bottles to drink
        while (full > 0) {
            // Drink all full bottles
            drunk += full;
            empty += full; // Each drunk bottle becomes empty
            full = 0; // No full bottles left after drinking

            // Exchange empty bottles for full ones
            full = empty / numExchange;
            empty = empty % numExchange; // Remaining empty bottles
        }

        return drunk;

        // Alternative Mathematical Approach:
        // return numBottles + (numBottles - 1) / (numExchange - 1);
    }
    int method2(int numBottles,int numExchange){
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }

    public static void main(String[] args) {
        WaterBottles solution = new WaterBottles();

        // Static test cases
        int[][] testCases = {
                {9, 3},   // Sample Test Case 1
                {15, 4}   // Sample Test Case 2
        };

        // Process each test case
        for (int[] test : testCases) {
            int numBottles = test[0];
            int numExchange = test[1];
            int result = solution.numWaterBottles(numBottles, numExchange);
            int result2=solution.method2(numBottles,numExchange);
            System.out.println("Input: numBottles = " + numBottles + ", numExchange = " + numExchange);
            System.out.println("Output: " + result);
            System.out.println();
            System.out.println("Output: " + result2);
            System.out.println();
        }
    }
}