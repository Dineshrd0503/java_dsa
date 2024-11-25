package recursion;

public class TowersOfHanoi {
    public static void main(String[] args) {
        int disks = 3;
        System.out.println("solving otwers of hanoin using recurison");
        solve(disks, "A", "C", "B");
    }
    public static void solve(int disks, String source,String destination,String helper){
        if(disks==1){
            System.out.println("move disk 1 from "+source +" to "+destination);
            return;
        }
        solve(disks-1, source, helper, destination);
        System.out.println("move disk "+disks +" from "+source +" to "+destination);
        solve(disks-1, helper, destination, source);

    }
}
