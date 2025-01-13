public class PossibleInvitations{
    public static void main(String[] args){
        //calculating the possible ways to invite 4 peoeple as single or as paris
        int n=4;
        int result=countways(n);
        System.out.println("Number of ways to invite friends: "+result);
    }
    public static int countways(int n){
        if(n<=1)
            return 1;
        int way1=countways(n-1);
        int way2=(n-1)*countways(n-2);
        return way1+way2;
}
}