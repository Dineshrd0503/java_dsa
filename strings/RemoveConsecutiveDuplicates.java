package strings;
//Given a string S, remove consecutive duplicates from it recursively.
//
//        Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//        1 <= |S| <= 10^3
//where |S| represents the length of string
//Sample Input 1 :
//aabccba
//Sample Output 1 :
//abcba
//Sample Input 2 :
//xxxyyyzwwzzz
//Sample Output 2 :
//xyzwz

public class RemoveConsecutiveDuplicates {
    public static String removeConsecutiveDuplicates(String s) {
        // Write your code here
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(sb.length()==0||sb.charAt(sb.length()-1)!=s.charAt(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aaabbcc")); // Expected: "abc"
        System.out.println(removeConsecutiveDuplicates("Hello World")); // Expected: "Helo Wrld"
    }

}
