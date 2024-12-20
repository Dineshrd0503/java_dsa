package codingninjas;

public class Gcd {
    public static int calcGCD(int n, int m) {
        if (m == 0)  // Base case: when the second number becomes 0
            return n;
        return calcGCD(m, n % m); // Recursive call with m and n % m
    }

    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 36;
        int gcd = calcGCD(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is " + gcd);
    }

}
