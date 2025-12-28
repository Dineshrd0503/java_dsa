package strings;

/*
 * ============================================================================
 * PROBLEM STATEMENT: Check if the door is open or closed
 * ============================================================================
 *
 * There are 'N' doors and 'N' people in a house. Each person and door has a
 * unique ID ranging from 1 to 'N'. A person can change the status of the door
 * i.e, if the door is open then a person can close the door and vice versa.
 * Initially, all the doors are closed and each person wants to change the
 * status of all doors whose ID is a multiple of the ID of the person.
 *
 * You need to find out the final status of all the doors.
 *
 * The answer should be given in a form of a binary string where:
 * - '0' represents the closed door
 * - '1' represents the open door
 *
 * For example, the status "close open close" will form a binary string "010".
 *
 * ============================================================================
 * EXAMPLES:
 * ============================================================================
 *
 * Example 1:
 * ----------
 * Input: N = 2
 * Output: "10"
 *
 * Explanation:
 * Initially, all doors are closed -> "00"
 * Person 1 (ID=1) toggles doors at multiples of 1: doors 1, 2 -> "11"
 * Person 2 (ID=2) toggles doors at multiples of 2: door 2 -> "10"
 * Final Output: "10"
 *
 * Example 2:
 * ----------
 * Input: N = 4
 * Output: "1001"
 *
 * Explanation:
 * Initially, all doors are closed -> "0000"
 * Person 1 (ID=1) toggles doors 1, 2, 3, 4 -> "1111"
 * Person 2 (ID=2) toggles doors 2, 4 -> "1010"
 * Person 3 (ID=3) toggles door 3 -> "1000"
 * Person 4 (ID=4) toggles door 4 -> "1001"
 * Final Output: "1001"
 *
 */

import java.util.Scanner;

public class DoorIsOpenOrClosed{


    public static String checkDoors(int n) {
        StringBuilder result = new StringBuilder();

        // For each door from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if door i is a perfect square
            int sqrt = (int) Math.sqrt(i);

            if (sqrt * sqrt == i) {
                // Door i is a perfect square -> Open (toggled odd times)
                result.append('1');
            } else {
                // Door i is not a perfect square -> Closed (toggled even times)
                result.append('0');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        // Test Case 1: N = 2
        System.out.println("Test Case 1: N = 2");
        String output1 = checkDoors(2);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 10");
        System.out.println("Status: " + (output1.equals("10") ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 2: N = 4
        System.out.println("Test Case 2: N = 4");
        String output2 = checkDoors(4);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1001");
        System.out.println("Status: " + (output2.equals("1001") ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 3: N = 6
        System.out.println("Test Case 3: N = 6");
        String output3 = checkDoors(6);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 100100");
        System.out.println("Status: " + (output3.equals("100100") ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 4: N = 8
        System.out.println("Test Case 4: N = 8");
        String output4 = checkDoors(8);
        System.out.println("Output: " + output4);
        System.out.println("Expected: 10010000");
        System.out.println("Status: " + (output4.equals("10010000") ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 5: N = 1
        System.out.println("Test Case 5: N = 1");
        String output5 = checkDoors(1);
        System.out.println("Output: " + output5);
        System.out.println("Expected: 1");
        System.out.println("Status: " + (output5.equals("1") ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 6: N = 9
        System.out.println("Test Case 6: N = 9");
        String output6 = checkDoors(9);
        System.out.println("Output: " + output6);
        System.out.println("Expected: 100100100");
        System.out.println("Status: " + (output6.equals("100100100") ? "✓ PASS" : "✗ FAIL"));
        System.out.println();




        }
    }

