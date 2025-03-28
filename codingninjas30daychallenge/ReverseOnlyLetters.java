// Problem statement
// You are given a string, ‘S’. You need to reverse the string where characters that are not an alphabet stay in the same place, and the rest reverse their positions.

// Eg: “a-bcd” becomes “d-cba”

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 10
// 0 <= |S| <= 5000

// Where |S| denotes the length of string 'S'.

// Time Limit: 1 Sec
// Sample Input 1:
// 2
// a-bcd
// !s-cx
// Sample Output 1:
// d-cba
// !x-cs
// Explanation Of Sample Input 1:
// In the first test case:
// “a-bcd” after removing non-letter will be “abcd”.
// Reversing “abcd” will get “dcba”.
// Placing non-letters in the correct position in “dcba”, we get: “d-cba”.

// In the second test case:
// “!s-cx” after removing non-letter will be “scx”.
// Reversing “scx” will get “xcs”.
// Placing non-letters in the correct position in “xcs”, we get: “!x-cs”.
// Sample Input 2:
// 2
// a-bC-dEf-ghIj
// Qedo1ct-eeLg=ntse-T!
// Sample Output 2:
// j-Ih-gfE-dCba
// Test1ng-Leet=code-Q!
// Explanation Of Sample Input 2:
// In the first test case:
// “a-bC-dEf-ghIj” after removing non-letter will be “abCdEfghlj”.
// Reversing “abCdEfghlj” will get “jlhgfEdCba”.
// Placing non-letters in the correct position in “jlhgfEdCba”, we get: “j-Ih-gfE-dCba”.

// In the second test case:
// “!s-cx” after removing non-letter will be “Qedo1ct-eeLg=ntse-T!”.
// Reversing “QedocteeLgntseT” will get “TestngLeetcodeQ”.
// Placing non-letters in the correct position in “TestngLeetcodeQ”, we get: “Test1ng-Leet=code-Q!”.

package codingninjas30daychallenge;



public class ReverseOnlyLetters {

    public static void main(String[] args) {
        String input = "a-bC-dEf-ghIj"; // Example input
        String result = topReverse(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed Letters: " + result);
    }

    public static String topReverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Move left pointer to the next letter
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            // Move right pointer to the previous letter
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }
            // Swap the letters
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}