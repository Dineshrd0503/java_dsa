package strings;

public class PeriodicStrings {
    public static boolean isPeriodic(String s) {
        // Write your code here.
        int n=s.length();
        for(int period=1;period<=n/2;period++){
            if(n%period!=0)
                continue;
            String pattern=s.substring(0,period);
            StringBuilder repeat=new StringBuilder();
            for(int i=0;i<n/period;i++)
                repeat.append(pattern);
            if(repeat.toString().equals(s))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(isPeriodic(s)); // Output: true
    }

}
