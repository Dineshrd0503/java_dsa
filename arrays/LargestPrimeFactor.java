package arrays;

import java.util.*;
import java.io.*;

/*
Problem statement
-----------------
You are given a positive integer ‘n’. Your task is to find the largest prime factor of this given positive integer.

Note :
    If there is no prime factor of a given integer, then print -1.

Detailed explanation ( Input/output format, Notes, Images )

Input Format :
    The first line of input contains an integer ‘T’ denoting the number of test cases.

    The first and only line of each test case contains a positive integer ‘n’.

Output Format :
    For each test case, print the largest prime factor of the given positive integer in a separate line.

Note :
    You do not need to print anything, it has already been taken care of. Just implement the given function.

Constraints :
    1 <= T <= 50
    1 <= n <= 10^9

    Where ‘T’ is the number of test cases and ‘n’ is the size of the array.

    Time Limit: 1 sec

##### Sample Input 1 :

    2
    5
    27


##### Sample Output 1 :

    5
    3


##### Explanation of the Sample Input1 :

    Test case 1:
    5 is a prime number, so its largest prime is 5 itself

    Test case 2:
    Prime factorization of 27 is 3*3*3.
    Thus, it's an only prime factor is 3.

##### Sample Input 2 :

    2
    14
    30


##### Sample Output 2 :

    7
    5


##### Explanation of the Sample Input 2 :

    Test case 1 :
    Prime factorization of 14 is 2*7.
    It has two prime factors, 2 and 7, the largest prime number out of them is 7.

    Test case 2 :
    Prime factorization of 30 is 2*3*5.
    It has three prime factors, 2, 3, and 5, the largest of them is 5.
*/
public class LargestPrimeFactor {

    public static int largestPrimeFactor(int n) {
        // Write your code here.
        int prime = -1;
        while (n % 2 == 0) {
            prime = 2;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                prime = i;
                n /= i;
            }
        }
        if (n > 1) {
            prime = n;
        }
        return prime;
    }
    public static void main(String[] args) {
        int n=25;
        System.out.println(largestPrimeFactor(n));
        int a=2;
        System.out.println(largestPrimeFactor(a));
        System.out.println(largestPrimeFactor(44));
        System.out.println(largestPrimeFactor(93));
    }
}