import java.util.*;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> s = new HashMap<>();
        for (int n : a) {
            s.put(n, s.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : s.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1; // or throw an exception if no lonely integer is found
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        int result = lonelyinteger(a);
        System.out.println("The lonely integer is: " + result);
    }
}