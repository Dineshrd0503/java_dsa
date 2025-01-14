import java.util.ArrayList;
import java.util.List;

public class CountingSort {
    public static List<Integer> countingSort(int[] arr) {
        List<Integer> freqList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            freqList.add(0);
        }
        for (int num : arr) {
            freqList.set(num, freqList.get(num) + 1);
        }
        return freqList;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 2, 1};
        List<Integer> freqList = countingSort(arr);
        System.out.println("Frequency List: " + freqList);
    }
}