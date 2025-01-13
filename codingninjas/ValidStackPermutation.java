package codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
//You have been given two arrays having an equal number of elements. You have to find whether one array is the valid stack permutation of the other. An array is said to be a valid stack permutation of the other if and only if after applying some push and pop operations onto the sequence of elements in that array, will result in the other array.
//
//Example:
//
//Consider array : 2 4 6.
//Valid stack permutations are as follows:
//        2 4 6
//push ‘2’
//pop ‘2’
//push ‘4’
//pop ‘4’
//push ‘6’
//pop ‘6’
//        2 6 4
//push ‘2’
//pop ‘2’
//push ‘4’
//pop ‘6’
//push ‘6’
//pop ‘4’
//        4 2 6
//push ‘2’
//pop ‘4’
//push ‘4’
//pop ‘2’
//push ‘6’
//pop ‘6’
//        4 6 2
//push ‘2’
//pop ‘4’
//push ‘4’
//pop ‘6’
//push ‘6’
//pop ‘6’
//        6 4 2
//push ‘2’
//pop ‘4’
//push ‘6’
//pop ‘6’
//push ‘4’
//pop ‘6’
//
//Now, If the other array is [2,4,6], [2,6,4], [4,2,6], [4,6,2], or [6,4,2] then the answer is “YES” otherwise “NO”.
//Note:
//Please note that the arrays will only contain unique elements.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= N <= 10000
//        0 <= FIRST[i], OTHER[i] <= 10^5
//
//Where 'FIRST[i]' and 'OTHER[i]' denote the value of the i-th element of the input arrays.
//
//Time limit: 1 sec
//Sample Input 1:
//        2
//        3
//        2 4 6
//        4 6 2
//        3
//        2 4 6
//        6 2 4
//Sample Output 1:
//YES
//        NO
//Explanation of Sample Output 1:
//In test case 1, The explanation is already given in the example.
//
//In test case 2, The explanation is already given in the example.
//Sample Input 2:
//        2
//        3
//        2 4 6
//        2 3 4
//        1
//        5
//        5
//Sample Output 2:
//NO
//        YES
//Explanation for Sample Output 2:
//In test case 1, the 'FIRST' array does not contain 3 but the 'OTHER' array contains 3. So, the other is not the valid stack permutation.
//
//In test case 2, the only array containing ‘5’ as an element is the valid stack permutation of the array [5].

public class ValidStackPermutation {
    public static boolean validStackPermutation(ArrayList<Integer> first, ArrayList<Integer> second){
        // Write your code here.
        if(first.size()!=second.size())
            return false;
        Stack<Integer> stack=new Stack<>();
        int j=0;

        for(int i=0;i<first.size();i++){
            stack.push(first.get(i));
            while(!stack.isEmpty()&&j<second.size()&&stack.peek().equals(second.get(j))){
                stack.pop();
                j++;
            }

        }
        return j==second.size();

    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(2, 1, 3));
        System.out.println(validStackPermutation(first, second));
    }

}
