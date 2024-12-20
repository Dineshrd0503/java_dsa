package strings;
//Sample Input 1 :
//        2
//N2 i&nJA?a& jnI2n
//        A1b22Ba
//Sample Output 1 :
//Yes
//        No
//Explanation 1 :
//For the first test case, S = “N2 i&nJA?a& jnI2n”. If we ignore the special characters, whitespaces and convert all uppercase letters to lowercase, we get S = “n2injaajni2n”, which is a palindrome. Hence, the given string is also a palindrome.
//
//For the second test case, S = “A1b22Ba”. If we ignore the special characters, whitespaces and convert all uppercase letters to lowercase, we get S = “a1b22ba”, which is not a palindrome. Hence, the given string is not a palindrome.
//Sample Input 2 :
//        3
//codingninjassajNiNgNidoc
//5?36@6?35
//aaBBa@
//Sample Output 2 :
//Yes
////        Yes
//No
public class PalindromeString {
    public static boolean checkPalindrome(String str) {
        StringBuilder sb=new StringBuilder();
        for(char c:str.toCharArray()){
            if(Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }
        return sb.toString().equals(sb.reverse().toString());


        // WRITE YOUR CODE HERE

    }

    public static void main(String[] args) {
        System.out.println("String palindrome checker by removing unique characters");
        String s="@dineshhsenid*&";
        checkPalindrome(s);
    }
}
