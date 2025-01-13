package codingninjas;
//There are three rows (‘M = 3’) in the zig-zag pattern. Row one contains ‘CNN’, row two contains ‘OIGIJS’, and row three contains ‘DNA’. After concatenating the three rows, we get the string ‘CNNOIGIJSDNA’. So, the answer is ‘CNNOIGIJSDNA’.
//Note:
//        1. The string ‘STR’ consists of capital letters only (i.e., characters from ‘A-Z’).
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10^2
//        1 <= N <= 10^3
//        1 <= M <= N
//‘STR’ contains only ‘A-Z’ characters.
//
//Time Limit: 1 second
//Sample Input 1:
//        2
//        7 3
//ABCDEFG
//5 2
//NINJA
//Sample Output 1:
//AEBDFCG
//        NNAIJ
//Explanation For Sample Input 1:
//Test Case 1:
//
//There are three rows (‘m = 3’) in the zig-zag pattern. Row one contains ‘AE’, row two contains ‘BDF’, and row three contains ‘CG’. After concatenating the three rows, we get the string ‘AEBDFCG’. So, the answer is ‘AEBDFCG’.
//
//Test Case 2:
//
//There are two rows (‘m = 2’) in the zig-zag pattern. Row one contains ‘NNA’, and row two contains ‘IJ’. After concatenating the two rows, we get the string ‘NNAIJ’. So, the answer is ‘NNAIJ’.
//Sample Input 2:
//        2
//        4 2
//PQRS
//6 6
//ZIGZAG
//Sample Output 2:
//PRQS
//        ZIGZAG

public class ZigZagString {
    public static String zigZagString(String str, int n, int m) {
        // Write your code here.
        if(m==1)
            return str;
        StringBuilder[] rows=new StringBuilder[m];
        for(int i=0;i<m;i++)
            rows[i]=new StringBuilder();
        int currrow=0;
        boolean down=false;
        for(char c:str.toCharArray()){
            rows[currrow].append(c);
            if(currrow==0||currrow==m-1)
                down=!down;
            currrow+=down?1:-1;

        }
        StringBuilder result=new StringBuilder();
        for(StringBuilder row:rows)
            result.append(row);
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int n = 3;
        int m = 4;
        System.out.println(zigZagString(str, n, m));
    }



}
