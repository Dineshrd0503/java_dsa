package codingninjas;
//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//
//
//
//Example 1:
//
//Input: x = 2.00000, n = 10
//Output: 1024.00000
//Example 2:
//
//Input: x = 2.10000, n = 3
//Output: 9.26100
//Example 3:
//
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
public class PowerOfN {
    public static double myPow(double x, int n) {
        long power=n;
        double result=1.0;
        if(power<0){
            power=-power;
            x=1/x;
        }
        while(power>0){
            if(power%2!=0)
                result*=x;
            x*=x;
            power/=2;
        }

        return result;
    }

    public static void main(String[] args) {
        PowerOfN powerOfN = new PowerOfN();
        System.out.println(powerOfN.myPow(2.0, 10)); // 1024.0
        System.out.println(powerOfN.myPow(2.10000, 3)); // 9.26100
        System.out.println(powerOfN.myPow(2.0, -2)); // 0.25
    }

}
