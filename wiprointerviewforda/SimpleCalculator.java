package wiprointerviewforda;
public class SimpleCalculator {
    // Problem: Implement a simple calculator with +, -, *, / operations
    // Sample Test Cases:
    // Input: a=10, b=5
    // Output: Add=15, Subtract=5, Multiply=50, Divide=2.0
    // Input: a=8, b=0
    // Output: Divide throws exception
    // Input: a=-2, b=3
    // Output: Add=1, Subtract=-5, Multiply=-6, Divide=-0.666...

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        // Test Case 1
        double a1 = 10, b1 = 5;
        System.out.println("Test Case 1:");
        System.out.println("Add: " + add(a1, b1));
        System.out.println("Subtract: " + subtract(a1, b1));
        System.out.println("Multiply: " + multiply(a1, b1));
        System.out.println("Divide: " + divide(a1, b1));

        // Test Case 2
        double a2 = 8, b2 = 0;
        System.out.println("\nTest Case 2:");
        try {
            System.out.println("Divide: " + divide(a2, b2));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        // Test Case 3
        double a3 = -2, b3 = 3;
        System.out.println("\nTest Case 3:");
        System.out.println("Add: " + add(a3, b3));
        System.out.println("Subtract: " + subtract(a3, b3));
        System.out.println("Multiply: " + multiply(a3, b3));
        System.out.println("Divide: " + divide(a3, b3));
    }
}