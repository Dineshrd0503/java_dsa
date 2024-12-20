package codingninjas;

import java.util.ArrayList;
//Ninja wants to build a star pattern for a given odd number.
//
//The pattern for ‘N’ = 7  will look like this:
//
//        *
//        **
//        ***
//        ****
//        ***
//        **

public class StarPattern {
    public static String[] galaxyofStar(int n) {
        ArrayList<String> result=new ArrayList<>();
        for(int i=1;i<=n/2+1;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=1;j<=i;j++){

                sb.append("*");

            }
            result.add(sb.toString());
        }
        for(int i=n/2;i>=1;i--){
            StringBuilder sb=new StringBuilder();
            for(int j=1;j<=i;j++){
                sb.append("*");
            }
            result.add(sb.toString());
        }
        return result.toArray(new String[0]);

        // Write your code here
    }

    public static void main(String[] args) {
        int n=5;
        String[] galaxy=galaxyofStar(n);
        for(String s:galaxy){
            System.out.println(s);
        }

    }

}
