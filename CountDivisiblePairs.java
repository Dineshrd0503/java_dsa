import java.util.* ;
import java.io.*;
public class CountDivisiblePairs{
    static int countOfDivisiblePairs(int n, int m) {
        int count=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((i+j)%5==0)
                    count+=1;
            }
        }
        return count;
        // Write your code here.
    }

}
