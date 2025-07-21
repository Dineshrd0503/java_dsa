package logicwhilestrings;

public class ReplaceAStringWithCountOfItsVowels {
    public static void main(String[] args) {
        String a="Nellore";
        StringBuilder result = new StringBuilder();
        a=a.toLowerCase();
        for(int i=0;i<a.length();i++){
            if("aeiou".indexOf(a.charAt(i))!=-1) {
               int count=i;
               while(count>0) {
                   result.append(a.charAt(i));
                   count--;
               }
            } else {
                // Count vowels in the original string 'a'

                result.append(a.charAt(i));
            }
        }
        System.out.println("Original string: " + a);
        System.out.println("String after replacing vowels with their count: " + result.toString());
    }
}
