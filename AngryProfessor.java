import java.util.*;

public class AngryProfessor {

    public static void main(String[] args) {
        // Create a scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int t = scanner.nextInt();

        // Loop through all test cases
        for (int i = 0; i < t; i++) {
            // Read the number of students (n) and the cancellation threshold (k)
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            // Create a list to store the arrival times of the students
            List<Integer> a = new ArrayList<>();

            // Read the arrival times of the students
            for (int j = 0; j < n; j++) {
                a.add(scanner.nextInt());
            }

            // Call the angryProfessor method and print the result
            String result = angryProfessor(k, a);
            System.out.println(result);
        }

        // Close the scanner
        scanner.close();
    }

    public static String angryProfessor(int k, List<Integer> a) {
        int count = 0;
        for (int n : a) {
            if (n <= 0) {
                count++;
            }
        }
        return count >= k ? "NO" : "YES"; // "NO" means class is not canceled, "YES" means it is canceled
    }
}
