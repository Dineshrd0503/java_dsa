package codingninjas;

//You are given two positive integers 'n' and 'm'. You have to return the 'nth' root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.
//
//
//
//Note:
//        'nth' root of an integer 'm' is a number, which, when raised to the power 'n', gives 'm' as a result.
//
//
//        Example:
//Input: ‘n’ = 3, ‘m’ = 27
//
//Output: 3
//
//Explanation:
//        3rd Root of 27 is 3, as (3)^3 equals 27.
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        3 27
//
//
//Sample Output 1:
//        3
//

//Explanation For Sample Input 1:
//        3rd Root of 27 is 3, as (3)^3 equals 27.

//
//Sample Input 2:
//        4 69
//
//
//Sample Output 2:
//        -1
//
//
//Explanation For Sample Input 2:
//        4th Root of 69 is not an integer, hence -1.
//
//
//Expected Time Complexity:
//Try to do this in O(log(n+m)).
//
//
//Constraints:
//        1 <= n <= 30
//        1 <= m <= 10^9
//
//Time Limit: 1 sec.

public class NthRootOfM {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int left=1,right=m;
        double epilson=1e-7;
        while(left<=right){
            int mid=left+(right-left)/2;
            double power=Math.pow(mid,n);
            if(Math.abs(power-m)<epilson)
                return mid;
            else if(power<m)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("finding the nth root of m");
        System.out.println(NthRoot(2,16));
    }
}
