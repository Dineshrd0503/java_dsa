package leetcode;
//Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.
//
//
//
//Example 1:
//
//Input: s = "1001"
//Output: false
//Explanation: The ones do not form a contiguous segment.
//        Example 2:
//
//Input: s = "110"
//Output: true
public class OnesSegment {
    public boolean checkOnesSegment(String s) {
        boolean count=false,max=false;
        for(char c:s.toCharArray()){
            if(c=='1'){
                if(!count){
                    count=true;
                    if(max)
                        return false;
                    max=true;

                }
            }
            else
                count=false;
        }
        return max;

    }
    public static void main(String[] args) {
        OnesSegment onesSegment=new OnesSegment();
        System.out.println(onesSegment.checkOnesSegment("1001")); // true
        System.out.println(onesSegment.checkOnesSegment("110")); // false
    }
}
