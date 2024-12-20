package codingninjas;
//Ninja was given an integer ‘N’. For each number from ‘0’ to ‘N’, he must print the number of set bits present in its binary representation.
//
//For example:
//
//The binary representation of ‘5’ is 101. Therefore the number of set bits is 2.
//Sample Input-1
//        2
//        3
//        5
//Sample Output-1
//        0 1 1 2
//        0 1 1 2 1 2
//Explanation for Sample Input 1:
//For test case 1:
//The binary representation of 0 is ‘0’. Hence the total set bit is 0.
//The binary representation of 1 is ‘1’. Hence the total set bit is 1.
//The binary representation of 2 is ‘10’. Hence the total set bit is 1.
//The binary representation of 3 is ‘11’. Hence the total set bit is 2.
//Sample Input -2
//        2
//        0
//        2
//Sample Output -2
//        0
//        0 1 1

public class SetBitsForN {
    public static int[] count(int n)
    {
        int[] result=new int[n+1];
        for(int i=0;i<=n;i++)
            result[i]=Integer.bitCount(i);

        // Write your code here
        return result;
    }
    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1); // Remove the rightmost set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = count(n);

        for(int num : arr)
            System.out.print(num + " ");
        System.out.println("using while loop and bitwise opearortd");
        for(int num : arr)
            System.out.print(countSetBits(num) + " ");

    }
}
