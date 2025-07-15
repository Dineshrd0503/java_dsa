package logicwhilearrays;

import java.util.Arrays;

public class CountOfCharactersInString {
    public static void main(String[] args) {
        String s="hello";
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        System.out.println(Arrays.toString(freq));
    }
}
