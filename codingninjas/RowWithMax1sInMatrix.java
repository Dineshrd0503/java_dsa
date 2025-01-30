package codingninjas;

import java.util.ArrayList;

//Problem statement
//You are given a matrix ‘ARR’ with dimensions ‘N’ * ‘M’ and containing only 0s and 1s where each row is sorted.
//
//Your task is to find the index of the row with a maximum number of 1s in it. Rows and columns are 0-indexed based.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 1000
//        1 <= N, M <= 500
//
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//        1 1
//        1
//        3 3
//        0 0 1
//        1 1 1
//        0 1 1
//Sample Output 1:
//        0
//        1
//Explanation for sample input 1:
//For the first test case,
//Since the matrix has one row and one column. The only row, i.e., the 0th row, contains a 1. So the output is 0.
//
//For the second test case,
//Since the matrix has three rows and three columns. The number of ones in the 0th row is 1. The number of ones in the 1st row is 3, and the number of ones in the 2nd row is 2. So the output is 1.
//Sample Input 2:
//        2
//        3 2
//        0 1
//        0 1
//        0 0
//        4 4
//        0 0 1 1
//        0 0 0 0
//        1 1 1 1
//        0 0 1 1
//Sample Output 2:
//        0
//        2
//Explanation for sample input 2:
//For the first test case,
//Since the matrix has 3 rows and 2 columns. The number of ones in the 0th row is 1. The number of ones in the 1st row is 1, and the number of ones in the 2nd row is 0. So the output is 0.
//
//For the second test case,
//Since the matrix has 4 rows and 4 columns. The number of ones in the 0th row is 2. The number of ones in the 1st row is 0. The number of ones in the 2nd row is 4 and the number of ones in the 3rd row is 2. So the output is 2.

public class RowWithMax1sInMatrix {
    public static int maxOne(ArrayList<ArrayList<Integer>> arr) {
        int max=0;
        int index=-1;
        for(int i=0;i<arr.size();i++){
            int count_ones=arr.get(i).size()-findindex(arr.get(i),0,1);
            if(count_ones>max){
                max=count_ones;
                index=i;
            }


        }
        return index;

        // Write your code here
    }
    private static int findindex(ArrayList<Integer> arr,int start,int value){
        int low=start,high=arr.size()-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)>=value){

                high=mid-1;


            }
            else
                low=mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        ArrayList<Integer> row1=new ArrayList<>();
        row1.add(0);
        row1.add(1);
        row1.add(1);
        row1.add(1);
        ArrayList<Integer> row2=new ArrayList<>();
        row2.add(0);
        row2.add(0);
        row2.add(1);
        row2.add(1);
        ArrayList<Integer> row3=new ArrayList<>();
        row3.add(1);
        row3.add(1);
        row3.add(1);
        row3.add(1);
        arr.add(row1);
        arr.add(row2);
        arr.add(row3);
        System.out.println(maxOne(arr));
    }
}
