package strings;
//Given a string and number of rows ‘n’. Print the string formed by concatenating n rows when the input string is written in row-wise Zig-Zag fashion.
//
//Example 1:
//
//Input:
//str = "ABCDEFGH"
//n = 2
//Output: "ACEGBDFH"
//Explanation:
//Let us write input string in
//Zig-Zag fashion in 2 rows.
//A   C   E   G
//B   D   F   H
//Now concatenate the two rows and ignore
//spaces in every row. We get "ACEGBDFH"
//Example 2:
//
//Input:
//str = "GEEKSFORGEEKS"
//n = 3
//Output: GSGSEKFREKEOE
//Explanation:
//Let us write input string in
//Zig-Zag fashion in 3 rows.
//G       S       G       S
//E   K   F   R   E   K
//E       O       E
//Now concatenate the two rows and ignore spaces
//in every row. We get "GSGSEKFREKEOE"
//Your Task:
//You need not read input or print anything. Your task is to complete the function convert() which takes 2 arguments(string str, integer n) and returns the resultant string.

//Expected Time Complexity: O(|str|).
//Expected Auxiliary Space: O(|str|).
public class ZigZagString {
    String convert(String s, int n)
    {
        if(n==1)
            return s;
        StringBuilder[] rows=new StringBuilder[n];
        for(int i=0;i<n;i++)
            rows[i]=new StringBuilder();
        int currrow=0;
        boolean down=false;
        for(char c:s.toCharArray()){
            rows[currrow].append(c);
            if(currrow==0||currrow==n-1)
                down=!down;
            currrow+=down?1:-1;
        }
        StringBuilder result=new StringBuilder();
        for(StringBuilder row:rows)
            result.append(row);
        return result.toString();
        //code here

    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int n = 3;
        ZigZagString zigZagString = new ZigZagString();
        System.out.println(zigZagString.convert(s, n));
    }
}
