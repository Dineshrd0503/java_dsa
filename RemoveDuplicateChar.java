import java.util.*;

public class RemoveDuplicateChar{
    public static void main(String[] args){
        String str = "abcddac";
        boolean[] map=new boolean[26];
        removeduplicates(str,0,"",map);
        System.out.println("using hashmaps");
        System.out.println("string withour dupliates os "+hashmap(str));
    }
    public static void removeduplicates(String str, int index, String newstring, boolean[] map) {
        if (index == str.length()) {
            System.out.println(newstring);
            return;
        }
        char currchar = str.charAt(index);
        if (map[currchar - 'a'] == true) {
            removeduplicates(str, index + 1, newstring, map);
        } else {
            map[currchar - 'a'] = true;
            removeduplicates(str, index + 1, newstring + currchar, map);
        }
    }
    public static String hashmap(String str){
        Set<Character> s=new HashSet<>();
        StringBuffer revstr=new StringBuffer();
        for(char c:str.toCharArray()){
            if(!s.contains(c)){
                s.add(c);
                revstr.append(c);
            }

        }
        return revstr.toString();
    }
}