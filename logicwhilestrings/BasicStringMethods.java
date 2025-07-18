package logicwhilestrings;

public class BasicStringMethods {
    public static void main(String[] args) {
        String s = "hello world";
        System.out.println("Original string: " + s);
        System.out.println("Reversed string: ");
        reverseString(s, s.length() - 1);
        System.out.println("\nLength of string: " + s.length());
        System.out.println("Character at index 6: " + s.charAt(6));
        System.out.println("Substring from index 6: " + s.substring(6));
        System.out.println("Substring from index 0 to 5: " + s.substring(0, 5));
        System.out.println("Index of 'o': " + s.indexOf('o'));
        System.out.println("Last index of 'o': " + s.lastIndexOf('o'));
        System.out.println("Contains 'world': " + s.contains("world"));
        System.out.println("Starts with 'hello': " + s.startsWith("hello"));
        System.out.println("Ends with 'world': " + s.endsWith("world"));
        System.out.println("Replace 'o' with 'x': " + s.replace('o', 'x'));
        System.out.println("Uppercase: " + s.toUpperCase());
        System.out.println("Lowercase: " + s.toLowerCase());
        String s2 = "  trimmed string  ";
        System.out.println("Original string with spaces: '" + s2 + "'");
        System.out.println("Trimmed string: '" + s2.trim() + "'");
        String[] words = s.split(" ");
        System.out.print("Split by space: ");
        for (String word : words) {
            System.out.print(word + ", ");
        }
        System.out.println();
        String s3 = "hello";
        String s4 = "world";
        System.out.println("Concatenated string: " + s3.concat(" ").concat(s4));
        System.out.println("Is s equal to 'hello world'? " + s.equals("hello world"));
        System.out.println("Is s equal to 'Hello World' (ignore case)? " + s.equalsIgnoreCase("Hello World"));
    }

    public static void reverseString(String s, int index) {
        if (index == -1) {
            return;
        }
        System.out.print(s.charAt(index));
        reverseString(s, index - 1);
    }
}
