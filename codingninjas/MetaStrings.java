package codingninjas;

import java.util.ArrayList;
import java.util.List;

public class MetaStrings {
    public static void main(String[] args) {
        String str1="coding";
        String str2="codnig";
        boolean result=compare(str1,str2);
        if(result)
            System.out.println("strings are metaStrings");
        else
            System.out.println("strings are not metaStrings");
    }
    public static boolean compare(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i))
                list.add(i);
        }
        if(list.size()==0||list.size()>2)
            return false;
        if(list.size()==2){
            int i=list.get(0);
            int j=list.get(1);
            return str1.charAt(i) == str2.charAt(j) && str1.charAt(j) == str2.charAt(i);
        }
        return false;

    }
}
