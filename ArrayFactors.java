import java.util.List;
import java.util.Collections;
import java.util.Scanner;
//checks whteher integer is afactor of eleemts of array a and if array elemnts of b are factors of integer i
public class ArrayFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of elements in list a
        int m = scanner.nextInt(); // number of elements in list b

        List<Integer> a = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt()); // elements of list a
        }

        List<Integer> b = new java.util.ArrayList<>();
        for (int i = 0; i < m; i++) {
            b.add(scanner.nextInt()); // elements of list b
        }

        System.out.println(getTotalX(a, b));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;
        int maxA = getMax(a);
        int minB = getMin(b);

        for (int i = maxA; i <= minB; i++) {
            if (isBetween(a, b, i)) {
                count++;
            }
        }

        return count;
    }

    public static int getMax(List<Integer> list) {
        return Collections.max(list);
    }

    public static int getMin(List<Integer> list) {
        return Collections.min(list);
    }

    public static boolean isBetween(List<Integer> a, List<Integer> b, int x) {
        for (int i = 0; i < a.size(); i++) {
            if (x % a.get(i) != 0) {
                return false;
            }
        }

        for (int i = 0; i < b.size(); i++) {
            if (b.get(i) % x != 0) {
                return false;
            }
        }

        return true;
    }
}