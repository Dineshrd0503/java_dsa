import java.util.Scanner;

public class KangrooDistance {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x1 = scanner.nextInt();
    int v1 = scanner.nextInt();
    int x2 = scanner.nextInt();
    int v2 = scanner.nextInt();

    System.out.println(kangaroo(x1, v1, x2, v2));
}
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 == v2) {
            if (x1 == x2) {
                return "YES";
            } else {
                return "NO";
            }
        }
    
        int jumpDiff = v1 - v2;
        int locationDiff = x2 - x1;
    
        if (jumpDiff > 0) {
            if (locationDiff % jumpDiff == 0 && locationDiff / jumpDiff > 0) {
                return "YES";
            } else {
                return "NO";
            }
        } else {
            return "NO";
        }
    }
    
}
