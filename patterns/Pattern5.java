package patterns;
public class Pattern5{
    public static void main(String[] args) {
        int n=5;
       for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            System.out.print(j+" ");
        }
        System.out.println();

       }
        System.out.println("printing the same pattern as right half pyramid");
        for(int i=1;i<=n;i++){
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            System.out.println();

        }
        
    }
}