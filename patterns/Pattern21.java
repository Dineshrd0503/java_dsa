package patterns;

public class Pattern21 {
    public static void main(String[] args) {
        int n=5;
        int num=1;
        System.out.println("printing inevrted number pyramid");
        for(int i=n;i>=1;i--){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(num+" ");
            }
            num++;
            System.out.println();
        }
        System.out.println("printing inevrted character pyramid");
        char ch='a';
        for(int i=n;i>=1;i--){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(ch+" ");
            }
            ch++;
            System.out.println();
        }
    }
}
