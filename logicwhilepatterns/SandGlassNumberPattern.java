package logicwhilepatterns;
/*
123456789
 1234567
  12345
   123
    1
   123
  12345
 1234567
123456789
 */

public class SandGlassNumberPattern {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++)
                System.out.print(" ");
            for(int k=0;k<(2*(n-i-1)+1);k++)
                System.out.print(k+1);
            System.out.println();
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<(n-i-1);j++)
                System.out.print(" ");
            for(int k=0;k<(2*i)+1;k++)
                System.out.print(k+1);
            System.out.println();
        }
    }
}
