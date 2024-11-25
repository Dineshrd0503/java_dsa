public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
       
        sb.setCharAt(0, 'p');
        
        sb.insert(2,'o');
        sb.delete(0,3);
        System.out.println(sb);
        System.out.println("reversing strng name sammera");
        StringBuilder sb1=new StringBuilder("Sameera");
        StringBuilder revsb=new StringBuilder("");
        for(int i=sb1.length()-1;i>=0;i--){
            revsb.append(sb1.charAt(i));

        
        }
        System.out.println(revsb);
    
}
}
