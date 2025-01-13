package geeksforgeeks;

import java.util.Arrays;

public class TripletsEqualToSum {
    public static int countTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        // Code Here
        int n = arr.length, count = 0;
        for (int i = 0; i < n - 2; i++) {
            int fix = arr[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = fix + arr[left] + arr[right];
                if (sum == target) {
                    int ele1 = arr[left];
                    int ele2 = arr[right];
                    int cnt1 = 0, cnt2 = 0;
                    while (left <= right && arr[left] == ele1) {
                        left++;
                        cnt1++;
                    }
                    while (left <= right && arr[right] == ele2) {
                        right--;
                        cnt2++;
                    }
                    if (ele1 == ele2)
                        count += (cnt1 * (cnt1 - 1)) / 2;
                    else
                        count += cnt1 * cnt2;
                } else if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 9, 11, 15};
        int target = 10;
        System.out.println("Count of pairs is " + countTriplets(arr, target));
    }
}

