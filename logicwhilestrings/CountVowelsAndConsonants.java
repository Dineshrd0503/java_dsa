package logicwhilestrings;

public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        String str = "Hello World";
        int vowels = 0, consonants = 0;
        str=str.toLowerCase(); // Convert to lowercase to simplify checks
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println(str);

        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
    }
}
