package codingninjas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.
//
//
//
//There are ‘m’ number of students, and the task is to allocate all the books to the students.
//
//
//
//Allocate books in such a way that:
//
//        1. Each student gets at least one book.
//2. Each book should be allocated to only one student.
//3. Book allocation should be in a contiguous manner.
//
//
//You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
//
//
//
//If the allocation of books is not possible, return -1.
//
//
//
//Example:
//Input: ‘n’ = 4 ‘m’ = 2
//        ‘arr’ = [12, 34, 67, 90]
//
//Output: 113
//
//Explanation: All possible ways to allocate the ‘4’ books to '2' students are:
//
//        12 | 34, 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12’, and student two is ‘34+ 67+ 90 = 191’, so the maximum is ‘max(12, 191)= 191’.
//
//        12, 34 | 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 = 46’, and student two is ‘67+ 90 = 157’, so the maximum is ‘max(46, 157)= 157’.
//
//        12, 34, 67 | 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 +67 = 113’, and student two is ‘90’, so the maximum is ‘max(113, 90)= 113’.
//
//We are getting the minimum in the last case.
//
//Hence answer is ‘113’.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        4 2
//        12 34 67 90
//Sample Output 1:
//        113
//Explanation of sample input 1:
//All possible ways to allocate the ‘4’ books to '2' students are:
//
//        12 | 34, 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12’, and student two is ‘34+ 67+ 90 = 191’, so the maximum is ‘max(12, 191)= 191’.
//
//        12, 34 | 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 = 46’, and student two is ‘67+ 90 = 157’, so the maximum is ‘max(46, 157)= 157’.
//
//        12, 34, 67 | 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 +67 = 113’, and student two is ‘90’, so the maximum is ‘max(113, 90)= 113’.
//
//We are getting the minimum in the last case.
//
//Hence answer is ‘113’.
//Sample Input 2:
//        5 4
//        25 46 28 49 24
//Sample Output 2:
//        71
//Explanation of sample input 2:
//All possible ways to allocate the ‘5’ books to '4' students are:
//
//        25 | 46 | 28 | 49 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '46', '28', and '73'. So the maximum is '73'.
//
//        25 | 46 | 28 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '46', '77', and '24'. So the maximum is '77'.
//
//        25 | 46 28 | 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '74', '49', and '24'. So the maximum is '74'.
//
//        25 46 | 28 | 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '71', '28', '49', and '24'. So the maximum is '71'.
//
//We are getting the minimum in the last case.
//
//Hence answer is ‘71’.
//Expected time complexity:
//The expected time complexity is O(n * log(s)), where ‘n’ is the number of integers in the array ‘arr’ and ‘s’ is the sum of all the elements of ‘arr’.
//Constraints:
//        2 <= 'n' <= 10 ^ 3
//        1 <= 'm' <= 10 ^ 3
//        1 <= 'arr[i]' <= 10 ^ 9
//The sum of all arr[i] does not exceed 10 ^ 9.
//
//Where ‘n’ denotes the number of books and ‘m’ denotes the number of students. ‘arr[i]’ denotes an element at position ‘i’ in the sequence.
public class AllocateMinPages {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m>n) return -1;
        int low= Collections.max(arr);
        int high=arr.stream().mapToInt(Integer::intValue).sum();
        while(low<=high){
            int mid=(low+high)/2;
            int students=findcount(arr,mid);
            if(students>m)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }
    public static int findcount(ArrayList<Integer> arr,int pages){
        int students=1;
        int pagescount=0;
        for(int i=0;i<arr.size();i++){
            if(pagescount+arr.get(i)<=pages)
                pagescount+=arr.get(i);
            else{
                students+=1;
                pagescount=arr.get(i);
            }
        }
        return students;

    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 30, 35, 40));
        int n = arr.size();
        int m = 2;
        int ans = findPages(arr, n, m);
        System.out.println("Minimum number of pages: " + ans);
    }
}
