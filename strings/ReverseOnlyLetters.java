package strings;

//Given a string s, reverse the string according to the following rules:
//
//All the characters that are not English letters remain in the same position.
//All the English letters (lowercase or uppercase) should be reversed.
//Return s after reversing it.
//
//
//
//        Example 1:
//
//Input: s = "ab-cd"
//Output: "dc-ba"
//Example 2:
//
//Input: s = "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
//Example 3:
//
//Input: s = "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
//
//
//Constraints:
//
//        1 <= s.length <= 100
//s consists of characters with ASCII values in the range [33, 122].
//s does not contain '\"' or '\\'.


public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] c=s.toCharArray();
        int left=0,right=s.length()-1;
        while(left<right){
            while(left<right&&!Character.isLetter(c[left]))
                left++;
            while(left<right&&!Character.isLetter(c[right]))
                right--;
            if(left<right){
                char temp=c[left];
                c[left]=c[right];
                c[right]=temp;
                left++;
                right--;
            }

        }
        return new String(c);

    }
    public static void main(String[] args) {
        ReverseOnlyLetters obj=new ReverseOnlyLetters();
        String s="ab-cd";
        System.out.println(obj.reverseOnlyLetters(s));
    }
}
