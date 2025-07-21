package logicwhilestrings;

public class CountCharacterFrequencies {
    public static void main(String[] args) {
        String a="apple";
        int[] frequency = new int[256]; // Assuming ASCII characters
        for(char ch: a.toCharArray()) {
            frequency[ch]++;
        }
        System.out.println("Character frequencies in the string \"" + a + "\":");
        for(int i = 0; i < frequency.length; i++) {
            if(frequency[i] > 0) {
                System.out.println((char)i + ": " + frequency[i]);
            }
        }

    }
}
