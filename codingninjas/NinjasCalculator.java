package codingninjas;
//Ninja and his friends go to the park every day. But now, due to his homework, he wasn’t able to go to the park with his friends. So when he figures out, he notes that a lot of time is consumed in doing maths homework where he has to convert some real number to a binary string. So he is deciding to build a calculator which can convert real numbers to the binary string.
//
//So help our Ninja to write a code for the calculator, which can convert the real numbers into a binary string and save his time to join his friends in the park.
//
//So your task is to write a code that can convert real numbers between ‘0’ and ‘1’into a binary string.
//
//        For example, you have given a number “0.750” so you have to convert it in its binary form that is “0.110”
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        2
//        0.625
//        0.72
//Sample Output 1 :
//        0.101
//ERROR
//Explanation Of Sample Input 1 :
//Test Case 1:
//In the first line, there is the number of test cases i.e., 1, and in the next line ‘0.625’ is the real number in a decimal form which we have to convert into a binary string.
//
//        Here, we have started with multiplying the number that is ‘N’with ‘2’ and hence write its binary number like
//String s= ‘0’+ ‘.’+ ‘1’+ ‘0’+ ‘1’   =[0.101].
//
//Test case 2:
//
//Here the number is “0.72” on multiplication with 2 we see we didn’t get its equivalent Binary number or we can say that we weren’t able to convert our number into binary form up to the 32 characters as 32 can be the maximum length of our string so we return our string as “ERROR”.
//Sample Input 2 :
//        2
//        0.248
//        0.50
//Sample Output 2 :
//ERROR
//0.1
public class NinjasCalculator {
    public static String toBinaryCalculator(double num) {
        StringBuilder binary=new StringBuilder("0.");
        int maxlength=32;
        while(num>0){
            if(binary.length()>=maxlength)
                return "ERROR";
            num*=2;
            if(num>=1){
                binary.append("1");
                num-=1;

            }
            else
                binary.append("0");
        }
        return binary.toString();
        // Write Your Code here
    }

    public static void main(String[] args) {
        System.out.println(toBinaryCalculator(10.5)); // Output: 1010.11001100110011001100110011
        System.out.println(toBinaryCalculator(0.7)); // Output: 0.111111111111111111111111111111
        System.out.println(toBinaryCalculator(1000000000000000000000000000000.0)); // Output: ERROR
    }

}
