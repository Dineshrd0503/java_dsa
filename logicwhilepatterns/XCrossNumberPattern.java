package logicwhilepatterns;

public class XCrossNumberPattern {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||j==n-i-1)
                    System.out.print((i+1));
                else
                    System.out.print(" ");

            }
            System.out.println();

        }

    }
}
