package strings;
//You are given a string 'str' of length 'N'.
//
//
//
//Your task is to reverse the original string word by word.
//
//
//
//There can be multiple spaces between two words and there can be leading or trailing spaces but in the output reversed string you need to put a single space between two words, and your reversed string should not contain leading or trailing spaces.
//
//
//
//Example :
//If the given input string is "Welcome to Coding Ninjas", then you should return "Ninjas Coding to Welcome" as the reversed string has only a single space between two words and there is no leading or trailing space.
//Sample Input 1 :
//Welcome to Coding Ninjas
//Sample Output 1:
//Ninjas Coding to Welcome
//Explanation For Sample Input 1:
//You need to reduce multiple spaces between two words to a single space in the reversed string and observe how the multiple spaces, leading and trailing spaces have been removed.
//Sample Input 2 :
//I am a star
//Sample Output 2:
//star a am I
//Explanation For Sample Input 2:
//Your reversed string should not contain leading or trailing spaces.

public class ReverseWords {
    public static String reverseString(String str)
    {
        String[] words=str.split("\\s+");
        StringBuffer sb=new StringBuffer();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i>0)
                sb.append(" ");
        }
        return sb.toString();

        //Write your code here
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(reverseString(str)); // Output: World Hello
    }
}
