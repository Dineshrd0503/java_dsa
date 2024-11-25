public class ReverseString {
    public static void main(String[] args) {
        String s="hello world";
        System.out.println("orignial string "+s);
        System.out.println("reversing string");
        revstr(s,s.length()-1);
    }
    static void revstr(String s,int index){
        if(index==0){
            System.out.print(s.charAt(index));
            return;

        }
        System.out.print(s.charAt(index));
        revstr(s, index-1);

    }
    
}
