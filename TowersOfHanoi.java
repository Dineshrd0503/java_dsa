public class TowersOfHanoi{
    public static void main(String[] args) {
        int n =3;
        hanoi(n, 'A', 'B', 'C');
    }
    
    public static void hanoi(int n, char source, char helper, char destination) {
        if(n==1){
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        hanoi(n-1,source,destination,helper);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        hanoi(n-1,helper,source,destination);
    
}
}