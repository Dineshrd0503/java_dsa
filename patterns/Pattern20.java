package patterns;

public class Pattern20 {
    public static void main(String[] args) {
        int n=5;
        int num=1;
        System.out.println("flyod truanle in left half pyramd");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
        System.out.println("flyod truanle inverted");
        for(int i=1;i<=5;i++){
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println("character flyod truanle inverted");
        for(char i='a';i<='e';i++){
            for(char j=i;j>='a';j--){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
