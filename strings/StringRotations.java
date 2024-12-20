package strings;
//You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.
//
//        Note: The characters in the strings are in lowercase.
//
//Examples :
//
//Input: s1 = "abcd", s2 = "cdab"
//Output: true
//Explanation: After 2 right rotations, s1 will become equal to s2.
//        Input: s1 = "aab", s2 = "aba"
//Output: true
//Explanation: After 1 left rotation, s1 will become equal to s2.
//        Input: s1 = "abcd", s2 = "acbd"
//Output: false
//Explanation: Strings are not rotations of each other.
public class StringRotations {
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        String temp=s1+s1;
        return temp.contains(s2)?true:false;
    }
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "cdeab";
        System.out.println(areRotations(s1, s2)); // Output: true
    }
}
