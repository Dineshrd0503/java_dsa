package codingninjas;

//Problem statement
//You are given a string 'S'. Your task is to reverse the vowels in the string while keeping the consonants unchanged.
//
//Note:
//
//The alphabets 'a', 'e', 'i', 'o', and 'u' are vowels, while all the remaining alphabets are consonants.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= |S| <= 10^5

//All characters of string S are lowercase alphabets only.
//
//        Where '|S|' denotes the length of string 'S'.
//
//Time limit: 1 sec
//Sample Input 1:
//        2
//abced
//        pperu
//Sample Output 1:
//ebcad
//        ppure
//Explanation for Sample Input 1:
//For the first test case, the vowels 'a' and 'e' are present in the string. The resulting string formed after reversing the vowels is "ebcad".
//
//For the second test case, the vowels 'e' and 'u' are present in the string. The resulting string formed after reversing the vowels is "ppure".
//Sample Input 2:
//        2
//ababa
//        zyxw
//Sample Output 2:
//ababa
//        zyxw


public class ReverseVowelsInStr {
    public static String reverseVowels(String s){
        // Write your code here.

        char[] letters=s.toCharArray();
        int left=0,right=letters.length-1;
        while(left<right){
            while(left<right&&!isvowel(letters[left]))
                left++;
            while(left<right&&!isvowel(letters[right]))
                right--;
            if(left<right){
                char temp=letters[left];
                letters[left]=letters[right];
                letters[right]=temp;
                left++;
                right--;
            }

        }
        return new String(letters);
    }
    private static boolean isvowel(char c){

        return "aeiouAEIOU".indexOf(c)!=-1;
    }
    public static void main(String[] args) {
        System.out.println("reversing vowels in string");
        String str="hello";
        System.out.println(reverseVowels(str));
    }
}
