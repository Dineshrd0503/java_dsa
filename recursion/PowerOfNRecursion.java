package recursion;



//Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).
//
//Examples:
//
//Input: b = 3.00000, e = 5
//Output: 243.00000
//Input: b = 0.55000, e = 3
//Output: 0.16638
//Input: b = -0.67000, e = -7
//Output: -16.49971
//Constraints:
//
//        -100.0 < b < 100.0
//        -109 <= e <= 109
//Either b is not zero or e > 0.
//        -104 <= be <= 104



public class PowerOfNRecursion {
    double power(double b, int e) {
        // code here
        if(e<0)
            return 1/power(b,-e);
        if(e==1)
            return b;
        if(e==0)
            return 1;
        double halfpower=power(b,e/2);
        if(e%2==0)
            return halfpower*halfpower;
        else
            return b*halfpower*halfpower;
    }
    public static void main(String[] args) {
        PowerOfNRecursion obj= new PowerOfNRecursion();
        System.out.println(obj.power(2,3));
    }
}

