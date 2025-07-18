package logicwhilestrings;

public class CountVowelsAndConstants {
    public static void main(String[] args) {
        System.out.println("counting vowels and constants in a string");
        String str = "Hello World";
        int vowels = 0, consonants = 0;
        str = str.toLowerCase(); // Convert to lowercase for easier comparison
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isLetter(ch)) {

                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        System.out.println(ch + " is a vowel");
                        vowels++;
                    } else {
                        System.out.println(ch + " is a consonant");
                        consonants++;
                    }

            }
        }
        System.out.println("Total vowels: " + vowels);
        System.out.println("Total consonants: " + consonants);
    }
}
