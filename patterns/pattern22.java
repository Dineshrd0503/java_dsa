package patterns;
public class pattern22 {
    public static void main(String[] args) {
        int n = 5; // Change the value of n to desired size of diamond

        // Top part of diamond
        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // First asterisk
            System.out.print("*");
            // Middle part
            if (i != 0) {
                for (int k = 0; k < 2 * i - 1; k++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }

        // Bottom part of diamond
        for (int i = n - 1; i >= 0; i--) {
            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // First asterisk
            System.out.print("*");
            // Middle part
            if (i != n - 1) {
                for (int k = 0; k < 2 * i - 1; k++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}