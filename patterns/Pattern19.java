package patterns;

public class Pattern19 {
    public static void main(String[] args) {
        int n=3,num=1;
        System.out.println("number pattern");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();

        }
        System.out.println("chacter apttern");
        char ch='a';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }

}
