package patterns;

public class Pattern23{
    public static void NumberPattern(int n) {
        // Loop through each row
        for (int i = 1; i <= n; i++) {
            // Loop through each column in the row
            for (int j = 1; j <= n; j++) {
                if (j < i) {
                    // Print decreasing values starting from (n - i + j)
                    System.out.print(n - (i - j));
                } else {
                    // Print the constant value 'n'
                    System.out.print(n);
                }
            }
            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 4;  // You can change the value of N here
        NumberPattern(N);
    }
}

