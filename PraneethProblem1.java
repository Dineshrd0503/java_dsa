public class PraneethProblem1{
    public static void main(String[] args){
        String num="1231516";
        int oddsum=0;
       for(int i=0;i<=num.length();i++){
        if(i%2==0){
            int n=Character.getNumericValue(num.charAt(i));
            if(n%2!=0)
            oddsum+=n;

        }
    }
    System.out.println(oddsum);
}
}