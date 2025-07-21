package logicwhilestrings;

public class ReplaceVowelWithSpecialSymbol {
    public static void main(String[] args) {
        String a="Nellore";
        a=a.toLowerCase();
        String result="";
        System.out.println("Original string: " + a);
        for(int i=0;i<a.length();i++){
            if("aeiou".indexOf(a.charAt(i))!=-1)
            result=a.replace(a.charAt(i),'@');

        }

        System.out.println("String after replacing vowels with '@': " + result);
    }
}
