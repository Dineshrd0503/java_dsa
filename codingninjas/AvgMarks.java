package codingninjas;
//You are given the name of a student in the form of a character ‘firstLetterOfName’ and 3 integers ‘M1’, ‘M2’, ‘M3’ representing the marks of the student in 3 subjects. You have to print the ‘firstLetterOfName’ of the student and the average marks obtained by the student.
//
//        Note: You need to print the integer part of the average only and neglect the decimal part.
//
//For Example :
//If ‘firstLetterOfName’ = ‘K’, ‘M1’ = 10, ‘M2’ = 6 and ‘M3’ = 9, then the average marks would be around 7.67. Hence, the output should be as follows:
//K 7
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= T <= 10
//        ‘A’ <= ‘firstLetterOfName’ <= ‘Z’
//        0 <= M1 <= 100
//        0 <= M2 <= 100
//        0 <= M3 <= 100
//
//Time Limit: 1 sec
//Sample Input 1:
//        2
//A
//3 4 6
//T
//7 3 8
//Sample Output 1:
//A 4
//T 6
//Explanation For Sample Input 1:
//For sample case 1, average marks of the student are (3 + 4 + 6)/3 = 4.33 and his/her first character of the name is ‘A’. Therefore, the output is : A 4
//For sample case 2, average marks of the student are (7 + 3 + 8)/3 = 6 and his/her first character of the name is ‘T’. Therefore, the output is : T 6
//Sample Input 2:
//        2
//Q
//10 34 96
//P
//71 80 3
//Sample Output 2:
//Q 46
//P 51
//Explanation For Sample Input 2:
//For sample case 1, average marks of the student are (10 + 34 + 96)/3 = 46.67 and his/her first character of the name is ‘Q’. Therefore, the output is : Q 46
//For sample case 2, average marks of the student are (71 + 80 + 3)/3 = 51.33 and his/her first character of the name is ‘P’. Therefore, the output is : P 51

public class AvgMarks {
    static class Pair{
        char firstLetterOfName;
        int avgMarks;

             Pair(char firstLetterOfName, int avgMarks){
                 this.firstLetterOfName = firstLetterOfName;
                 this.avgMarks = avgMarks;
      }
    }
    public static Pair averageMarks(char firstLetterOfName, int m1, int m2, int m3) {
        // Write your code here.
        int avg=(m1+m2+m3)/3;
        return new Pair(firstLetterOfName,avg);

    }
    public static void main(String[] args) {
        Pair pair = averageMarks('A', 90, 85, 95);
        System.out.println("First letter of name: " + pair.firstLetterOfName);
        System.out.println("Average marks: " + pair.avgMarks);
    }
}
