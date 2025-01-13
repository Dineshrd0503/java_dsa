package codingninjas;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> result=new ArrayList<>();
        System.out.println("pascal triangle with 10 rows");
        int n=10;
        for(int i=0;i<10;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    row.add(1);
                else{
                    int value= result.get(i-1).get(j-1)+result.get(i-1).get(j);
                    row.add(value);
                }

            }
            result.add(row);

        }
        System.out.println("triangle is ");
        for(List<Integer> row:result)
            System.out.println(row);
    }
}
