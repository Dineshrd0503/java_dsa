public class SaveThePrisoner{
    public static int saveThePrisoner(int n, int m, int s) {
        // Calculate the position of the last candy using modulo arithmetic
        int lastPrisoner = (s + m - 1) % n;

        // If the result is 0, the last prisoner is the last one in the circle (i.e., n)
        return lastPrisoner == 0 ? n : lastPrisoner;
    }

    public static void main(String[] args) {
        int n = 5;  // Number of prisoners
        int m = 2;  // Number of candies
        int s = 1;  // Starting position

        int result = saveThePrisoner(n, m, s);  // Call the function
        System.out.println(result);  // Output: 2
    }
}
