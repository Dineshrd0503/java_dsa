public class PowerOfNumber {
    public static int powerOfNumber(int base, int exponent) {
        if (exponent == 0) 
            return 1;
        else if(base==0)
            return 0;
        else 
            return base * powerOfNumber(base, exponent - 1);
        
    }
    
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = powerOfNumber(base, exponent);
        System.out.println("The power of " + base + " raised to the " + exponent + " is: " + result);
    }
    
}
