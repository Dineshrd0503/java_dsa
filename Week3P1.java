
import java.util.*;

public class Week3P1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("enter size od list");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("enter elements");
            list.add(sc.nextInt());
        }
        System.out.println("enter the key value to serach");
        int key = sc.nextInt();
        System.out.println("possible indices are " + findindices(list, key));
    }

    public static Set<Integer> findindices(List<Integer> list, int key) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == key) {
                    set.add(i);
                set.add(j);
                }
            }
        }
        return set;

    }
}
