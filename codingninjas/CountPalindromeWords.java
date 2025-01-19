package codingninjas;

//Problem statement
//You are given a string S of words. Your task is to find the number of palindrome words in the given string S. A word is called palindrome, if it reads the same backwards as forwards.
//
//        Note:
//Words are separated by one or more whitespace characters.
//For Example:
//For the given string “Madam oyo cat”, “Madam”, and “oyo” are the palindrome words
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        0 <= |S| <= 10^5
//
//All the characters of the string S contain whitespace, lowercase, and uppercase English letters only.
//
//Time limit: 1 second
//Sample Input 1:
//        1
//Nitin and I are good friends
//Sample Output 1:
//        2
//Explanation For Sample Input 1:
//For the first test case, there are 2 palindrome words only i.e “Nitin” and “I”.
//Sample Input 2:
//        2
//Madam taught us the level order traversal of a binary tree yesterday
//We love coding ninjas
//Sample output 2:
//        3
//        0

public class CountPalindromeWords {
    public static int countNumberOfPalindromeWords(String s)
    {
        int count=0;
        String[] words=s.split("\\s+");
        for(String word:words){
            if(!word.isEmpty()&&checkPalindrome(word))
                count++;
        }
        return count;
        // Write your code here!
    }
    private static boolean checkPalindrome(String word){
        String temp=word.toLowerCase();
        StringBuilder sb=new StringBuilder(temp);
        String rev=sb.reverse().toString();
        return temp.equals(rev);
    }
    public static void main(String[] args) {
        System.out.println("counting the number of palindrome words in a string");
        String s="Wow Madam is driving racecar";
        System.out.println(countNumberOfPalindromeWords(s));
    }

}
