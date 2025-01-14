import java.util.Scanner;

// Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.

// Lily decides to share a contiguous segment of the bar selected such that:

// The length of the segment matches Ron's birth month, and,
// The sum of the integers on the squares is equal to his birth day.
// Determine how many ways she can divide the chocolate.

public class ChocolateBarProblem {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of squares in the chocolate bar
        int[] s = new int[n]; // numbers on each of the squares of chocolate
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }
        int d = scanner.nextInt(); // Ron's birth day
        int m = scanner.nextInt(); // Ron's birth month

        System.out.println(birthday(s, d, m));
    }

    public static int birthday(int[] s, int d, int m) {
        int count = 0;
        for (int i = 0; i <= s.length - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s[j];
            }
            if (sum == d) {
                count++;
            }
        }
        return count;
    }
}