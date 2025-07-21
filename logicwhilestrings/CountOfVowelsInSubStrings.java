package logicwhilestrings;

public class CountOfVowelsInSubStrings {
    public static void main(String[] args) {
        String s = "fruit juice";
        int count1= 0,count2=0;
        int mid=s.length()/2;
        s=s.toLowerCase();
        String a=s.substring(0,mid);
        String b=s.substring(mid,s.length());
        System.out.println("First half: " + a);
        System.out.println("Second half: " + b);
        for (int i = 0; i <a.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1)
                count1++;

        }
        System.out.println("Total count of vowels in the substring1: " + count1);
        for (int i = 0; i < b.length(); i++) {
            if ("aeiou".indexOf(b.charAt(i)) != -1)
                count2++;
        }
        System.out.println("Total count of vowels in the substring2: " + count2);

        System.out.println("abs diff is : " + Math.abs(count1 - count2));
    }
}
