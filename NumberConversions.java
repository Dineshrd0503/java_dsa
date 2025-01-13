public class NumberConversions {
    public static void main(String[] args){
        int n=121;
        String bin=Integer.toBinaryString(n);
        String oct=Integer.toOctalString(n);
        String hex=Integer.toHexString(n);

        System.out.println("Binary: "+bin);
        System.out.println("Octal: "+oct);
        System.out.println("Hexadecimal: "+hex);


    
}
}
