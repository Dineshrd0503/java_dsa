package strings;

/*
Problem Statement:
Given a string ‘S’ representing a date in the “Day Month Year” format (e.g., "27th Apr 1998"), convert it to the “YYYY-MM-DD” format (e.g., "1998-04-27").
Day is of form {"1st", "2nd", ..., "31st"}, month is short text {"Jan", "Feb",..., "Dec"}, year is four digits.
Pad the month and day with a leading zero if required.

Sample Input 1:
1
27th Apr 1998

Sample Output 1:
1998-04-27

*/

import java.util.*;

public class ReformatDate{
    // Mapping month abbreviation to month number
    public static String reformDate(String s) {
        // Write your code here
        String[] arr=s.split(" ");
        String day=arr[0],month=arr[1],year=arr[2];
        day=day.substring(0,day.length()-2);
        switch(month){
            case "Jan": month="01" ;break;
            case "Feb": month="02" ;break;
            case "Mar": month="03" ;break;
            case "Apr": month="04" ;break;
            case "May": month="05" ;break;
            case "Jun": month="06" ;break;
            case "Jul": month="07" ;break;
            case "Aug": month="08" ;break;
            case "Sep": month="09" ;break;
            case "Oct": month="10" ;break;
            case "Nov": month="11" ;break;
            case "Dec": month="12" ;break;

        }
        if(day.length()==1) day="0"+day;
        return year+"-"+month+"-"+day;
    }

    // Main method with sample tests and dry run comments
    public static void main(String[] args) {
        // Sample Testcases
        System.out.println(reformDate("27th Apr 1998")); // 1998-04-27
        System.out.println(reformDate("1st Jan 2020"));  // 2020-01-01
        System.out.println(reformDate("3rd Dec 2000"));  // 2000-12-03
        System.out.println(reformDate("12th Aug 2021")); // 2021-08-12

        // Dry Run for input: "3rd Dec 2000"
        // parts = ["3rd","Dec","2000"]
        // day = "3" -> pad to "03"
        // month = "12"
        // year = "2000"
        // output: "2000-12-03"
    }
}
