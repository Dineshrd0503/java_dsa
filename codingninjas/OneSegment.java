package codingninjas;
//Problem statement
//You are given a binary string ‘STR’, containing only zeroes and ones. This string does not contain any leading zero.
//
//Your task is to determine if this string contains at most one contiguous segment of ones.
//
//        Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        1 <= |STR| < 10^6
//Where ‘T’ denotes the number of test cases and |STR| represents the length of the string ‘STR’
//
//Time Limit: 1sec
//Sample Input 1:
//        1
//        11100
//Sample Output 1:
//Yes
//Explanation for sample input 1:
//In this test case, we can observe that the string contains only one contiguous segment of ones. This segment starts at the 0th index and ends at the 2nd index.
//Sample Input 2:
//        1
//        111011
//Sample Output 2:
//No
//Explanation for sample input 2:
//In this case, the string contains two contiguous segments of ones. The first segment starts at the 0th index and ends at the 2nd index. The second segment starts at the 4th index and ends at the 5th index.
public class OneSegment {
    public static boolean oneSegment(String str)
    {
        // Write your code here.
        int count=0;
        boolean segment=false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                if(!segment){
                    count++;
                    segment=true;
                }
            }
            else
                segment=false;
            if(count>1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str="110001";
        System.out.println(oneSegment(str));
    }
}
