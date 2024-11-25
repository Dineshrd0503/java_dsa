public class PalindromeChecker {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reversed = 0;
        int original = x;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            reversed = reversed * 10 + pop;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        PalindromeChecker solution = new  PalindromeChecker();
        int num1 = 121;
        int num2 = 123;

        System.out.println("Is " + num1 + " a palindrome? " + solution.isPalindrome(num1));
        System.out.println("Is " + num2 + " a palindrome? " + solution.isPalindrome(num2));
    }
}