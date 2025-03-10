package codingninjas;

import java.util.ArrayList;

//You are given a binary matrix (it contains only 0s and 1s) with dimensions ‘N * M’. You need to find and return the sum of coverages of all zeros of the given matrix.
//
//        Coverage for a particular 0 is defined as the total number of ‘1s’ around it (i.e., immediate left, immediate right, immediate up, and immediate bottom positions).
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N, M <= 10^3
//
//Time limit: 1 second
//Sample Input 1:
//        1
//        2 2
//        1 0
//        0 1
//Sample Output 1:
//        4
//Explanation of Input 1:
//In the given matrix, there are 2 zeros.
//For the 0 at the 1st row, 2nd column position, coverage is 2(there is 1 adjacent top one and 1 adjacent right one).
//For the 0 at the 2nd row, 2nd column the coverage is 2(there is 1 adjacent top one and 1 adjacent right one).
//
//Hence the net coverage is 2 + 2 = 4.
//Sample Input 2:
//        1
//        2 3
//        0 0 0
//        0 0 0
//Sample Output 2
//        0


public class SumOfZeros {
    public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {

        // Write your code here.
        int n=mat.size();
        int m=mat.get(0).size();
       int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat.get(i).get(j)==0){
                    if(i>0&&mat.get(i-1).get(j)==1) sum++;
                    if(i<n-1&&mat.get(i+1).get(j)==1)sum++;
                    if(j>0&&mat.get(i).get(j-1)==1) sum++;
                    if(j<m-1&&mat.get(i).get(j+1)==1)sum++;


                }

            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("Sum of zeros");
        ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
        ArrayList<Integer> row1=new ArrayList<>();
        row1.add(1);
        row1.add(1);
        row1.add(1);
        row1.add(1);
        ArrayList<Integer> row2=new ArrayList<>();
        row2.add(1);
        row2.add(1);
        row2.add(1);
        row2.add(1);
        ArrayList<Integer> row3=new ArrayList<>();
        row3.add(1);
        row3.add(1);
        row3.add(0);
        row3.add(1);
        ArrayList<Integer> row4=new ArrayList<>();
        row4.add(1);
        row4.add(1);
        row4.add(1);
        row4.add(1);
        mat.add(row1);
        mat.add(row2);
        mat.add(row3);
        mat.add(row4);
        System.out.println(coverageOfMatrix(mat));
    }
}
