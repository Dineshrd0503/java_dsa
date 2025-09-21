package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem statement
-----------------

You are given three rods (numbered 1 to 3), and ‘N’ disks initially placed on the first rod, one on top of each other in increasing order of size ( the largest disk is at the bottom). You are supposed to move the ‘N’ disks to another rod(either rod 2 or rod 3) using the following rules and in less than 2 ^ (N) moves.

    1. You can only move one disk in one move.
    2. You can not place a larger disk on top of a smaller disk.
    3. You can only move the disk at the top of any rod.


**Note :**

    You may assume that initially, the size of the ‘i’th disk from the top of the stack is equal to ‘i’, i.e. the disk at the bottom has size ‘N’, the disk above that has size ‘N - 1’, and so on. The disk at the top has size 1.


**Example :**

![Example](https://files.codingninjas.in/tower_of_hanoi-6667.jpg)

Detailed explanation ( Input/output format, Notes, Images )

**Input Format :**

    The first line contains a single integer ‘T’ denoting the number of test cases. The test cases follow.

    The first line of each test case contains a single integer ‘N’ denoting the number disks.


**Output Format :**

    For each test case, return a 2-D array/list, where each row of the array should contain exactly two integers. The first integer should be the number of the rod from where the topmost disk is to be removed and the second integer should denote the number of the rod where the removed disk is to be placed. If you have correctly moved all the disks from rod 1 to either rod 2 or rod 3 the output will be ‘1’ otherwise the output will be ‘0’.

    The output of every test case will be printed in a separate line.


**Note :**

    You don’t need to print anything; It has already been taken care of.


**Constraints :**

    1 <= T <= 5
    1 <= N <= 12

    Where ‘T’ denotes the number of test cases, ‘N’ denotes the number of disks.

    Time Limit: 1 sec
*/


public class TowersOfHanoii2 {

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        help(result, n, 1, 3, 2);
        return result;
    }

    static void help(ArrayList<ArrayList<Integer>> result, int n, int source, int destination, int helper) {
        if (n == 0) {
            return;
        }
        help(result, n - 1, source, helper, destination);

        ArrayList<Integer> move = new ArrayList<>();
        move.add(source);
        move.add(destination);
        result.add(move);

        help(result, n - 1, helper, destination, source);
    }

    public static void main(String[] args) {
        // Example usage with static input
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;

        System.out.println("Tower of Hanoi for n = " + n1 + ":");
        ArrayList<ArrayList<Integer>> result1 = towerOfHanoi(n1);
        printResult(result1);
        System.out.println("Output: 1"); //Expected output

        System.out.println("\nTower of Hanoi for n = " + n2 + ":");
        ArrayList<ArrayList<Integer>> result2 = towerOfHanoi(n2);
        printResult(result2);
        System.out.println("Output: 1"); //Expected output

        System.out.println("\nTower of Hanoi for n = " + n3 + ":");
        ArrayList<ArrayList<Integer>> result3 = towerOfHanoi(n3);
        printResult(result3);
        System.out.println("Output: 1"); //Expected output
    }

    private static void printResult(ArrayList<ArrayList<Integer>> result) {
        for (ArrayList<Integer> move : result) {
            System.out.println(move.get(0) + " " + move.get(1));
        }
    }

}