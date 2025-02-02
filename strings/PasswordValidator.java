package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Problem statement
//Ninjas are trying to hack a system of a terrorist organization so that they can know where they will be going to attack next. But to hack the system and to get access to data they need a password that must satisfy certain conditions as described below:
//
//        1) Length of the password must be between 8 to 15 characters.
//2) At least one digit (0-9), one lowercase letter (a-z), one uppercase letter (A-Z) and one special character (%, ^, &, #, *, %, etc) must be present.
//3) Password must not contain any space.
//You are given a string ‘STR’, help ninjas to find whether it's a valid password or not.
//
//For example :
//
//Given ‘STR’ =  “Codingninja#1” As it satisfies all the above conditions so it is a valid password and therefore you have to return true.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//        3
//CODiNGNinja+1
//abcXyz 123
//itsnotValid1
//Sample Output 1:
//Valid
//Not Valid
//Not Valid
//Explanation of Sample Input 1:
//Test Case 1 :
//Given ‘STR’ = CODiNGNinja+1
//As we can see that this string satisfies all the given conditions in the problem.
//        Therefore, it's a valid password.
//
//Test Case 2 :
//Given ‘STR’ = abcXyz 123
//As the given string contains a space, so it's not a valid password.
//
//Test Case 3:
//Given ‘STR’ =  itsnotValid1
//As the string does not contain any special character, so it’s not a valid password.
//Sample Input 2:
//        3
//        &1CodingISBest
//Ab@3
//HEllo@World#0
//Sample Output 2:
//Valid
//Not Valid
//Valid



public class PasswordValidator {
    public static boolean isValid(String str) {
        if(str.contains(" "))
            return false;


        // Write your code here.
        String pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^%_!@#$&*()/+-=;:.''?]).{8,15}$";
        Pattern p= Pattern.compile(pattern);
        Matcher r=p.matcher(str);
        return r.matches();


    }
    public static void main(String[] args) {
        System.out.println("validating the password");
        String str="Hello@123";
        System.out.println(isValid(str));
    }
}
