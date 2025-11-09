package arrays;

/*
LeetCode Problem: Count Operations to Obtain Zero

Statement:
You are given two non-negative integers num1 and num2.
In one operation, you:
  - subtract the smaller number from the larger one.
  - Then update the larger number with this new value.
Continue this process until either num1 == 0 or num2 == 0.
Return the total number of operations required to make at least one number zero.

Example:
Input: num1 = 5, num2 = 3
Output: 3
Explanation:
  5 - 3 = 2, count = 1
  3 - 2 = 1, count = 2
  2 - 1 = 1, count = 3
  (Now one number is zero)
*/

public class CountOperationsToObtainZero {
    public static int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                count += num1 / num2;
                num1 = num1 % num2;
            } else {
                count += num2 / num1;
                num2 = num2 % num1;
            }
        }
        return count;
    }

    // Main method with static inputs
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 3;
        int result = countOperations(num1, num2);
        System.out.println("Count of operations to obtain zero: " + result);

        // You can test with other static inputs:
        System.out.println("Test case 2: num1 = 10, num2 = 10 -> " + countOperations(10, 10));
        System.out.println("Test case 3: num1 = 100, num2 = 1 -> " + countOperations(100, 1));
    }
}
