package logicwhilestrings;

public class ReverseString {
    public static void main(String[] args) {
        String a="Hello World";
        int left=0, right=a.length()-1;
        char[] charArray = a.toCharArray(); // Convert string to char array
        while(left<right){
           char temp=charArray[left];
           charArray[left]=charArray[right];
              charArray[right]=temp;
              left++;
                right--;
        }
        a = new String(charArray); // Convert char array back to string
        System.out.println("Reversed string is: " + a);
    }
}
