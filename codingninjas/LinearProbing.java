package codingninjas;
//Sample Input 1:
//        2
//        5
//        5 3 2 6 4
//        4
//        1 5 3 7
//Sample Output 1:
//        5 6 2 3 4
//        7 1 5 3
//Explanation
//For test case 1:
//H(X) = X mod 5
//All the numbers have unique hash values so there is no collision. Just map each index to its hash index.
//
//For test case 2:
//H(1) = 1L index 1 is unoccupied so we will map index 1 with 1.
//H(5) = 1: but, index 1 is occupied, so, we will use index 2 which is unoccupied, and will map index 2 with 5.
//H(3) = 3: index 3 is unoccupied so we will map index 3 with 3.
//H(7) = 3, but index 3 is occupied so we will use index 0 which is unoccupied and will map index 0 with 7.
//Sample Input 2:
//        2
//        6

import java.util.Arrays;
import java.util.List;

////        4 7 8 1 2 5
//        3
//        6 7 10
//Sample Output 2:
//        5 7 8 1 4 2
//        6 7 10
public class LinearProbing {
    public static int[] linearProbing(List<Integer> keys) {
        int[] result=new int[keys.size()];
        Arrays.fill(result,-1);
        for(int n:keys){
            int i=n%keys.size();
            while(result[i]!=-1)
                i=(i+1)%keys.size();
            result[i]=n;

        }
        return result;
        // Write your code here.
    }
    public static void main(String[] args) {
        List<Integer> keys = Arrays.asList(15, 21, 12, 18, 27, 33, 45, 51, 66, 78);
        int[] result = linearProbing(keys);
        System.out.println(Arrays.toString(result));
    }


}
