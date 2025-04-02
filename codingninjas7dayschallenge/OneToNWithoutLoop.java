package codingninjas7dayschallenge;

//Problem statement
//You are given an integer ‘n’.
//
//
//
//Your task is to return an array containing integers from 1 to ‘n’ (in increasing order) without using loops.
//
//
//
//        Example:
//Input: ‘n’ = 5
//
//Output: 1 2 3 4 5
//
//Explanation: An array containing integers from ‘1’ to ‘n’ is [1, 2, 3, 4, 5].
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        5
//Sample Output 1 :
//        1 2 3 4 5
//Explanation Of Sample Input 1:
//The array contains all integers from 1 to 5 in ascending order.
//Sample Input 2:
//        2
//Sample Output 2:
//        1 2
//Explanation Of Sample Input 2:
//The array contains all integers from 1 to 2 in ascending order.
//Expected Time Complexity:
//The expected time complexity is O(n), where 'n' is the given integer.
//Constraints:
//        1 <= n <= 10^6
//
//Time Limit: 1-sec




public class OneToNWithoutLoop {
    public static int[] printNos(int n) {
        // Write Your Code Here
        int[] result=new int[n];
        add(result,0,1,n);
        return result;

    }
    private static void add(int[] result,int index,int a,int n){
        if(a>n)
            return;
        result[index]=a;
        add(result,index+1,a+1,n);

    }

    public static void main(String[] args) {
        int n=5;
        int[] result=printNos(n);
        for(int i=0;i<n;i++)
            System.out.print(result[i]+" ");
    }
}
