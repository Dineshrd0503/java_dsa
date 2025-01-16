package codingninjas;

import java.util.ArrayList;
import java.util.Stack;

//Problem statement
//There are contestants standing in a row. Each contestant is assigned a rating, which is an integer. A contestant supports all those whose rating is greater than their rating.
//
//Now for each contestant standing in the row, you need to tell the rating of its closest supporter on the left.
//
//If no supporter is there, store -1 in that place.
//
//        For Example
//Consider the row : [ 3, 1, 5, 12, 10], with 1-based indexing -
//For index 3, there would be 2 supporters, index 1 and index 2, but index 2 is closest, hence for index 3, we will store ‘1’ (Rating of contestant).
//For index 5, we will store ‘5’(at index 3).
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints
//1 <= T <= 50
//        1 <= N <= 10000
//        -10^9 <= data <= 10^9
//
//Where ‘data’ represents the given row elements.
//
//Time limit: 1 sec
//Sample Input 1
//        2
//        5
//        3 1 5 12 10
//        6
//        9 8 1 2 5 5
//Sample Output 1
//        -1 -1 1 5 5
//        -1 -1 -1 1 2 2
//Explanation of Sample Input 1(1-based indexing)
//Test Case 1:
//
//There is no contestant on the left of 1st contestant
//No contestant’s rating is less than this player, hence -1.
//Both ratings 3 and 1 are smaller than the current rating, but ‘1’ is closest.
//All ratings are small, but the nearest one is ‘5’.
//For ‘10’, the nearest rating is ‘5’, as contestant 4 is not a supporter.
//
//Test Case 2:
//
//For the first '3' contestants, there is no supporter.
//For contestant '4', the only supporter is contestant '3', with the rating '1'.
//Both ratings '1' and '2' are smaller than the current rating, but ‘2’ is closest.
//The rating of contestant '5' is not less than the current contestant, hence the closest supporter is 4th, with a rating of '2'.
//Sample Input 2
//        2
//        5
//        3 2 1 4 5
//        4
//        1 2 3 4
//Sample Output 2
//        -1 -1 -1 1 4
//        -1 1 2 3


public class FindTheNearestSupporter {
    public static ArrayList<Integer> prevSmall(ArrayList<Integer> arr, int n)
    {
        // Write Your Code Here.
        ArrayList<Integer> result=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&stack.peek()>=arr.get(i))
                stack.pop();
            if(stack.isEmpty())
                result.add(-1);
            else
                result.add(stack.peek());
            stack.push(arr.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(4);
        arr.add(5);
        arr.add(2);
        arr.add(10);
        arr.add(8);
        System.out.println(prevSmall(arr,5));
    }
}
