package patterns;
public class Pattern15 {
    
    public static void main(String[] args) {
        int n = 5;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++)
            System.out.print(" ");
            char ch='A';
            for(int k=1;k<=2*i+1;k++){
                System.out.print(ch);
                if(k<=(2*i+1)/2)
                ch++;
                else
                ch--;
            }
            for(int j=0;j<n-i-1;j++)
            System.out.print(" ");
            System.out.println();
            
        }
        
    }
    
}
