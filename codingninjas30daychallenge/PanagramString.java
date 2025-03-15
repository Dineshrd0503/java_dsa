package codingninjas30daychallenge;

import java.util.HashSet;
import java.util.Set;

public class PanagramString {
    public static boolean ninjaGram(String s) {
        Set<Character> set=new HashSet<>();

        for(char c:s.toLowerCase().toCharArray()){
            if(Character.isLetter(c))
                set.add(c);
        }
        return set.size()==26;

        // Write your code here

    }
    public static void main(String[] args) {
        System.out.println("Checking for panagram string");
        String str="The quick brown fox jumps over the lazy dog";
        System.out.println(ninjaGram(str));
    }
}
