package recursion;
public class RevStr{
    public static void main(String[] args) {
        String str = "Helloworld";
        System.out.println("Original String: " + str);
        revstr(0,str,"");
    }

    public static void revstr(int index, String str, String result) {
        if(index==str.length()){
            System.out.println("Reversed String: " + result);
            return;
        }
        revstr(index+1, str, str.charAt(index) + result);
    }

}