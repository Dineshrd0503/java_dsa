package geeksforgeeks;

//Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.
//
//        Note: In the case of a single vertical line it will not be able to hold water.
//
//        Examples:
//
//Input: arr[] = [1, 5, 4, 3]
//Output: 6
//Explanation: 5 and 3 are 2 distance apart. So the size of the base is 2. Height of container = min(5, 3) = 3. So, total area to hold water = 3 * 2 = 6.
//Input: arr[] = [3, 1, 2, 4, 5]
//Output: 12
//Explanation: 5 and 3 are 4 distance apart. So the size of the base is 4. Height of container = min(5, 3) = 3. So, total area to hold water = 4 * 3 = 12.
//Input: arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
//Output: 25
//Explanation: 8 and 5 are 5 distance apart. So the size of the base is 5. Height of container = min(8, 5) = 5. So, the total area to hold water = 5 * 5 = 25.
public class ContainerWithMostWater {
    public int maxWater(int arr[]) {
        // Code Here
        int ans=0,curr=0;
        int i=0,j=arr.length-1;
        while(i<j){
            curr=Math.min(arr[i],arr[j])*(j-i);
            ans=Math.max(ans,curr);
            if(arr[i]<arr[j])
                i++;
            else
                j--;
        }
        return ans;
    }
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxWater(arr));
    }
}
