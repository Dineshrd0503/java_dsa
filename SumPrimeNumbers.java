public class SumPrimeNumbers {
    public static void main(String[] args) {
        int n=34;
        if(primesum(n))
        System.out.println("yes it is sum of two primes");
        else
        System.out.println("no it is not sum of two primes");

    
}
public static boolean primesum(int n){
    for(int i=2;i<=n/2;i++){
        if(isPrime(i) && isPrime(n-i))
        return true;
    }
    return false; 
}

public static boolean isPrime(int num){
    if(num<=1)
    return false;
    for(int i=2;i<=Math.sqrt(num);i++){
        if(num%i==0)
        return false;
    }
    return true;
 
}
}