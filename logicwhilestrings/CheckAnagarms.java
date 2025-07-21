package logicwhilestrings;

import java.util.Arrays;

public class CheckAnagarms {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(str1+" "+str2);

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
    public static boolean areAnagrams(String str1,String str2){
        if (str1.length() != str2.length()) {
            return false; // If lengths differ, they cannot be anagrams
        }

        char[] a=str1.toCharArray();
        char[] b=str2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);


        return Arrays.equals(a,b); // All counts are zero, so they are anagrams
    }
}
