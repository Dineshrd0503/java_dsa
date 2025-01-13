package geeksforgeeks;

import java.util.Arrays;

public class AnagramStrings {
    public static void main(String[] args) {
        String s1="hello world";
        String s2="holle owlrd";
        if(compare(s1,s2))
            System.out.println("strings are anagrams");
        else
            System.out.println("Strings are not anagarams");
    }
    private static boolean compare(String s1,String s2){
        char[] c1=s1.toLowerCase().toCharArray();
        char[] c2=s2.toLowerCase().toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }
}
