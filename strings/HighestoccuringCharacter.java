package strings;
//Problem statement
//For a given a string(str), find and return the highest occurring character.
//
//Example:
//Input String: "abcdeapapqarr"
//Expected Output: 'a'
//Since 'a' has appeared four times in the string which happens to be the highest frequency character, the answer would be 'a'.
//If there are two characters in the input string with the same frequency, return the character which comes first.
//

import java.util.*;

////        Consider:
//Assume all the characters in the given string to be in lowercase always.
public class HighestoccuringCharacter {
    public static char highestOccuringChar(String str) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        for(char c:str.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        char highchar='\0';
        int highestfreq=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char character=entry.getKey();
            int frequency=entry.getValue();
            if(highestfreq<frequency){
                highestfreq=frequency;
                highchar=character;
            }

        }
        return highchar;
        //Your code goes here
    }
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Highest Occurring Character: " + highestOccuringChar(str));
    }
}
