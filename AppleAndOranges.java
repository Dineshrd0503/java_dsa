import java.util.Scanner;

public class AppleAndOranges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt(); // starting point of Sam's house location
        int t = scanner.nextInt(); // ending location of Sam's house location
        int a = scanner.nextInt(); // location of the Apple tree
        int b = scanner.nextInt(); // location of the Orange tree
        int m = scanner.nextInt(); // number of apples
        int n = scanner.nextInt(); // number of oranges

        int[] apples = new int[m];
        for (int i = 0; i < m; i++) {
            apples[i] = scanner.nextInt(); // distances at which each apple falls from the tree
        }

        int[] oranges = new int[n];
        for (int i = 0; i < n; i++) {
            oranges[i] = scanner.nextInt(); // distances at which each orange falls from the tree
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int applesOnHouse = 0;
        int orangesOnHouse = 0;

        for (int apple : apples) {
            if (a + apple >= s && a + apple <= t) {
                applesOnHouse++;
            }
        }

        for (int orange : oranges) {
            if (b + orange >= s && b + orange <= t) {
                orangesOnHouse++;
            }
        }

        System.out.println(applesOnHouse);
        System.out.println(orangesOnHouse);
    }
}