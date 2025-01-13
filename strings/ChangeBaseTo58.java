package strings;
//You are given a number N. Your goal is to convert the number into base 58.
//
//The Base58 alphabet consists of the following characters: “123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz”
//
//Each byte value from 0 to 57 maps to the alphabet above.
//
//Conversion Eg: ( according to above mapping).
//
//Base 10 | Base 58
//        0       |     1
//        1       |     2
//        10      |     A
//20      |     L
//30      |     W
//53      |     u
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 50
//        0 <= N <= 10 ^ 4
//
//Time limit: 1 sec.
//Sample Input 1:
//        2
//        10
//        67
//Sample Output 1:
//B
//2A
//Explanation for Sample Input 1:
//In test case 1:
//
//If we represent 10 in powers of 58, it will be, 10 = 10*(58^0)
//        10 in base 10 corresponds to B in base 58 ( according to the above mapping).
//Thus our answer is: B
//
//In test case 2:
//
//If we represent 66 in powers of 58, it will be, 67 = 1*(58^1) + 9*(58^0)
//        1 in base 10 corresponds to 2 in base 58, 9 in base 10 corresponds to A in base 58.
//Thus our answer is: 2A
//Sample Input 2:
//        3
//        4364
//        1786
//        6978
//Sample Output 2:
//        2JF
//        Xo
//35K
public class ChangeBaseTo58 {
    private static final String base="123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    public static String encodeBase58(int n){
        // Write your code here
        if(n==0)
            return String.valueOf(base.charAt(0));
        StringBuilder sb=new StringBuilder();
        while(n>0){
            int r=n%58;
            sb.append(base.charAt(r));
            n/=58;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(encodeBase58(1000000000)); // Expected: "1010101010"
    }
}
