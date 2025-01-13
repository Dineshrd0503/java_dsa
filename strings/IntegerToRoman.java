package strings;
//Given an integer ‘N’, the task is to find its corresponding Roman numeral.
//
//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//        Symbol      Value
//I           1
//V           5
//X           10
//L           50
//C           100
//D           500
//M           1000
//Sample Input 1 :
//        2
//        3
//        12
//Sample Output 1 :
//III
//        XII
//Explanation For Sample Input 1 :
//For the first test case, 3 is written as III in Roman numeral, just three one’s added together.
//
//For the second test case, the number 12 can be represented as XII, which is simply X + II.
//Sample Input 2 :
//        2
//        40
//        27
//Sample Output 2 :
//XL
//        XXVII
//Explanation For Sample Input 2 :
//For the first test case, 40 is written as XL in Roman numeral, which is L - X.
//
//For the second test case, the number 27 can be represented as XXVII, which is simply X + X + V + II.
public class IntegerToRoman {
    public static String intToRoman(int num) {
        // Write your code here.
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                sb.append(symbols[i]);
                num-=values[i];
            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num)); // Output: MCMXCIV

    }
}
