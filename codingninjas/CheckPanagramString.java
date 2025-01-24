package codingninjas;

import java.util.HashSet;

//Problem statement
//Ninja is shifting to a new place named NinjaGram. To take admission to the new school, the teacher gives him a sentence and asks him to check whether the sentence is a pangram.
//
//A word or a sentence is called a pangram if it contains all the English alphabet letters.
//
//Since Ninja is new to programming, he doesn’t have much experience; he asks you to solve the problem. Can you help Ninja figure out whether the sentence is a pangram?
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1<= T <= 50
//        1<= n <= 10^4
//
//
//Where ’T’ is the number of test cases, ‘n’ denotes the number of characters in the string.
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        12
//toosmallword
//35
//TheQuickBrownFoxJumpsOverTheLazyDog
//Sample Output 1:
//NO
//        YES
//Explanation for Sample Input 1:
//In the first test case, the given string is “toosmallword” which contains the characters [‘t’,’o’,’s’,’m’,’a’,’l’,’w’,’r’,’d’], which doesn’t contain all the 26 alphabetic characters. Hence the answer is “NO”.
//
//
//In the second test case, the given string is “TheQuickBrownFoxJumpsOverTheLazyDog” which contains the characters: [‘t’,’h’,’e’,’q’,’u’,’i’,’c’,’k’,’b’,’r’,’o’,’w’,’n’,’f’,’x’,’j’,’m’,’p,’’s’,’v’,’l,’a’,’z’,’y’,’ d’,’g’], which contains all the 26 alphabetic characters. Hence the answer is “YES”.
//Sample Input 2:
//
//        2
//        16
//CodingNinjas
//10
//CodeStudio
//Sample Output 2:
//NO
//        NO
//Explanation for Sample Input 2:
//In the first test case, the given string is “CodingNinjas” which contains the characters [‘c’,’o’,’d’,’i’,’n’,’g’,’i’,’j’,’a’,’s’], which doesn’t contain all the 26 alphabetic characters. Hence the answer is “NO”.
//
//
//In the first test case, the given string is “CodeStudio” which contains the characters [‘c’,’o’,’d’,’e’,’s’,’t’,’u’,’i’], which doesn’t contain all the 26 alphabetic characters. Hence the answer is “NO”.



public class CheckPanagramString {
    public static boolean ninjaGram(String str) {
        HashSet<Character> set=new HashSet<>();
        str=str.toLowerCase();
        for(char c:str.toCharArray()){
            if(Character.isLetter(c))

                set.add(c);
        }
        return set.size()==26;


        // Write your code here

    }

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(ninjaGram(str)); // Output: true
    }
}
