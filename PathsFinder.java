public class PathsFinder {
    public static void main(String[] args) {
        //calcualtes total right and downwared paths
        int m=15,n=30;
        long result=pathscalculator(0,0,m,n);
        System.out.println("no.of paths are "+result);
    }
    public static long pathscalculator(int i,int j,int m,int n){
        if(i==m||j==n){
        return 0;
        }
        if(i==m-1&&j==n-1){
        return 1;
        }
        long downpaths=pathscalculator(i+1, j, m, n);
        long rightpaths=pathscalculator(i, j+1, m, n);
        return downpaths+rightpaths;

    }
}
