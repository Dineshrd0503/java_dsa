package logicwhilearrays;

public class NumbersWithEvenNoOfDigits {
    public static void main(String[] args) {
        int[] a = {12, 345, 2, 6, 7896};
        System.out.println(countNumbersWithEvenDigits(a));
    }
    public static int countNumbersWithEvenDigits(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (countDigits(num) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    public static int countDigits(int num) {
        if (num == 0) return 1; // Special case for 0
        int count = 0;
        while (num > 0) {
            num /= 10; // Remove the last digit
            count++;
        }
        return count;
    }
}
