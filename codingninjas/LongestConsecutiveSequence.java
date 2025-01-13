package codingninjas;
import java.util.Arrays;
//There is an integer array ‘A’ of size ‘N’.
//
//A sequence is successive when the adjacent elements of the sequence have a difference of 1.
//
//You must return the length of the longest successive sequence.
//
//        Note:
//
//You can reorder the array to form a sequence.
//        For example,
//
//Input:
//A = [5, 8, 3, 2, 1, 4], N = 6
//Output:
//        5
//Explanation:
//The resultant sequence can be 1, 2, 3, 4, 5.
//The length of the sequence is 5.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9
//Time Limit: 1 sec

public class LongestConsecutiveSequence {
    public static int longestSuccessiveElements(int []a) {
        int len=1,maxlen=1;
        Arrays.sort(a);
        for(int i=1;i<a.length;i++){
            if(a[i]==a[i-1]+1){
                len++;
            }
            else if(a[i]!=a[i-1]){
                maxlen=Math.max(len,maxlen);
                len=1;

            }
        }
        maxlen=Math.max(len,maxlen);
        return maxlen;
        // Write your code here.
    }

    public static void main(String[] args) {
        int []a={100, 4, 200, 1, 3, 2};
        System.out.println(longestSuccessiveElements(a));
    }

}
