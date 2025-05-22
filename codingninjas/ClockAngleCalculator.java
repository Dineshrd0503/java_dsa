package codingninjas;

/**
 * Problem Statement:
 * Given the time in hours (H) and minutes (M), calculate the minimum angle between the hour hand and the minute hand.
 * There are two possible angles (clockwise and counterclockwise); return the smaller one.
 * Return the floor value of the angle (e.g., 15.2 becomes 15).
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= H <= 12
 * 0 <= M <= 59
 * Time Limit: 1 sec
 *
 * Sample Input 1:
 * T = 2
 * Test Case 1: H = 6, M = 30
 * Test Case 2: H = 8, M = 55
 * Sample Output 1:
 * 15
 * 62
 * Explanation:
 * Test Case 1: At 6:30, the angles are 15° and 345°. Minimum is 15.
 * Test Case 2: At 8:55, the angles are 62.5° and 297.5°. Floor of 62.5 is 62.
 *
 * Sample Input 2:
 * T = 2
 * Test Case 1: H = 3, M = 30
 * Test Case 2: H = 12, M = 0
 * Sample Output 2:
 * 75
 * 0
 * Explanation:
 * Test Case 1: At 3:30, the angles are 75° and 285°. Minimum is 75.
 * Test Case 2: At 12:00, the angle is 0°.
 */
public class ClockAngleCalculator {
    /**
     * Calculates the minimum angle between the hour hand and minute hand.
     * @param hour The hour (1 to 12).
     * @param minute The minute (0 to 59).
     * @return The floor value of the minimum angle in degrees.
     */
    public static int findAngle(int hour, int minute) {
        // Normalize hour: 12 should be treated as 0
        if (hour == 12) {
            hour = 0;
        }

        // Calculate the angle of the minute hand
        // Each minute = 6 degrees (360 / 60)
        double minuteAngle = minute * 6.0;

        // Calculate the angle of the hour hand
        // Each hour = 30 degrees (360 / 12)
        // Each minute adds 0.5 degrees (30 / 60)
        double hourAngle = (hour * 30) + (minute * 0.5);

        // Compute the absolute angle between the hands
        double angle = Math.abs(hourAngle - minuteAngle);

        // Find the minimum angle (clockwise or counterclockwise)
        angle = Math.min(angle, 360 - angle);

        // Return the floor value
        return (int) angle;
    }

    /**
     * Main method to test the solution with static inputs.
     */
    public static void main(String[] args) {
        // Static test cases (Sample Input 1 and Sample Input 2)
        int[][] testCases = {
                {6, 30},   // Test case 1
                {8, 55},   // Test case 2
                {3, 30},   // Test case 3
                {12, 0},   // Test case 4
                {9, 0}     // Additional test case: 9:00
        };

        int[] expectedOutputs = {
                15,  // Test case 1
                62,  // Test case 2
                75,  // Test case 3
                0,   // Test case 4
                90   // Test case 5
        };

        // Run test cases
        for (int i = 0; i < testCases.length; i++) {
            int hour = testCases[i][0];
            int minute = testCases[i][1];
            int expected = expectedOutputs[i];
            int result = findAngle(hour, minute);

            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: H = " + hour + ", M = " + minute);
            System.out.println("Expected Output: " + expected);
            System.out.println("Actual Output: " + result);
            System.out.println("Status: " + (result == expected ? "PASS" : "FAIL"));
            System.out.println();
        }
    }
}
