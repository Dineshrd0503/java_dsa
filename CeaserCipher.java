public class CeaserCipher {
    public static String caesarCipher(String s, int k) {
        StringBuilder result = new StringBuilder();
        k = k % 26;  // Ensure k is within the bounds of the alphabet (0-25)

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                // Rotate the character and wrap around using modulo
                char rotatedChar = (char) ((c - base + k) % 26 + base);
                result.append(rotatedChar);
            } else {
                // Non-alphabetical characters remain the same
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "middle-Outz";
        int k = 2;
        System.out.println(caesarCipher(s, k));  // Output: "okffng-Qwvb"
    }
}
