package wiprointerviewforda;
public class RemoveSpecialChars {
    // Problem: Remove all special characters from a string
    // Sample Test Cases:
    // Input: str = "Hello@World!123"
    // Output: HelloWorld123
    // Input: str = "!@#$%^"
    // Output: ""
    // Input: str = ""
    // Output: ""

    public static String removeSpecialChars(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static void main(String[] args) {
        // Test Case 1
        String str1 = "Hello@World!123";
        System.out.println("Test Case 1:");
        System.out.println(removeSpecialChars(str1));

        // Test Case 2
        String str2 = "!@#$%^";
        System.out.println("\nTest Case 2:");
        System.out.println(removeSpecialChars(str2));

        // Test Case 3
        String str3 = "";
        System.out.println("\nTest Case 3:");
        System.out.println(removeSpecialChars(str3));
    }
}