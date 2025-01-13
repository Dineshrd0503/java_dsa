package codingninjas;
//Sample Input 1 :
//        4
//        3 4 5 2
//Sample Output 1 :
//        4 3
//Explanation For Sample Input 1 :
//The second largest element after 5 is 4 only, and the second smallest element after 2 is 3.
//Sample Input 2 :
//        5
//        4 5 3 6 7
//Sample Output 2 :
//        6 4
//Expected Time Complexity:
//O(n), Where ‘n’ is the size of an input array ‘a’.
//Constraints:
//        2 ≤ 'n' ≤ 10^5
//        0 ≤ 'a'[i] ≤ 10^9
//
//Time limit: 1 sec
//
//
//Hints:
//        1. Sort the array.
//2. More efficiently, can you use the largest and smallest elements to find the required elements?
public class Get2ndMaxMin {
    public static int[] getSecondOrderElements(int n, int[] a) {
        int secmax = max(n, a);
        int secmin = min(n, a);
        return new int[]{secmax, secmin};
    }

    public static int max(int n, int[] a) {
        int secmax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                secmax = max;  // Update second max before changing max
                max = a[i];    // Update max
            } else if (a[i] > secmax && a[i] != max) {
                secmax = a[i]; // Update second max if a[i] is not max
            }
        }
        return secmax;
    }

    public static int min(int n, int[] a) {
        int secmin = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                secmin = min;  // Update second min before changing min
                min = a[i];    // Update min
            } else if (a[i] < secmin && a[i] != min) {
                secmin = a[i]; // Update second min if a[i] is not min
            }
        }
        return secmin;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] a = {5, 1, 2, 8, 7};

        int[] result = getSecondOrderElements(n, a);
        System.out.println("Second Largest: " + result[0]);
        System.out.println("Second Smallest: " + result[1]);
    }
}

