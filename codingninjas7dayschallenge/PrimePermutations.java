package codingninjas7dayschallenge;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;



import java.util.ArrayList;
import java.util.List;

public class PrimePermutations {
    public static void main(String[] args) {
        int[] testCases = {3, 4};
        for (int n : testCases) {
            System.out.println(findPrimePermutations(n));
        }
    }

    public static int findPrimePermutations(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> composites = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            } else if (i > 1) {
                composites.add(i);
            }
        }

        int p = primes.size();
        int c = composites.size();

        return (int) (factorial(p) * factorial(c));
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}