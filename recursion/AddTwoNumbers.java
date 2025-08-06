package recursion;
public class AddTwoNumbers {
    /**
     * Recursively calculates the sum of two integers.
     *
     * @param num1 The first integer.
     * @param num2 The second integer.
     * @return The sum of the two integers.
     */
    public static int sumRecursive(int num1, int num2) {
        // Base case: If num2 is 0, the sum is num1.
        if (num2 == 0) {
            return num1;
        }

        // Recursive step: Add 1 to num1 and subtract 1 from num2. (or vice versa)
        //The approach avoids using the built-in + operator directly, simulating addition through repeated increment and decrement.
        if (num2 > 0) {
            return sumRecursive(num1 + 1, num2 - 1);
        } else {
            return sumRecursive(num1 - 1, num2 + 1);
        }
    }

    public int sum(int num1, int num2) {
        return num1 + num2;
    }


    public static void main(String[] args) {
        // Example usage // Output: 17

        int num1 = 12;
        int num2 = 5;
        int result = sumRecursive(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result); // Output: 17

        num1 = -10;
        num2 = 4;
        result = sumRecursive(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result); // Output: -6

        num1 = 0;
        num2 = 0;
        result = sumRecursive(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result); // Output: 0

        num1 = 100;
        num2 = -100;
        result = sumRecursive(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result); // Output: 0


      //Example w/o recursion

        AddTwoNumbers sol = new AddTwoNumbers();

        num1 = 12;
        num2 = 5;
        result = sol.sum(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result);

    }
}
