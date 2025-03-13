package codingninjas7dayschallenge;

//A prime adjacent is a number that is adjacent to two prime numbers. Two numbers are considered adjacent to each other if the absolute difference between them is 1.
//
//For Example:
//        4 is a prime adjacent because it is adjacent to the numbers 3 and 5, which are prime numbers.
//Your task is to find out if the number given to you is prime adjacent or not.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 1000
//        2 <= N <= 10^6
//
//Time limit: 1 sec
//Sample Input 1:
//        2
//        4
//        2
//Sample Output 1 :
//Yes
//        No
//Explanation :
//For test case 1:
//        4 is a prime adjacent because its adjacent numbers, 3 and 5 are prime numbers.
//
//For test case 2:
//In case of 2, the adjacent numbers are 1 and 3, out of which 1 is not prime but 3 is
//prime.
//
//        By definition, a number is a prime adjacent only if both of its adjacent numbers are prime numbers. So, 2 is not a prime adjacent.
//Sample Input 2:
//        3
//        3
//        18
//        25
//Sample Output 2 :
//No
//        Yes
//No



public class CheckPrimeAdjacent {
    public static boolean checkPrimeAdjacent(int n)
    {
        // Write your code here.
        return checkprime(n-1)&&checkprime(n+1);
    }
    private static boolean checkprime(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Check prime adjacent");
        System.out.println(checkPrimeAdjacent(10));
    }
}
