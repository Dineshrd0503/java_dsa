package logicwhilestrings;

public class PalindromeStringTwoPointers {
    public static void main(String[] args) {
        String str = "madam";
        boolean isPalindrome = isPalindrome(str);

            System.out.println(isPalindrome?str + " is a palindrome.":str + " is not a palindrome.");

    }
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left)!=str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
