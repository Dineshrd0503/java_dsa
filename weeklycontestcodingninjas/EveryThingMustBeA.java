package weeklycontestcodingninjas;

//Problem Description
//Given a string s of length n, the task is to find the minimum length of the substring that contains all the occurrences of the character 'b'. If the character 'b' is not present in the string, return 0.
//Sample Test Cases
//Test Case 1:  Input:
//n = 5
//s = "ababa"
//Output:
//3
//Explanation:
//The substring "bab" contains all the occurrences of the character 'b' and has a length of 3.
//Test Case 2:  Input:
//n = 5
//s = "aaaaa"
//Output:
//0
//Explanation:
//The character 'b' is not present in the string, so the answer is 0.


public class EveryThingMustBeA {
    public static int minimumLength(int n, String s) {
        // Write your code here
        int firstb=-1,lastb=-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b'){
                if(firstb==-1)
                    firstb=i;
                lastb=i;
            }
        }
        if(firstb==-1)
            return 0;
        return (lastb-firstb+1);

    }

    public static void main(String[] args) {
        System.out.println("minimum length");
        System.out.println(minimumLength(5,"ababa"));
    }
}
